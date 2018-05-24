package com.jiyinhui.exam.entity;


import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ExaminationTheme {
    private Integer id;
    private String name;
    private Integer minute;
    private double totalScore;
    private Subject subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
