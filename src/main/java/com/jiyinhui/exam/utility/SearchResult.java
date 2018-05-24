package com.jiyinhui.exam.utility;

import java.util.List;

public class SearchResult<T> {
    private List<T> result;

    private PagingData pagingData;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public PagingData getPagingData() {
        return pagingData;
    }

    public void setPagingData(PagingData pagingData) {
        this.pagingData = pagingData;
    }

}
