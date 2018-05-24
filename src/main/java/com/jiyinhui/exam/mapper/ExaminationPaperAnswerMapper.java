package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.ExaminationPaperAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationPaperAnswerMapper {
    List<ExaminationPaperAnswer> searchExaminationPaperAnswerByExaminationPaperOptionId(@Param("paperOptionId") Integer id);

    void insertExaminationPaperAnswer(@Param("answers") List<ExaminationPaperAnswer> answers);
}
