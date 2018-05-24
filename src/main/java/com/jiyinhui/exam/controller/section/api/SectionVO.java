package com.jiyinhui.exam.controller.section.api;

import com.jiyinhui.exam.entity.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionVO {
    private Integer id;
    private String sectionName;
    private Integer subjectId;
    private String subjectName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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

    public static List<SectionVO> toVOs(List<Section> sections) {
        List<SectionVO> vos = new ArrayList<>();
        for (Section s : sections) {
            vos.add(toVO(s));
        }

        return vos;
    }

    public static SectionVO toVO(Section section) {
        SectionVO vo = new SectionVO();
        vo.setId(section.getId());
        vo.setSectionName(section.getName());
        vo.setSubjectId(section.getSubject().getId());
        vo.setSubjectName(section.getSubject().getName());

        return vo;
    }
}
