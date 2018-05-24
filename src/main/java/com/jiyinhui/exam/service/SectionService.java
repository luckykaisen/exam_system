package com.jiyinhui.exam.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.entity.filter.SectionFilter;
import com.jiyinhui.exam.mapper.SectionMapper;
import com.jiyinhui.exam.service.api.ISectionService;
import com.jiyinhui.exam.utility.PagingData;
import com.jiyinhui.exam.utility.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionService implements ISectionService {

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    @Transactional
    public void modifySection(Section section) {
        sectionMapper.modifySection(section);
    }

    @Override
    @Transactional
    public void deleteSection(Integer id) {
        sectionMapper.deleteSection(id);
    }

    @Override
    @Transactional
    public void createSection(Section section) {
        sectionMapper.createSection(section);
    }

    @Override
    public SearchResult<Section> searchSectionByFilter(SectionFilter filter) {

        PageHelper.startPage(filter.getPageNumber(), filter.getPageSize());

        List<Section> sections = sectionMapper.searchSectionByFilter(filter);

        PageInfo<Section> pageInfo = new PageInfo<>(sections);

        SearchResult<Section> searchResult = new SearchResult<>();

        searchResult.setResult(sections);
        PagingData pagingData = new PagingData(filter.getPageNumber(), pageInfo.getPageSize(), pageInfo.getTotal());
        searchResult.setPagingData(pagingData);

        return searchResult;
    }
}
