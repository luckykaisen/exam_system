package com.jiyinhui.exam.mapper;

import com.jiyinhui.exam.entity.ItemPool;
import com.jiyinhui.exam.entity.filter.ItemFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
    void createItem(@Param("itemPool") ItemPool itemPool);

    void hideItemById(@Param("id") Integer id);

    List<ItemPool> searchItemByFilter(@Param("filter") ItemFilter filter);
}
