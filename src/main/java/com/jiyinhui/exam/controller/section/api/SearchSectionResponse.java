package com.jiyinhui.exam.controller.section.api;

import com.jiyinhui.exam.utility.PagingResponse;

import java.util.List;

public class SearchSectionResponse extends PagingResponse {
    private List<SectionVO> sections;

    public List<SectionVO> getSections() {
        return sections;
    }

    public void setSections(List<SectionVO> sections) {
        this.sections = sections;
    }
}
