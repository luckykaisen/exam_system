package com.jiyinhui.exam.controller.section.api;

import com.jiyinhui.exam.utility.PagingRequest;

public class SearchSectionRequest extends PagingRequest {
    private Integer subjectId;

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
