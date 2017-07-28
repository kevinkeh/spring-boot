package com.kevin.dao.db2;

import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.UserOrg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrgMapper extends BaseMapper<UserOrg,Integer> {
    /*
     *删除用户机构
     */
    void deleteUO(Integer userId);

    /*
     *查询用户拥有的机构id集合
     */
    List<Integer> findOrgIds(Integer userId);
}