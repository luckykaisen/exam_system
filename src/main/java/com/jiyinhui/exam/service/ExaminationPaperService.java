package com.jiyinhui.exam.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiyinhui.exam.controller.examination.paper.api.SearchExaminationPaperResponse;
import com.jiyinhui.exam.entity.*;
import com.jiyinhui.exam.mapper.ExaminationPaperAnswerMapper;
import com.jiyinhui.exam.mapper.ExaminationPaperMapper;
import com.jiyinhui.exam.mapper.ExaminationPaperOptionMapper;
import com.jiyinhui.exam.mapper.ExaminationThemeSectionMapper;
import com.jiyinhui.exam.service.api.IExaminationPaperService;
import com.jiyinhui.exam.utility.PagingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExaminationPaperService implements IExaminationPaperService {

    @Autowired
    private ExaminationPaperMapper examinationPaperMapper;

    @Autowired
    private ExaminationPaperOptionMapper examinationPaperOptionMapper;

    @Autowired
    private ExaminationPaperAnswerMapper examinationPaperAnswerMapper;

    @Autowired
    private ExaminationThemeSectionMapper examinationThemeSectionMapper;

    @Override
    public List<ExaminationPaper> searchExaminationPaperByThemeIdOrderByScoerDesc(Integer themeId) {
        return examinationPaperMapper.searchExaminationPaperByThemeIdOrderByScoerDesc(themeId);
    }

    @Override
    public List<ExaminationPaper> searchExaminationPaperByUserId(Integer id, SearchExaminationPaperResponse response, PagingData pagingData) {
        PageHelper.startPage(pagingData.getPageNumber(), pagingData.getPageSize());
        List<ExaminationPaper> list = examinationPaperMapper.searchExaminationPaperByUserId(id);

        PageInfo<ExaminationPaper> pageInfo = new PageInfo<>(list);

        pagingData.setPageSize(pageInfo.getPageSize());
        pagingData.setTotalSize(pageInfo.getTotal());

        response.setPagingData(pagingData);
        return list;
    }

    @Override
    public List<ExaminationPaperOption> searchExaminationPaperOptionByExaminationPaperId(Integer examinationPaperId) {
        return examinationPaperOptionMapper.searchExaminationPaperOptionByExaminationPaperId(examinationPaperId);
    }

    @Override
    public List<ExaminationPaperAnswer> searchExaminationPaperAnswerByExaminationPaperOptionId(Integer id) {
        return examinationPaperAnswerMapper.searchExaminationPaperAnswerByExaminationPaperOptionId(id);
    }

    @Override
    public List<ExaminationPaperThemeSection> searchExaminationPaperThemeSectionByThemeId(Integer themeId) {
        return examinationThemeSectionMapper.searchExaminationPaperThemeSectionByThemeId(themeId);
    }

    @Override
    public void insertExaminationPaper(ExaminationPaper paper) {
        examinationPaperMapper.insertExaminationPaper(paper);
    }

    @Override
    public void insertExaminationPaperOption(ExaminationPaperOption paperOption) {
        examinationPaperOptionMapper.insertExaminationPaperOption(paperOption);
    }

    @Override
    public void insertExaminationPaperAnswer(List<ExaminationPaperAnswer> answers) {
        examinationPaperAnswerMapper.insertExaminationPaperAnswer(answers);
    }

    @Override
    public void updateExaminationPaper(ExaminationPaper paper) {
        examinationPaperMapper.updateExaminationPaper(paper);
    }

    @Override
    public void deleteExaminationThemeSectionByThemeId(Integer id) {
        examinationThemeSectionMapper.deleteExaminationThemeSectionByThemeId(id);
    }

    @Override
    public void batchInsertExaminationPaperSection(List<ExaminationThemeSection> themeSections) {
        for (ExaminationThemeSection examinationThemeSection : themeSections) {
            examinationThemeSectionMapper.createExamiationThemeSection(examinationThemeSection);
        }
    }

}
