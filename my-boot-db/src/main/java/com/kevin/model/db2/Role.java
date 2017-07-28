package com.kevin.model.db2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {
    private Integer id = 0;

    private String name = "";

    private String roleCode = "";

    private String description = "";

    private Short sort = 0;

    private String delFlag = "";

    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);
    @JsonIgnore
    private Set<RolePermission> rolePermissions = new HashSet<RolePermission>(0);
    // Constructors

    /**
     * default constructor
     */
    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }

    /**
     * minimal constructor
     */
    public Role(String name, String roleCode) {
        this.name = name;
        this.roleCode = roleCode;
    }

    public Role(Integer id, String name, String roleCode, String description, Short sort, String delFlag, Set<UserRole> userRoles, Set<RolePermission> rolePermissions) {
        this.id = id;
        this.name = name;
        this.roleCode = roleCode;
        this.description = description;
        this.sort = sort;
        this.delFlag = delFlag;
        this.userRoles = userRoles;
        this.rolePermissions = rolePermissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}