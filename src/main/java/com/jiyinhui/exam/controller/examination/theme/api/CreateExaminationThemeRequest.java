package com.jiyinhui.exam.controller.examination.theme.api;

import com.jiyinhui.exam.exception.IllegalRequestException;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class CreateExaminationThemeRequest {
    private String name;
    private Integer subjectId;
    private List<Integer> sections;
    private Integer time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public List<Integer> getSections() {
        return sections;
    }

    public void setSections(List<Integer> sections) {
        this.sections = sections;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void validate() {
        if (StringUtils.isBlank(name)
                || subjectId == null
                || CollectionUtils.isEmpty(sections)
                || time == null) {
            throw new IllegalRequestException();
        }
    }
}
