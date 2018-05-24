package com.jiyinhui.exam;

import com.jiyinhui.exam.entity.ExaminationPaper;
import com.jiyinhui.exam.entity.ExaminationPaperOption;
import com.jiyinhui.exam.entity.ItemPool;
import com.jiyinhui.exam.mapper.ExaminationPaperOptionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationPaperOptionTest {

    @Autowired
    private ExaminationPaperOptionMapper mapper;

    @Test
    public void searchTest() {
        List<ExaminationPaperOption> examinationPaperOptions = mapper.searchExaminationPaperOptionByExaminationPaperId(1);

        System.out.println(examinationPaperOptions);

    }

    @Test
    public void insert() {

        ExaminationPaperOption option = new ExaminationPaperOption();
        ItemPool item = new ItemPool();
        item.setId(2);

        option.setItemPool(item);

        ExaminationPaper paper = new ExaminationPaper();
        paper.setId(1);

        option.setExaminationPaper(paper);

        mapper.insertExaminationPaperOption(option);

        System.out.println("返回主键id : " + option.getId());
    }
}
