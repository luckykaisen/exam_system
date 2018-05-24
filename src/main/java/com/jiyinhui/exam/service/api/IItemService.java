package com.jiyinhui.exam.service.api;

import com.jiyinhui.exam.entity.ItemPool;
import com.jiyinhui.exam.entity.Option;
import com.jiyinhui.exam.entity.filter.ItemFilter;
import com.jiyinhui.exam.utility.SearchResult;

import java.util.List;

public interface IItemService {
    void createItem(ItemPool itemPool, List<Option> options);

    void hideItemById(Integer id);

    SearchResult<ItemPool> searchItemByFilter(ItemFilter filter);

    List<ItemPool> searchItemIncludeSectionIds(List<Integer> sectionIds);
}
