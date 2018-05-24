package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.ExaminationPaperThemeSection;
import com.jiyinhui.exam.entity.ExaminationThemeSection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationThemeSectionMapper {

    void createExamiationThemeSection(@Param("examinationThemeSection") ExaminationThemeSection examinationThemeSection);

    List<ExaminationPaperThemeSection> searchExaminationPaperThemeSectionByThemeId(@Param("themeId") Integer themeId);

    void deleteExaminationThemeSectionByThemeId(@Param("themeId") Integer id);

}
