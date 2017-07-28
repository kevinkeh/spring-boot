package com.kevin.model.db2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class User implements Serializable {
    private Integer id = 0;

    private String loginName = "";

    private String name = "";

    private String password = "";

    private String plainPassword = "";

    private String salt = "";

    private Date birthday = new Date();

    private Short gender = 0;

    private String email = "";

    private String phone = "";

    private String icon = "";

    private String state = "";

    private String description = "";

    private Integer loginCount = 0;

    private Date previousVisit = new Date();

    private Date lastVisit = new Date();

    private String delFlag = "";

    private Boolean isActive = false;

    private Date datachangeCreatetime = new Date();

    private Date datachangeLasttime = new Date();

    public int from;

    public int to ;

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    /**
     * default constructor
     */
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    /**
     * minimal constructor
     */
    public User(String loginName, String name, String password) {
        this.loginName = loginName;
        this.name = name;
        this.password = password;
    }

    public User(Integer id, String loginName, String name, String password, String plainPassword, String salt, Date birthday, Short gender, String email, String phone, String icon, String state, String description, Integer loginCount, Date previousVisit, Date lastVisit, String delFlag, Boolean isActive, Date datachangeCreatetime, Date datachangeLasttime, Set<UserRole> userRoles) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.password = password;
        this.plainPassword = plainPassword;
        this.salt = salt;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.icon = icon;
        this.state = state;
        this.description = description;
        this.loginCount = loginCount;
        this.previousVisit = previousVisit;
        this.lastVisit = lastVisit;
        this.delFlag = delFlag;
        this.isActive = isActive;
        this.datachangeCreatetime = datachangeCreatetime;
        this.datachangeLasttime = datachangeLasttime;
        this.userRoles = userRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @JsonIgnore
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getPreviousVisit() {
        return previousVisit;
    }

    public void setPreviousVisit(Date previousVisit) {
        this.previousVisit = previousVisit;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDatachangeCreatetime() {
        return datachangeCreatetime;
    }

    public void setDatachangeCreatetime(Date datachangeCreatetime) {
        this.datachangeCreatetime = datachangeCreatetime;
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", plainPassword='" + plainPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", icon='" + icon + '\'' +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", loginCount=" + loginCount +
                ", previousVisit=" + previousVisit +
                ", lastVisit=" + lastVisit +
                ", delFlag='" + delFlag + '\'' +
                ", isActive=" + isActive +
                ", datachangeCreatetime=" + datachangeCreatetime +
                ", datachangeLasttime=" + datachangeLasttime +
                ", userRoles=" + userRoles +
                '}';
    }
}