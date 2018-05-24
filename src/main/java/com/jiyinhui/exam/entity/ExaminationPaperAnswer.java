package com.jiyinhui.exam.entity;

public class ExaminationPaperAnswer {
    private Integer id;
    private Option option;
    private ExaminationPaperOption examinationPaperOption;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public ExaminationPaperOption getExaminationPaperOption() {
        return examinationPaperOption;
    }

    public void setExaminationPaperOption(ExaminationPaperOption examinationPaperOption) {
        this.examinationPaperOption = examinationPaperOption;
    }
}
