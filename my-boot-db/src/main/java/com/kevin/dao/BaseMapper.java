package com.kevin.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础Mapper
 * Created by zmxie on 2017/7/28.
 */
public interface BaseMapper <T,PK> {

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectAll();
    /*
     * 分页
     */
    List<T> search(@Param("fromParam") Integer fromParam, @Param("toParam") Integer toParam);
}
