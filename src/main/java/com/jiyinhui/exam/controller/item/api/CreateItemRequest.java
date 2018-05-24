package com.jiyinhui.exam.controller.item.api;

import com.jiyinhui.exam.entity.ItemStatus;
import com.jiyinhui.exam.exception.IllegalRequestException;
import org.apache.commons.lang.StringUtils;

import java.util.List;

public class CreateItemRequest {
    private String name;
    private Integer status;
    private Integer sectionId;
    private List<ItemOptionRequest> options;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public List<ItemOptionRequest> getOptions() {
        return options;
    }

    public void setOptions(List<ItemOptionRequest> options) {
        this.options = options;
    }

    public void validate() {
        if (StringUtils.isBlank(name)
                || status == null
                || ItemStatus.fromId(status) == null
                || sectionId == null
                || options == null) {
            throw  new IllegalRequestException();
        }

        ItemStatus itemStatus = ItemStatus.fromId(status);
        // 单选题，选项必须大于等于4
        if (ItemStatus.SINGLE_CHOICE.equals(itemStatus)) {
            if (options.size() < 4) {
                throw  new IllegalRequestException();
            }
        }

        // 判断题的选项必须是两个
        if (ItemStatus.TRUE_OR_FALSE.equals(itemStatus) && options.size() != 2) {
            throw  new IllegalRequestException();
        }

        // 多选题选项必须大于等于4个
        if (ItemStatus.MULTIPLE_CHOICE.equals(itemStatus) && options.size() < 4) {
            throw  new IllegalRequestException();
        }
    }
}
