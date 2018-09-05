/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.kevin.mybatis.page;

import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis分页参数及查询结果封装. 注意所有序号从1开始.
 *
 * @param <T> Page中记录的类型.
 * @author GimoXie
 * @since 2016年5月18日 下午1:34:32
 **/
public class Page<T> extends RowBounds {



    // --分页参数 --//
    /**
     * 页编号 : 第几页
     */
    private int pageNo = 1;
    /**
     * 页大小 : 每页的数量
     */
    private int pageSize = 15;

    /**
     * 偏移量 : 第一条数据在表中的位置
     */
    private int offset;

    /**
     * 限定数 : 每页的数量
     */
    private int limit;

    /**
     * 返回结果，兼容bootstrap-table
     */
    private List<T> rows = new ArrayList<>();

    /**
     * 总条数,兼容bootstrap-table
     */
    private int total;

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 排序方式
     */
    private String order;

    /**
     * 搜索条件
     */
    private String search;

    public Page(int offset, int limit, String search, String order) {
        this.offset = offset;
        this.limit = limit;
        this.search = search;
        this.order = order;
    }


    // --计算 数据库 查询的参数 : LIMIT 3, 3; LIMIT offset, limit; --//
    /**
     * 计算偏移量
     */
    private void calcOffset() {
        this.offset = ((pageNo - 1) * pageSize);
    }

    /**
     * 计算限定数
     */
    private void calcLimit() {
        this.limit = pageSize;
    }


    // -- 构造函数 --//
    public Page() {
        this.calcOffset();
        this.calcLimit();
    }

    /**
     * 不分页
     * @param notPagination
     */
    public Page(boolean notPagination){
        if(notPagination){
            this.offset = 0;
            this.limit = Integer.MAX_VALUE;
        }
    }

    public Page(int offSet, int pageSize) {
        this.pageNo = offSet / pageSize + 1;
        this.pageSize = pageSize;
        this.offset = offSet;
//        this.calcOffset();
        this.calcLimit();
    }

   /* public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.calcOffset();
        this.calcLimit();
    }*/

    // -- 访问查询参数函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    public int getFirst() {
        return ((pageNo - 1) * pageSize) + 1;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
     */
    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    // -- 访问查询结果函数 --//
    /**
     * 根据pageSize与totalCount计算总页数, 默认值为-1.
     */
    public int getTotalPages() {
        if (total < 0) {
            return -1;
        }
        int pages = total / pageSize;
        return total % pageSize > 0 ? ++pages : pages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
