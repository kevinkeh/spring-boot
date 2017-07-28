package com.kevin.dao.db2;


import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<Permission,Integer> {

    List<Permission> findPermissions(Integer userId);

    List<Permission> findMenus();

    List<Permission> findMenusByUserId(Integer userId);

    List<Permission> findMenuOperationByUserId(Integer pid);

    List<Permission> findPressmionByname(String name);

}