package com.kevin.model.db2;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Permission implements Serializable {
    private Integer id = 0;

    private Integer pid = 0;

    private String name = "";

    private String type = "";

    private Integer sort = 0;

    private String url = "";

    private String permCode = "";

    private Set<RolePermission> rolePermissions = new HashSet<RolePermission>(0);

    /**
     * default constructor
     */
    public Permission() {
    }

    public Permission(Integer id) {
        this.id = id;
    }

    public Permission(Integer id, Integer pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public Permission(Integer pid, String name, String type, String url, String permCode) {
        this.pid = pid;
        this.name = name;
        this.type = type;
        this.url = url;
        this.permCode = permCode;
    }

    /**
     * full constructor
     */
    public Permission(Integer pid, String name, String type, Integer sort,
                      String url, String icon, String permCode, String description,
                      String state, Set<RolePermission> rolePermissions) {
        this.pid = pid;
        this.name = name;
        this.type = type;
        this.sort = sort;
        this.url = url;
        this.icon = icon;
        this.permCode = permCode;
        this.description = description;
        this.state = state;
        this.rolePermissions = rolePermissions;
    }

    private String icon = "";

    private String state = "";

    private String description = "";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode == null ? null : permCode.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}