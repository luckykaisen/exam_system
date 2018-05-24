package com.jiyinhui.exam.controller.examination.theme.api;

import com.jiyinhui.exam.entity.ExaminationTheme;

import java.util.ArrayList;
import java.util.List;

public class ExaminationThemeVO {
    private Integer id;
    private String themeName;
    private Integer subjectId;
    private String subjectName;
    private Integer minute;
    private double totalScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public static List<ExaminationThemeVO> toVOs(List<ExaminationTheme> examinationThemes) {
        List<ExaminationThemeVO> vos = new ArrayList<>();

        for (ExaminationTheme et : examinationThemes) {
            vos.add(toVO(et));
        }

        return vos;
    }

    public static ExaminationThemeVO toVO(ExaminationTheme examinationTheme) {
        ExaminationThemeVO vo = new ExaminationThemeVO();
        vo.setId(examinationTheme.getId());
        vo.setThemeName(examinationTheme.getName());
        vo.setSubjectId(examinationTheme.getSubject().getId());
        vo.setSubjectName(examinationTheme.getSubject().getName());
        vo.setMinute(examinationTheme.getMinute());
        vo.setTotalScore(examinationTheme.getTotalScore());

        return vo;
    }
}
