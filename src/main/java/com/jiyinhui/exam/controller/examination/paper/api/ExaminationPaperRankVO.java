package com.jiyinhui.exam.controller.examination.paper.api;

import com.jiyinhui.exam.entity.ExaminationPaper;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ExaminationPaperRankVO {
    private Integer userId;
    private String userName;
    private double score;
    private Integer rank;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public static List<ExaminationPaperRankVO> toVOs(List<ExaminationPaper> examinationPaperList) {
        List<ExaminationPaperRankVO> vos = new ArrayList<>();

        if (!CollectionUtils.isEmpty(examinationPaperList)) {
            for (int i = 0; i < examinationPaperList.size(); i++) {
                vos.add(toVO(examinationPaperList.get(i), i));
            }
        }

        return vos;
    }

    public static ExaminationPaperRankVO toVO(ExaminationPaper examinationPaper, Integer rank) {
        ExaminationPaperRankVO vo = new ExaminationPaperRankVO();
        vo.setUserId(examinationPaper.getUser().getId());
        vo.setUserName(examinationPaper.getUser().getName());
        vo.setRank(rank + 1);
        if (examinationPaper.getScore() != null) {
            vo.setScore(examinationPaper.getScore());
        }

        return vo;
    }
}
