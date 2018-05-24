package com.jiyinhui.exam.controller.item.api;

import com.jiyinhui.exam.utility.PagingRequest;

public class SearchItemRequest extends PagingRequest {
    private Integer sectionId;

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }
}
