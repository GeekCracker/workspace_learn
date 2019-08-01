package com.database.operation.query;

public class BaseQueryForm {

    /**当前页*/
    private Long pageNum;

    /**每页显示数据条数*/
    private Long pageSize;

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
