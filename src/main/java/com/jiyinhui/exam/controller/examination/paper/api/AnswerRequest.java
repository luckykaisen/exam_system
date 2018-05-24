package com.jiyinhui.exam.controller.examination.paper.api;

import java.util.List;

public class AnswerRequest {
    private Integer paperOptionId;
    private List<Integer> optionId;

    public Integer getPaperOptionId() {
        return paperOptionId;
    }

    public void setPaperOptionId(Integer paperOptionId) {
        this.paperOptionId = paperOptionId;
    }

    public List<Integer> getOptionId() {
        return optionId;
    }

    public void setOptionId(List<Integer> optionId) {
        this.optionId = optionId;
    }
}
