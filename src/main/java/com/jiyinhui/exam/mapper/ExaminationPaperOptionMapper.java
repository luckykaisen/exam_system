package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.ExaminationPaperOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationPaperOptionMapper {
    List<ExaminationPaperOption> searchExaminationPaperOptionByExaminationPaperId(@Param("examinationPaperId") Integer examinationPaperId);

    void insertExaminationPaperOption(@Param("paperOption") ExaminationPaperOption paperOption);
}
