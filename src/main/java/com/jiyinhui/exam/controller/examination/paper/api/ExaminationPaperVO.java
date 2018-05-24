package com.jiyinhui.exam.controller.examination.paper.api;

import com.jiyinhui.exam.entity.ExaminationPaper;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ExaminationPaperVO {
    private Integer id;
    private Integer themeId;
    private String themeName;
    private Integer subjectId;
    private String subjectName;
    private double totalScore;
    private double score;

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

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

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static List<ExaminationPaperVO> toVOs(List<ExaminationPaper> examinationPaperList) {
        List<ExaminationPaperVO> vos = new ArrayList<>();

        if (!CollectionUtils.isEmpty(examinationPaperList)) {
            for (int i = 0; i < examinationPaperList.size(); i++) {
                vos.add(toVO(examinationPaperList.get(i)));
            }
        }

        return vos;
    }

    public static ExaminationPaperVO toVO(ExaminationPaper examinationPaper) {
        ExaminationPaperVO vo = new ExaminationPaperVO();
        vo.setId(examinationPaper.getId());
        vo.setThemeId(examinationPaper.getExaminationTheme().getId());
        vo.setThemeName(examinationPaper.getExaminationTheme().getName());
        vo.setSubjectId(examinationPaper.getExaminationTheme().getSubject().getId());
        vo.setSubjectName(examinationPaper.getExaminationTheme().getSubject().getName());
        if (examinationPaper.getScore() != null) {
            vo.setScore(examinationPaper.getScore());
        }
        vo.setTotalScore(examinationPaper.getExaminationTheme().getTotalScore());

        return vo;
    }
}
