package com.jiyinhui.exam.controller.item.api;

import java.util.List;

public class ModifyItemRequest {
    private Integer id;
    private String name;
    private Integer status;
    private Integer sectionId;
    private List<ItemOptionRequest> options;

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

    public List<ItemOptionRequest> getOptions() {
        return options;
    }

    public void setOptions(List<ItemOptionRequest> options) {
        this.options = options;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }
}
