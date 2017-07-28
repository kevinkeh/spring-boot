package com.kevin.dao.db2;

import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission, Integer> {

    List<Integer> findPermissionIds(Integer roleId);

    void deleteRP(@Param(value = "roleId") Integer roleId, @Param(value = "permissionId") Integer permissionId);

    void deleteByRoleId(@Param(value = "roleId") Integer roleId);

    int insertSelectives(RolePermission rolePermission);
}