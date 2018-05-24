package com.jiyinhui.exam;

import com.jiyinhui.exam.entity.ExaminationPaperAnswer;
import com.jiyinhui.exam.mapper.ExaminationPaperAnswerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationPaperAnswerTest {

    @Autowired
    private ExaminationPaperAnswerMapper mapper;

    @Test
    public void search() {
        List<ExaminationPaperAnswer> examinationPaperAnswer = mapper.searchExaminationPaperAnswerByExaminationPaperOptionId(1);


        System.out.println(examinationPaperAnswer);


    }
}
