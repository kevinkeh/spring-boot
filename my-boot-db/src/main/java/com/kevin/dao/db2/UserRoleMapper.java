package com.kevin.dao.db2;


import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper extends BaseMapper<UserRole,Integer> {
    void deleteUR(@Param(value = "userId") Integer userId, @Param(value = "roleId") Integer roleId);
    List<Integer> findRoleIds(Integer userId);
    //根据用户id获取用户权限
    List<String> findRoles(Integer userId);
    //根用户名获取用户角色id
    int serchRoleIdByName(String naem);
    //
    void deleteURbyUid(Integer uId);
}