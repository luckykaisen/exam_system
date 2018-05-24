package com.jiyinhui.exam.controller.subject.api;

import com.jiyinhui.exam.entity.Subject;

public class SubjectVO {
    private Integer id;
    private String name;
    private String disciplineTypeCode;

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

    public String getDisciplineTypeCode() {
        return disciplineTypeCode;
    }

    public void setDisciplineTypeCode(String disciplineTypeCode) {
        this.disciplineTypeCode = disciplineTypeCode;
    }

    public static SubjectVO toVO(Subject subject) {
        SubjectVO vo = new SubjectVO();
        vo.setId(subject.getId());
        vo.setName(subject.getName());
        vo.setDisciplineTypeCode(subject.getDisciplineType().getCode());

        return vo;
    }
}
