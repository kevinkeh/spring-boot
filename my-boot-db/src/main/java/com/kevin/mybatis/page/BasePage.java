package com.kevin.mybatis.page;

/**
 * @author geyh
 * @create 2017-12-05 13:59
 */
public class BasePage {

    /**当前页第一条数据偏移量*/
    private Integer offSet;
    /**页码大小**/
    private Integer pageSize;
    /**排序字段名称**/
    private String sortName;
    /**排序方式 asc or desc**/
    private String sortOrder;

    public Integer getOffSet() {
        return offSet;
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
