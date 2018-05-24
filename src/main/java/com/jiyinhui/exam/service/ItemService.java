package com.jiyinhui.exam.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiyinhui.exam.entity.ItemPool;
import com.jiyinhui.exam.entity.Option;
import com.jiyinhui.exam.entity.filter.ItemFilter;
import com.jiyinhui.exam.mapper.ItemMapper;
import com.jiyinhui.exam.mapper.OptionMapper;
import com.jiyinhui.exam.service.api.IItemService;
import com.jiyinhui.exam.utility.PagingData;
import com.jiyinhui.exam.utility.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private OptionMapper optionMapper;

    @Override
    @Transactional
    public void createItem(ItemPool itemPool, List<Option> options) {
        itemMapper.createItem(itemPool);

        Integer itemPoolId = itemPool.getId();

        for (Option option : options) {
            option.getItemPool().setId(itemPoolId);

            optionMapper.createOption(option);
        }

    }

    @Override
    @Transactional
    public void hideItemById(Integer id) {
        itemMapper.hideItemById(id);
    }

    @Override
    public SearchResult<ItemPool> searchItemByFilter(ItemFilter filter) {

        SearchResult<ItemPool> searchResult = new SearchResult<>();

        List<ItemPool> items = null;

        if (filter.getPageNumber() != null && filter.getPageSize() != null) {
            PageHelper.startPage(filter.getPageNumber(), filter.getPageSize());
            items = itemMapper.searchItemByFilter(filter);

            PageInfo<ItemPool> pageInfo = new PageInfo<>(items);

            PagingData pagingData = new PagingData(filter.getPageNumber(),
                    pageInfo.getPageSize(), pageInfo.getTotal());

            searchResult.setPagingData(pagingData);

        } else {
           items = itemMapper.searchItemByFilter(filter);
        }

        searchResult.setResult(items);




        return searchResult;
    }

    @Override
    public List<ItemPool> searchItemIncludeSectionIds(List<Integer> sectionIds) {

        ItemFilter filter = new ItemFilter();
        filter.setIncludeSectionIds(sectionIds);

        return itemMapper.searchItemByFilter(filter);
    }

}
