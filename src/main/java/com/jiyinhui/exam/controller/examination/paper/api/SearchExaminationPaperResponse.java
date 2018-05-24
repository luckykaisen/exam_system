package com.jiyinhui.exam.controller.examination.paper.api;

import com.jiyinhui.exam.utility.PagingResponse;

import java.util.List;

public class SearchExaminationPaperResponse extends PagingResponse {
    private List<ExaminationPaperVO> papers;

    public List<ExaminationPaperVO> getPapers() {
        return papers;
    }

    public void setPapers(List<ExaminationPaperVO> papers) {
        this.papers = papers;
    }
}
