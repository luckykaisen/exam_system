package com.jiyinhui.exam.controller.item.api;

import com.jiyinhui.exam.entity.ItemPool;
import com.jiyinhui.exam.entity.Option;

import java.util.List;

public class ItemVO {
    private Integer id;
    private String name;
    private List<OptionVO> options;
    private String delete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OptionVO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionVO> options) {
        this.options = options;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public static ItemVO toVO(ItemPool itemPool, List<Option> options) {
        ItemVO vo = new ItemVO();

        vo.setId(itemPool.getId());
        vo.setName(itemPool.getTopic());
        vo.setDelete(itemPool.getIsDelete().getCode());
        List<OptionVO> vos = OptionVO.toVOs(options);
        vo.setOptions(vos);

        return vo;
    }
}
