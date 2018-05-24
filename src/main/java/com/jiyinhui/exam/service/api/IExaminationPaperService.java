package com.jiyinhui.exam.service.api;

import com.jiyinhui.exam.controller.examination.paper.api.SearchExaminationPaperResponse;
import com.jiyinhui.exam.entity.*;
import com.jiyinhui.exam.utility.PagingData;

import java.util.List;

public interface IExaminationPaperService {
    List<ExaminationPaper> searchExaminationPaperByThemeIdOrderByScoerDesc(Integer themeId);

    List<ExaminationPaper> searchExaminationPaperByUserId(Integer id, SearchExaminationPaperResponse response, PagingData pagingData);

    List<ExaminationPaperOption> searchExaminationPaperOptionByExaminationPaperId(Integer examinationPaperId);

    List<ExaminationPaperAnswer> searchExaminationPaperAnswerByExaminationPaperOptionId(Integer id);

    List<ExaminationPaperThemeSection> searchExaminationPaperThemeSectionByThemeId(Integer themeId);

    void insertExaminationPaper(ExaminationPaper paper);

    void insertExaminationPaperOption(ExaminationPaperOption paperOption);

    void insertExaminationPaperAnswer(List<ExaminationPaperAnswer> answers);

    void updateExaminationPaper(ExaminationPaper paper);

    void deleteExaminationThemeSectionByThemeId(Integer id);

    void batchInsertExaminationPaperSection(List<ExaminationThemeSection> themeSections);
}
