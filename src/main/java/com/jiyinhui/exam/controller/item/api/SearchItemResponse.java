package com.jiyinhui.exam.controller.item.api;

import com.jiyinhui.exam.utility.PagingResponse;

import java.util.List;

public class SearchItemResponse extends PagingResponse {
    private List<ItemVO> items;

    public List<ItemVO> getItems() {
        return items;
    }

    public void setItems(List<ItemVO> items) {
        this.items = items;
    }
}
