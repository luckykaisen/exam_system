package com.jiyinhui.exam.controller.examination.theme.api;

import com.jiyinhui.exam.entity.ExaminationPaperThemeSection;
import com.jiyinhui.exam.entity.ExaminationTheme;
import java.util.ArrayList;
import java.util.List;

public class ExaminationThemeDetailVO {
    private Integer id;
    private String themeName;
    private String subjectName;
    private Integer subjectId;
    private Integer minute;
    private double totalScore;
    private List<Integer> sections;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
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

    public List<Integer> getSections() {
        return sections;
    }

    public void setSections(List<Integer> sections) {
        this.sections = sections;
    }

    public static ExaminationThemeDetailVO toVO(ExaminationTheme theme, List<ExaminationPaperThemeSection> sections) {
        ExaminationThemeDetailVO vo = new ExaminationThemeDetailVO();
        vo.setId(theme.getId());
        vo.setMinute(theme.getMinute());
        vo.setThemeName(theme.getName());
        vo.setTotalScore(theme.getTotalScore());
        vo.setSubjectName(theme.getSubject().getName());
        vo.setSubjectId(theme.getSubject().getId());

        List<Integer> sectionVOS = new ArrayList<>();
        for (ExaminationPaperThemeSection section : sections) {
            sectionVOS.add(section.getSection().getId());
        }
        vo.setSections(sectionVOS);

        return vo;
    }
}
