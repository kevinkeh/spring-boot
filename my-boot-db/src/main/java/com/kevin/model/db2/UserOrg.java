package com.kevin.model.db2;

import java.io.Serializable;

public class UserOrg implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer orgId;

    // Constructors

    /** default constructor */
    public UserOrg() {
    }

    /** full constructor */
    public UserOrg(Integer userId, Integer orgId) {
        this.userId = userId;
        this.orgId = orgId;
    }

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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}