package com.jiyinhui.exam.controller.examination.paper.api;

import java.util.List;

/**
 * 历史卷子答案记录
 */
public class SearchExaminationPaperDetailResponse {

    private List<ExaminationPaperItemVO> items;

    public List<ExaminationPaperItemVO> getItems() {
        return items;
    }

    public void setItems(List<ExaminationPaperItemVO> items) {
        this.items = items;
    }
}
