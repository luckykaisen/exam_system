package com.jiyinhui.exam.service.api;

import com.jiyinhui.exam.entity.ExaminationTheme;
import com.jiyinhui.exam.entity.filter.ExaminationThemeFilter;
import com.jiyinhui.exam.utility.SearchResult;

import java.util.List;

public interface IExaminationThemeService {
    ExaminationTheme getExaminationThemeByName(String name);

    void createExaminationTheme(ExaminationTheme examinationTheme, List<Integer> sections);

    SearchResult<ExaminationTheme> searchExaminationThemeByFilter(ExaminationThemeFilter filter);

    ExaminationTheme searchExaminationThemeById(Integer id);

    void updateExaminationTheme(ExaminationTheme theme);
}
