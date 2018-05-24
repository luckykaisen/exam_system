package com.jiyinhui.exam.controller.examination.paper.api;

import java.util.List;

/**
 * 随机创建的试卷
 */
public class ExaminationPaperOptionResponse {
    private Integer paperOptionId;
    private List<ExaminationPaperItemOptionVO> items;
    private Integer examinationPaperId;

    public Integer getExaminationPaperId() {
        return examinationPaperId;
    }

    public void setExaminationPaperId(Integer examinationPaperId) {
        this.examinationPaperId = examinationPaperId;
    }

    public Integer getPaperOptionId() {
        return paperOptionId;
    }

    public void setPaperOptionId(Integer paperOptionId) {
        this.paperOptionId = paperOptionId;
    }

    public List<ExaminationPaperItemOptionVO> getItems() {
        return items;
    }

    public void setItems(List<ExaminationPaperItemOptionVO> items) {
        this.items = items;
    }
}
