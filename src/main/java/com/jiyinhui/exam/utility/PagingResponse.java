package com.jiyinhui.exam.utility;

public class PagingResponse {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalSize;

    private Integer totalPage;
    private PagingData pagingData;

    public Integer getPageNumber() {
        return pagingData.getPageNumber();
    }

    public Integer getPageSize() {
        return pagingData.getPageSize();
    }

    public long getTotalSize() {
        return pagingData.getTotalSize();
    }

    public long getTotalPage() {
        return (pagingData.getPageSize() + pagingData.getTotalSize() - 1) / pagingData.getPageSize();
    }

    public void setPagingData(PagingData pagingData) {
        this.pagingData = pagingData;
    }
}
