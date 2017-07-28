package com.kevin;

import com.kevin.dao.BaseMapper;

import java.util.List;

/**
 * Created by zmxie on 2017/7/28.
 */
public abstract class BaseService<T, PK> {

    public abstract BaseMapper<T, PK> getMapper();

    public int delete(PK id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    public int save(T record) {
        return getMapper().insert(record);
    }

    public int saveSelective(T record)
    {
        return getMapper().insertSelective(record);
    }

    public T get(PK id) {
        return getMapper().selectByPrimaryKey(id);
    }

    public int update(T record) {
        return getMapper().updateByPrimaryKey(record);
    }

    public int updateSelective(T record){
        return  getMapper().updateByPrimaryKeySelective(record);
    }

    public List<T> search(Integer from , Integer to){
        return getMapper().search(from,to);
    }

    public List<T> getAll(){
        return getMapper().selectAll();
    }

}
