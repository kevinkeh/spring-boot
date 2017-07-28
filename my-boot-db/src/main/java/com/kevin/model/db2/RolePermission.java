package com.kevin.model.db2;

import java.io.Serializable;

public class RolePermission implements Serializable {
    private Integer id;

    private Integer roleId;

    public RolePermission(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    private Integer permissionId;
    private Permission permission;
    private Role role;

    // Constructors

    /** default constructor */
    public RolePermission() {
    }

    /** full constructor */
    public RolePermission(Permission permission, Role role) {
        this.permission = permission;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}