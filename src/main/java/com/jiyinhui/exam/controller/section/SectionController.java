package com.jiyinhui.exam.controller.section;

import com.jiyinhui.exam.controller.section.api.*;
import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.entity.Subject;
import com.jiyinhui.exam.entity.filter.SectionFilter;
import com.jiyinhui.exam.service.api.ISectionService;
import com.jiyinhui.exam.utility.PagingData;
import com.jiyinhui.exam.utility.PagingRequest;
import com.jiyinhui.exam.utility.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/teacher/section")
public class SectionController {

    @Autowired
    private ISectionService sectionService;

    @PostMapping(value = "/modify")
    public void modifySection(ModifySectionRequest request) {
        request.validate();

        Section section = new Section();
        section.setId(Integer.parseInt(request.getId()));
        section.setName(request.getName());

        sectionService.modifySection(section);
    }

    @GetMapping(value = "/delete")
    public void deleteSection(@RequestParam("id") Integer id) {
        sectionService.deleteSection(id);
    }

    @PostMapping(value = "/create")
    public void createSection(CreateSectionRequest request) {
        request.validate();

        Section section = new Section();
        section.setName(request.getSectionName());
        Subject subject = new Subject();
        subject.setId(request.getSubjectId());

        section.setSubject(subject);

        sectionService.createSection(section);

    }

    @PostMapping(value = "/search")
    public SearchSectionResponse searchSection(SearchSectionRequest request) {
        SectionFilter filter = new SectionFilter();
        filter.setSubjectId(request.getSubjectId());
        filter.setPageNumber(request.getPageNumber());
        filter.setPageSize(request.getPageSize());

        SearchResult<Section> searchResult = sectionService.searchSectionByFilter(filter);

        List<Section> sections = searchResult.getResult();

        List<SectionVO> vos = SectionVO.toVOs(sections);

        SearchSectionResponse response = new SearchSectionResponse();
        response.setSections(vos);
        response.setPagingData(searchResult.getPagingData());


        return response;
    }
}
