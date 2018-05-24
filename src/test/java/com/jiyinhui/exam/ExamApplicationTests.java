package com.jiyinhui.exam;

import com.jiyinhui.exam.entity.*;
import com.jiyinhui.exam.mapper.ExaminationThemeMapper;
import com.jiyinhui.exam.mapper.ExaminationThemeSectionMapper;
import com.jiyinhui.exam.utility.Base64Utility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamApplicationTests {

	@Autowired
	private ExaminationThemeMapper examinationThemeMapper;

	@Autowired
	private ExaminationThemeSectionMapper examinationThemeSectionMapper;

	@Test
	public void contextLoads() {
		ExaminationTheme theme = examinationThemeMapper.getExaminationThemeByName("月考");

		System.out.println(theme);
	}

	@Test
	public void insertExinationTheme() {
	    ExaminationTheme theme = new ExaminationTheme();

        Subject s = new Subject();
        s.setId(1);


	    theme.setSubject(s);
	    theme.setMinute(120);
	    theme.setName("其中考试");
	    theme.setTotalScore(150);

        examinationThemeMapper.createExaminationTheme(theme);

        System.out.println("======id : " + theme.getId());
    }

    @Test
    public void insertExaminationThemeSection() {
        ExaminationThemeSection section = new ExaminationThemeSection();

        Section s = new Section();
        s.setId(1);
        section.setSection(s);

        ExaminationTheme theme = new ExaminationTheme();
        theme.setId(11);

        section.setExaminationTheme(theme);

        examinationThemeSectionMapper.createExamiationThemeSection(section);
    }

    @Test
    public void test() throws Exception {
//        String encode = Base64Utils.encode("admin".getBytes()).toString();
//
//        System.out.println(encode);

        System.out.println(new String(Base64Utility.encode("admin".getBytes("UTF-8")), "UTF-8"));



    }

}
