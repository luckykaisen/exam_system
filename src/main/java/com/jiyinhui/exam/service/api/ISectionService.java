package com.jiyinhui.exam.service.api;

import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.entity.filter.SectionFilter;
import com.jiyinhui.exam.utility.SearchResult;

public interface ISectionService {
    void modifySection(Section section);

    void deleteSection(Integer id);

    void createSection(Section section);

    SearchResult<Section> searchSectionByFilter(SectionFilter filter);
}
