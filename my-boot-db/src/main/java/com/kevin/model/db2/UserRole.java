package com.kevin.model.db2;

import java.io.Serializable;

public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private User user;
    private Role role;
    // Constructors

    /**
     * default constructor
     */
    public UserRole() {
    }

    /**
     * full constructor
     */
    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private Integer userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}