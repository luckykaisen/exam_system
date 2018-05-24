package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.entity.filter.SectionFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SectionMapper {
    void modifySection(@Param("section") Section section);

    void deleteSection(@Param("id") Integer id);

    void createSection(@Param("section") Section section);

    List<Section> searchSectionByFilter(@Param("filter") SectionFilter filter);
}
