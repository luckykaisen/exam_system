package com.jiyinhui.exam.controller.examination.paper.api;

import java.util.List;

public class SearchExaminationPaperRankResponse {
    private String themeName;
    private List<ExaminationPaperRankVO> rank;

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public List<ExaminationPaperRankVO> getRank() {
        return rank;
    }

    public void setRank(List<ExaminationPaperRankVO> rank) {
        this.rank = rank;
    }
}
