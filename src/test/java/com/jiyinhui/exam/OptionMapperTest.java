package com.jiyinhui.exam;

import com.jiyinhui.exam.entity.Bool;
import com.jiyinhui.exam.entity.ItemPool;
import com.jiyinhui.exam.entity.Option;
import com.jiyinhui.exam.mapper.OptionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.Transient;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionMapperTest {

    @Autowired
    private OptionMapper mapper;

    @Test
    public void insert() {

        Option option = new Option();
        option.setOption("12平米");
        option.setAnswer(Bool.Y);

        ItemPool itemPool = new ItemPool();
        itemPool.setId(3);

        option.setItemPool(itemPool);
        mapper.createOption(option);
    }

    @Test
    public void update() {
        Option option = new Option();
    }

    @Test
    public void searchByItemPoolId() {
        List<Option> options =
                mapper.getOptionByItemPoolId(4);

        System.out.println(options);

    }
}
