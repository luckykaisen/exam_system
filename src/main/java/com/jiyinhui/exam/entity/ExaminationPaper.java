package com.jiyinhui.exam.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.Date;

public class ExaminationPaper {
    private Integer id;
    private User user;
    private Double score;
    private Date date;
    private ExaminationTheme examinationTheme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ExaminationTheme getExaminationTheme() {
        return examinationTheme;
    }

    public void setExaminationTheme(ExaminationTheme examinationTheme) {
        this.examinationTheme = examinationTheme;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
