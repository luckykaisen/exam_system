package com.jiyinhui.exam.controller.item;

import com.jiyinhui.exam.controller.item.api.*;
import com.jiyinhui.exam.entity.*;
import com.jiyinhui.exam.entity.filter.ItemFilter;
import com.jiyinhui.exam.mapper.OptionMapper;
import com.jiyinhui.exam.service.api.IItemService;
import com.jiyinhui.exam.utility.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/teacher/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @Autowired
    private OptionMapper optionMapper;

    @PostMapping(value = "/create")
    public void createItem(@RequestBody CreateItemRequest request) {

        request.validate();

        // 题目
        ItemPool itemPool = new ItemPool();
        itemPool.setItemStatus(ItemStatus.fromId(request.getStatus()));
        itemPool.setScore(3.0);

        Section section = new Section();
        section.setId(request.getSectionId());
        itemPool.setSection(section);

        itemPool.setItemStatus(ItemStatus.fromId(request.getStatus()));
        itemPool.setTopic(request.getName());

        // 选项
        List<Option> options = new ArrayList<>();
        for (ItemOptionRequest ior : request.getOptions()) {
            Option option = new Option();
            option.setOption(ior.getName());
            option.setAnswer(Bool.fromCode(ior.getAnswer()));
            option.setItemPool(itemPool);

            options.add(option);
        }

        itemService.createItem(itemPool, options);
    }

    /**
     * 修改题,隐藏试题
     */
    @GetMapping(value = "/hide")
    public void modifyItem(@RequestParam("id") Integer id) {
        itemService.hideItemById(id);
    }

    /**
     * 根据章节查询题目
     * @param request
     * @return
     */
    @PostMapping(value = "/search")
    public SearchItemResponse searchItem(SearchItemRequest request) {
        ItemFilter filter = new ItemFilter();
        Section section = new Section();
        section.setId(request.getSectionId());

        filter.setSection(section);
        filter.setPageNumber(request.getPageNumber());
        filter.setPageSize(request.getPageSize());

        SearchResult<ItemPool> searchResult = itemService.searchItemByFilter(filter);

        List<ItemPool> result = searchResult.getResult();

        List<ItemVO> vos = new ArrayList<>();
        for (ItemPool itemPool : result) {
            List<Option> options = optionMapper.getOptionByItemPoolId(itemPool.getId());
            ItemVO vo = ItemVO.toVO(itemPool, options);

            vos.add(vo);
        }

        SearchItemResponse response = new SearchItemResponse();
        response.setPagingData(searchResult.getPagingData());
        response.setItems(vos);

        return response;
    }
}
