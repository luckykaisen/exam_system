package com.jiyinhui.exam.controller.examination.theme.api;

import java.util.List;

public class ModifyExaminationThemeRequest {
    private Integer id;
    private String themeName;
    private Integer minute;
    private List<Integer> sectionIds;

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

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public List<Integer> getSectionIds() {
        return sectionIds;
    }

    public void setSectionIds(List<Integer> sectionIds) {
        this.sectionIds = sectionIds;
    }
}
