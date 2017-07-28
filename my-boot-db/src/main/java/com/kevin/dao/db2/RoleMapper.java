package com.kevin.dao.db2;


import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends BaseMapper<Role,Integer> {
    //根据角色名查询角色信息
    Role searchRole(String roleName);

}