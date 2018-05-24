package com.jiyinhui.exam.controller.examination.paper.api;

import com.jiyinhui.exam.controller.item.api.OptionVO;

import java.util.List;

/**
 * 随机创建的试卷题目
 */
public class ExaminationPaperItemOptionVO {
    private Integer itemId;
    private String itemName;
    private String itemStatus;
    private Integer paperOptionId;
    private List<OptionVO> options;

    public Integer getPaperOptionId() {
        return paperOptionId;
    }

    public void setPaperOptionId(Integer paperOptionId) {
        this.paperOptionId = paperOptionId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<OptionVO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionVO> options) {
        this.options = options;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }
}
