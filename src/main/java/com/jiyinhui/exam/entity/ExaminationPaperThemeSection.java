package com.jiyinhui.exam.entity;


import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ExaminationPaperThemeSection {
    private Integer id;
    private ExaminationTheme examinationTheme;
    private Section section;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExaminationTheme getExaminationTheme() {
        return examinationTheme;
    }

    public void setExaminationTheme(ExaminationTheme examinationTheme) {
        this.examinationTheme = examinationTheme;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
