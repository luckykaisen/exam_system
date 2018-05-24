package com.jiyinhui.exam.controller.examination.paper;

import com.jiyinhui.exam.controller.examination.paper.api.*;
import com.jiyinhui.exam.controller.item.api.OptionVO;
import com.jiyinhui.exam.entity.*;
import com.jiyinhui.exam.exception.CreateExaminationPaperException;
import com.jiyinhui.exam.exception.ItemPoolNumberException;
import com.jiyinhui.exam.mapper.ExaminationPaperMapper;
import com.jiyinhui.exam.service.api.IExaminationPaperService;
import com.jiyinhui.exam.service.api.IItemService;
import com.jiyinhui.exam.service.api.IOptionService;
import com.jiyinhui.exam.utility.PagingData;
import com.jiyinhui.exam.utility.PagingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;
@RestController
public class ExaminationPaperController {

    @Autowired
    private IExaminationPaperService examinationPaperService;

    @Autowired
    private IOptionService optionService;

    @Autowired
    private IItemService itemService;

    @Autowired
    private ExaminationPaperMapper examinationPaperMapper;


    @GetMapping(value = "/teacher/examination/paper/rank")
    public SearchExaminationPaperRankResponse rank(@RequestParam("id") Integer themeId) {

        List<ExaminationPaper> examinationPaperList = examinationPaperService.searchExaminationPaperByThemeIdOrderByScoerDesc(themeId);

        SearchExaminationPaperRankResponse response = new SearchExaminationPaperRankResponse();
        if (!CollectionUtils.isEmpty(examinationPaperList)) {
            List<ExaminationPaperRankVO> vos = ExaminationPaperRankVO.toVOs(examinationPaperList);

            response.setRank(vos);
            response.setThemeName(examinationPaperList.get(0).getExaminationTheme().getName());

        }

        return response;
    }


    /**
     * 查询学生做过的试卷
     * @param request
     * @param session
     * @return
     */
    @PostMapping(value = "/student/examination/paper/search")
    public SearchExaminationPaperResponse searchDodingExaminationPaper(@RequestBody PagingRequest request, HttpSession session) {
        UserCO userCO = (UserCO)session.getAttribute("user");

        SearchExaminationPaperResponse response = new SearchExaminationPaperResponse();

        PagingData pagingData = new PagingData(request.getPageNumber(),request.getPageSize(),null);
        List<ExaminationPaper> examinationPaperList = examinationPaperService.searchExaminationPaperByUserId(userCO.getId(), response, pagingData);

        List<ExaminationPaperVO> vos = ExaminationPaperVO.toVOs(examinationPaperList);

        response.setPapers(vos);

        return response;

    }

    /**
     * 查询已做题的答案和历史选项
     */
    @GetMapping(value = "/student/examination/paper/detail")
    public SearchExaminationPaperDetailResponse searchExaminationPaperDodingDetail (@RequestParam("id") Integer themeId, HttpSession session) {

        UserCO userCO = (UserCO) session.getAttribute("user");

        List<ExaminationPaper> examinationPapers = examinationPaperMapper.searchExaminationPaperByUserId(userCO.getId());

        Integer examinationPaperId = null;
        for (ExaminationPaper paper : examinationPapers) {
            if (paper.getExaminationTheme().getId().equals(themeId)) {
                examinationPaperId = paper.getId();
                break;
            }
        }

        // 查询该试卷里的所有题目
        List<ExaminationPaperOption> items = examinationPaperService.searchExaminationPaperOptionByExaminationPaperId(examinationPaperId);

        List<ExaminationPaperItemVO> vos = new ArrayList<>();
        for (ExaminationPaperOption examinationPaperOption : items) {
            // 查询学生选择的答案
            List<ExaminationPaperAnswer> answer = examinationPaperService.searchExaminationPaperAnswerByExaminationPaperOptionId(examinationPaperOption.getId());

            // 查询该题目的所有选项
            List<Option> options = optionService.searchOptionByItemId(examinationPaperOption.getItemPool().getId());

            ExaminationPaperItemVO vo = ExaminationPaperItemVO.toVO(examinationPaperOption, answer, options);

            vos.add(vo);
        }

        SearchExaminationPaperDetailResponse response = new SearchExaminationPaperDetailResponse();
        response.setItems(vos);

        return response;
    }

    /**
     * 随机生成试卷
     * @param themeId
     * @return
     */
    @Transactional
    @GetMapping(value = "/student/examination/paper/create")
    public ExaminationPaperOptionResponse createExaminationPaperOption(@RequestParam("themeId") Integer themeId,
                                                                        HttpSession session,
                                                                        Map<String, Object> map) {

        UserCO userCO = (UserCO)session.getAttribute("user");

        List<ExaminationPaper> examinationPapers = examinationPaperMapper.searchExaminationPaperByUserId(userCO.getId());

        for (ExaminationPaper paper : examinationPapers) {
            if (paper.getExaminationTheme().getId().equals(themeId)) {
                throw new CreateExaminationPaperException("该试题已完成");
            }
        }

        List<ExaminationPaperThemeSection> themeSections = examinationPaperService.searchExaminationPaperThemeSectionByThemeId(themeId);

        // 考试的章节范围
        List<Integer> sectionIds = new ArrayList<>();

        for (ExaminationPaperThemeSection section : themeSections) {
            sectionIds.add(section.getSection().getId());
        }

        List<ItemPool> items = null;
        if (!CollectionUtils.isEmpty(sectionIds)) {
            items = itemService.searchItemIncludeSectionIds(sectionIds);
        }

        // 题目不足15道
        if (!CollectionUtils.isEmpty(items) && items.size() < 1) {
            throw new ItemPoolNumberException("题库数量不足");
        }

        // 在题库中随机取出15道题
        Collections.shuffle(items);

        // 插入试卷记录

        ExaminationPaper paper = new ExaminationPaper();
        paper.setDate(new Date());
        User user = new User();
        user.setId(userCO.getId());

        paper.setUser(user);

        ExaminationTheme theme = new ExaminationTheme();
        theme.setId(themeId);

        paper.setExaminationTheme(theme);

        // 插入试卷简介
        examinationPaperService.insertExaminationPaper(paper);

        List<ExaminationPaperItemOptionVO> vos = new ArrayList<>();

        int number = items.size();
        if (number > 30) {
            number = 30;
        }
        for (int i = 0; i < number; i++) {
            ItemPool itemPool = items.get(i);

            // 试卷中插入题目,返回id
            ExaminationPaperOption paperOption = new ExaminationPaperOption();
            paperOption.setItemPool(itemPool);
            paperOption.setExaminationPaper(paper);

            examinationPaperService.insertExaminationPaperOption(paperOption);

            ExaminationPaperItemOptionVO vo = new ExaminationPaperItemOptionVO();
            vo.setItemId(itemPool.getId());
            vo.setItemName(itemPool.getTopic());
            vo.setPaperOptionId(paperOption.getId());
            vo.setItemStatus(paperOption.getItemPool().getItemStatus().getCode());
            List<Option> options = optionService.searchOptionByItemId(itemPool.getId());

            vo.setOptions(OptionVO.toVOs(options));
            vos.add(vo);
        }

        ExaminationPaperOptionResponse response = new ExaminationPaperOptionResponse();
        response.setItems(vos);
        response.setExaminationPaperId(paper.getId());

        return response;

    }


    /**
     * 学生提交试卷
     * @param request
     */
    @Transactional
    @PostMapping(value = "/student/examination/paper/option/create")
    public void createExaminationPaperAnswer(@RequestBody CreateExaminationPaperAnswerRequest request) {
        List<AnswerRequest> options = request.getOptions();

        List<ExaminationPaperAnswer> answers = new ArrayList<>();
        for (AnswerRequest r : options) {

            for (Integer o : r.getOptionId()) {
                ExaminationPaperAnswer answer = new ExaminationPaperAnswer();
                Option option = new Option();
                option.setId(o);

                answer.setOption(option);

                ExaminationPaperOption paperOption = new ExaminationPaperOption();
                paperOption.setId(r.getPaperOptionId());

                answer.setExaminationPaperOption(paperOption);

                answers.add(answer);

            }

        }
        // 保存答案
        examinationPaperService.insertExaminationPaperAnswer(answers);

        // 计算分数
        // 查询该试卷里的所有题目
        List<ExaminationPaperOption> items = examinationPaperService.searchExaminationPaperOptionByExaminationPaperId(request.getExaminationPaperId());

        double totalScore = 0;

        Map<Integer, List<ExaminationPaperAnswer>> itemAnswer = new HashMap<>();
        for (ExaminationPaperOption examinationPaperOption : items) {
            List<Integer> correct = new ArrayList<>();
            List<Integer> choose = new ArrayList<>();

            // 查询学生选择的答案
            List<ExaminationPaperAnswer> answer = examinationPaperService.searchExaminationPaperAnswerByExaminationPaperOptionId(examinationPaperOption.getId());

            // 查询该题目的所有选项
            List<Option> optionList = optionService.searchOptionByItemId(examinationPaperOption.getItemPool().getId());

            for (ExaminationPaperAnswer a : answer) {
                choose.add(a.getOption().getId());
            }

            for (Option o : optionList) {
                if (Bool.Y.equals(o.getAnswer())) {
                    correct.add(o.getId());
                }
            }

            if (correct.containsAll(choose) && choose.containsAll(correct)) {
                totalScore += examinationPaperOption.getItemPool().getScore();
            }

        }

        ExaminationPaper paper = new ExaminationPaper();
        paper.setId(request.getExaminationPaperId());
        paper.setScore(totalScore);

        examinationPaperService.updateExaminationPaper(paper);

    }
}
