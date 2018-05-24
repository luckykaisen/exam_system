package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.ExaminationTheme;
import com.jiyinhui.exam.entity.ExaminationThemeSection;
import com.jiyinhui.exam.entity.filter.ExaminationThemeFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationThemeMapper {
    ExaminationTheme getExaminationThemeByName(String name);

    void createExaminationTheme(@Param("examinationTheme") ExaminationTheme examinationTheme);

    List<ExaminationTheme> searchExaminationThemeByFilter(@Param("filter") ExaminationThemeFilter filter);

    ExaminationTheme getExaminationThemeById(@Param("id") Integer id);

    void updateExaminationTheme(@Param("theme") ExaminationTheme theme);
}
