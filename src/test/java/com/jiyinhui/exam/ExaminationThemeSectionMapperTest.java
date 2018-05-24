package com.jiyinhui.exam;

import com.jiyinhui.exam.entity.ExaminationPaperThemeSection;
import com.jiyinhui.exam.mapper.ExaminationThemeSectionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationThemeSectionMapperTest {

    @Autowired
    private ExaminationThemeSectionMapper mapper;

    @Test
    public void testSearch() {
        List<ExaminationPaperThemeSection> examinationPaperThemeSections = mapper.searchExaminationPaperThemeSectionByThemeId(12);

        System.out.println(examinationPaperThemeSections);

    }
}
