package com.jiyinhui.exam.controller.section.api;

import com.jiyinhui.exam.exception.IllegalRequestException;
import org.apache.commons.lang.StringUtils;

public class ModifySectionRequest {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void validate() {
        if (id == null || StringUtils.isBlank(name)) {
            throw new IllegalRequestException();
        }
    }
}
