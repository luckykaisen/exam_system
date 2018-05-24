package com.jiyinhui.exam.controller.examination.theme.api;

import com.jiyinhui.exam.utility.PagingResponse;

import java.util.List;

public class SearchExaminationThemeResponse extends PagingResponse {
    private List<ExaminationThemeVO> themes;

    public List<ExaminationThemeVO> getThemes() {
        return themes;
    }

    public void setThemes(List<ExaminationThemeVO> themes) {
        this.themes = themes;
    }
}
