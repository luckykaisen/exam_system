package com.jiyinhui.exam.controller.examination.paper.api;

import java.util.List;

/**
 * 学生提交试卷
 */
public class CreateExaminationPaperAnswerRequest {
    private List<AnswerRequest> options;
    private Integer examinationPaperId;

    public Integer getExaminationPaperId() {
        return examinationPaperId;
    }

    public void setExaminationPaperId(Integer examinationPaperId) {
        this.examinationPaperId = examinationPaperId;
    }

    public List<AnswerRequest> getOptions() {
        return options;
    }

    public void setOptions(List<AnswerRequest> options) {
        this.options = options;
    }
}
