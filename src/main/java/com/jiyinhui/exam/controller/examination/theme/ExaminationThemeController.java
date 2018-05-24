package com.jiyinhui.exam.controller.examination.theme;

import com.jiyinhui.exam.controller.examination.theme.api.*;
import com.jiyinhui.exam.controller.user.api.ServiceResponse;
import com.jiyinhui.exam.entity.*;
import com.jiyinhui.exam.entity.filter.ExaminationThemeFilter;
import com.jiyinhui.exam.exception.ExaminationThemeExistException;
import com.jiyinhui.exam.service.api.IExaminationPaperService;
import com.jiyinhui.exam.service.api.IExaminationThemeService;
import com.jiyinhui.exam.utility.SearchResult;
import com.jiyinhui.exam.utility.ServiceResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/teacher/examination/theme")
public class ExaminationThemeController {

    private final static int TOTAL_SCORE = 90;

    @Autowired
    private IExaminationThemeService examinationThemeService;

    @Autowired
    private IExaminationPaperService examinationPaperService;

    @PostMapping(value = "/create")
    public void createExaminationPaper(@RequestBody CreateExaminationThemeRequest request) {
        request.validate();

        ExaminationTheme examinationTheme = examinationThemeService.getExaminationThemeByName(request.getName());

        if (examinationTheme != null) {
            throw new ExaminationThemeExistException();
        }

        examinationTheme = new ExaminationTheme();
        examinationTheme.setName(request.getName());
        examinationTheme.setMinute(request.getTime());
        examinationTheme.setTotalScore(TOTAL_SCORE);
        Subject subject = new Subject();
        subject.setId(request.getSubjectId());

        examinationTheme.setSubject(subject);

        // 创建考试模板
        examinationThemeService.createExaminationTheme(examinationTheme, request.getSections());
    }

    /**
     * 查询考试的主题
     * @param request
     * @return
     */
    @PostMapping(value = "/search")
    public SearchExaminationThemeResponse searchExaminationTheme(SearchExaminationReqeuest request, Map<String, Object> map) {

        ExaminationThemeFilter filter = new ExaminationThemeFilter();
        filter.setPageNumber(request.getPageNumber());
        filter.setPageSize(request.getPageSize());

        SearchResult<ExaminationTheme> searchResult = examinationThemeService.searchExaminationThemeByFilter(filter);

        List<ExaminationThemeVO> vos = ExaminationThemeVO.toVOs(searchResult.getResult());

        SearchExaminationThemeResponse response = new SearchExaminationThemeResponse();
        response.setThemes(vos);
        response.setPagingData(searchResult.getPagingData());

        return response;
    }

    /**
     * 查询考试试卷的详情，考点包括哪些章节
     * @param id
     * @return
     */
    @GetMapping(value = "/detail")
    public SearchExaminationThemeDetailResponse searchExaminationThemeDetail(@RequestParam("id") Integer id) {

        ExaminationTheme examinationThemes = examinationThemeService.searchExaminationThemeById(id);

        List<ExaminationPaperThemeSection> examinationPaperThemeSections = examinationPaperService.searchExaminationPaperThemeSectionByThemeId(id);

        ExaminationThemeDetailVO examinationThemeDetailVO = ExaminationThemeDetailVO.toVO(examinationThemes, examinationPaperThemeSections);
        SearchExaminationThemeDetailResponse response = new SearchExaminationThemeDetailResponse();
        response.setDetail(examinationThemeDetailVO);

        return response;
    }

    /**
     * 修改考试试卷的名称，考试时间，考试范围(章节)
     * @param request
     * @return
     */
    @PostMapping(value = "/modify")
    @Transactional
    public ServiceResponse modifyExaminationTheme(@RequestBody ModifyExaminationThemeRequest request) {
        ExaminationTheme theme = new ExaminationTheme();
        theme.setId(request.getId());
        theme.setName(request.getThemeName());
        theme.setMinute(request.getMinute());

        examinationThemeService.updateExaminationTheme(theme);

        examinationPaperService.deleteExaminationThemeSectionByThemeId(request.getId());

        List<ExaminationThemeSection> themeSections = new ArrayList<>();
        for (Integer sectionId : request.getSectionIds()) {
            ExaminationThemeSection paperThemeSection = new ExaminationThemeSection();
            paperThemeSection.setExaminationTheme(theme);
            Section section = new Section();
            section.setId(sectionId);
            paperThemeSection.setSection(section);

            themeSections.add(paperThemeSection);
        }
        examinationPaperService.batchInsertExaminationPaperSection(themeSections);

        return ServiceResponseUtility.success();
    }

}
