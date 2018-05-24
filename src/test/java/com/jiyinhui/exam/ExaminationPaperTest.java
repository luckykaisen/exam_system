package com.jiyinhui.exam;

import com.jiyinhui.exam.entity.ExaminationPaper;
import com.jiyinhui.exam.entity.ExaminationTheme;
import com.jiyinhui.exam.entity.User;
import com.jiyinhui.exam.mapper.ExaminationPaperMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationPaperTest {

    @Autowired
    private ExaminationPaperMapper mapper;

    @Test
    public void search() {
        List<ExaminationPaper> examinationPapers = mapper.searchExaminationPaperByThemeIdOrderByScoerDesc(1);

        System.out.println(examinationPapers);

    }

    @Test
    public void insert() {

        ExaminationPaper paper = new ExaminationPaper();
        paper.setDate(new Date());
        User u = new User();
        u.setId(1);

        paper.setUser(u);

        ExaminationTheme theme = new ExaminationTheme();
        theme.setId(1);

        paper.setExaminationTheme(theme);

        mapper.insertExaminationPaper(paper);

        System.out.println("返回主键id ：" + paper.getId());
    }

    @Test
    public void update() {
        ExaminationPaper paper = new ExaminationPaper();
        paper.setId(3);
        paper.setScore(23.3);

        mapper.updateExaminationPaper(paper);
    }
}
