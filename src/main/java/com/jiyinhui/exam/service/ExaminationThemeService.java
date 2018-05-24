package com.jiyinhui.exam.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiyinhui.exam.controller.examination.theme.api.SearchExaminationThemeDetailResponse;
import com.jiyinhui.exam.entity.ExaminationTheme;
import com.jiyinhui.exam.entity.ExaminationThemeSection;
import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.entity.filter.ExaminationThemeFilter;
import com.jiyinhui.exam.mapper.ExaminationThemeMapper;
import com.jiyinhui.exam.mapper.ExaminationThemeSectionMapper;
import com.jiyinhui.exam.service.api.IExaminationThemeService;
import com.jiyinhui.exam.utility.PagingData;
import com.jiyinhui.exam.utility.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExaminationThemeService implements IExaminationThemeService {

    @Autowired
    private ExaminationThemeMapper examinationThemeMapper;

    @Autowired
    private ExaminationThemeSectionMapper examinationThemeSectionMapper;

    @Override
    public ExaminationTheme getExaminationThemeByName(String name) {
        return examinationThemeMapper.getExaminationThemeByName(name);
    }

    @Override
    @Transactional
    public void createExaminationTheme(ExaminationTheme examinationTheme, List<Integer> sections) {
        
        examinationThemeMapper.createExaminationTheme(examinationTheme);

        Integer examinationThemeId = examinationTheme.getId();

        for (Integer sectionId : sections) {
            ExaminationThemeSection examinationThemeSection = new ExaminationThemeSection();
            ExaminationTheme et = new ExaminationTheme();
            et.setId(examinationThemeId);

            examinationThemeSection.setExaminationTheme(et);
            Section section = new Section();
            section.setId(sectionId);

            examinationThemeSection.setSection(section);

            examinationThemeSectionMapper.createExamiationThemeSection(examinationThemeSection);
        }

    }

    @Override
    public SearchResult<ExaminationTheme> searchExaminationThemeByFilter(ExaminationThemeFilter filter) {
        PageHelper.startPage(filter.getPageNumber(), filter.getPageSize());

        List<ExaminationTheme> examinationThemes = examinationThemeMapper.searchExaminationThemeByFilter(filter);

        PageInfo<ExaminationTheme> pageInfo = new PageInfo<>(examinationThemes);

        SearchResult<ExaminationTheme> searchResult = new SearchResult<>();
        searchResult.setResult(examinationThemes);
        PagingData pagingData = new PagingData(filter.getPageNumber(), pageInfo.getPageSize(), pageInfo.getTotal());

        searchResult.setPagingData(pagingData);

        return searchResult;
    }

    @Override
    public ExaminationTheme searchExaminationThemeById(Integer id) {
        return examinationThemeMapper.getExaminationThemeById(id);
    }

    @Override
    public void updateExaminationTheme(ExaminationTheme theme) {
        examinationThemeMapper.updateExaminationTheme(theme);
    }
}
