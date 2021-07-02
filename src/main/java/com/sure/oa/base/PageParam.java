package com.sure.oa.base;

/**
 * 封装分页参数的JavaBean
 */
public class PageParam {

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        try {
            this.pageNum = Integer.parseInt(pageNum);
        } catch (NumberFormatException e) {
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        try {
            this.pageSize = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
        }
    }
}
