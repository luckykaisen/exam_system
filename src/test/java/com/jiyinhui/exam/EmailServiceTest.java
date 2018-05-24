package com.jiyinhui.exam;

import com.jiyinhui.exam.service.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private MailServiceImpl mailService;

    @Test
    public void testSend() {
        mailService.sendSimpleMail("2234965508@qq.com", "找回", "2235");
    }

    @Test
    public void test() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(2);
        list1.add(1);
        list2.add(2);

        System.out.println(Collections.disjoint(list1, list2));


//        if (list1.containsAll(list2) && list2.containsAll(list1)) {
//            System.out.println("相同");
//        } else {
//            System.out.println("不相同");
//        }
    }
}
