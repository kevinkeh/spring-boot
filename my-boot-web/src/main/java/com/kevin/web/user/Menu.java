package com.kevin.web.user;

import java.util.List;
import java.util.Set;

/**
 * @author geyh
 * @create 2018-09-03 18:29
 */
public class Menu {

    private String menuName;

    private String menuUrl;

    private String menuClass;

    private boolean hasLeaf;

    private List<Menu> sonList;

    private Set<String> roleList;

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public boolean isHasLeaf() {
        return hasLeaf;
    }

    public void setHasLeaf(boolean hasLeaf) {
        this.hasLeaf = hasLeaf;
    }

    public List<Menu> getSonList() {
        return sonList;
    }

    public void setSonList(List<Menu> sonList) {
        this.sonList = sonList;
    }

    public Set<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<String> roleList) {
        this.roleList = roleList;
    }
}
