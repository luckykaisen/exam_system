package com.jiyinhui.exam.controller.section.api;

import com.jiyinhui.exam.exception.IllegalRequestException;
import org.apache.commons.lang.StringUtils;

public class CreateSectionRequest {
    private String sectionName;
    private Integer subjectId;

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

    public void validate() {
        if (StringUtils.isBlank(sectionName) || subjectId == null) {
            throw new IllegalRequestException("请求参数错误");
        }
    }
}
