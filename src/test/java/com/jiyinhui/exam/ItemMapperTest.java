package com.jiyinhui.exam;


import com.jiyinhui.exam.entity.ItemPool;
import com.jiyinhui.exam.entity.ItemStatus;
import com.jiyinhui.exam.entity.Section;
import com.jiyinhui.exam.entity.filter.ItemFilter;
import com.jiyinhui.exam.mapper.ItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper mapper;

    @Test
    public void insertTest() {

        ItemPool itemPool = new ItemPool();
        itemPool.setTopic("三角形底面积");
        itemPool.setItemStatus(ItemStatus.SINGLE_CHOICE);
        itemPool.setScore(10.0);
        Section section = new Section();
        section.setId(2);

        itemPool.setSection(section);

        mapper.createItem(itemPool);
    }


    @Test
    public void hide() {
        mapper.hideItemById(2);
    }

    @Test
    public void search() {

        ItemFilter filter = new ItemFilter();

        List<Integer> list = new ArrayList<>();
        list.add(2);

        filter.setIncludeSectionIds(list);
        List<ItemPool> itemPools =
                mapper.searchItemByFilter(filter);

        System.out.println(itemPools);

    }
}
