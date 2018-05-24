package com.jiyinhui.exam.entity.filter;

import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.utility.SearchFilter;

import java.util.List;

public class ItemFilter extends SearchFilter {
    private Section section;

    private List<Integer> includeSectionIds;

    public List<Integer> getIncludeSectionIds() {
        return includeSectionIds;
    }

    public void setIncludeSectionIds(List<Integer> includeSectionIds) {
        this.includeSectionIds = includeSectionIds;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
