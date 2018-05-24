package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.ExaminationPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationPaperMapper {
    List<ExaminationPaper> searchExaminationPaperByThemeIdOrderByScoerDesc(@Param("themeId") Integer themeId);

    List<ExaminationPaper> searchExaminationPaperByUserId(@Param("userId") Integer userId);

    void insertExaminationPaper(@Param("paper") ExaminationPaper paper);

    void updateExaminationPaper(@Param("paper") ExaminationPaper paper);
}
