package com.jiyinhui.exam;

import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.entity.Subject;
import com.jiyinhui.exam.entity.filter.SectionFilter;
import com.jiyinhui.exam.mapper.SectionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SectionMapperTest {

    @Autowired
    private SectionMapper sectionMapper;

    @Test
    public void modifySection() {
        Section s = new Section();
        s.setId(1);
        s.setName("魏凯森");

        sectionMapper.modifySection(s);
    }

    @Test
    public void deleteSection() {


        sectionMapper.deleteSection(1);
    }

    @Test
    public void insertSection() {

        Section s = new Section();
        s.setName("金瓶梅");

        Subject sub = new Subject();
        sub.setId(1);

        s.setSubject(sub);
        sectionMapper.createSection(s);
    }

    @Test
    public void searchSection() {

        SectionFilter filter = new SectionFilter();
        filter.setSubjectId(2);

        List<Section> sections =
                sectionMapper.searchSectionByFilter(filter);

        System.out.println(sections);

    }
}
