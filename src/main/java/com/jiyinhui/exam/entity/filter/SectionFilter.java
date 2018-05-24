package com.jiyinhui.exam.entity.filter;

import com.jiyinhui.exam.utility.SearchFilter;

public class SectionFilter extends SearchFilter {
    private Integer subjectId;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
