package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.PermissionMapper;
import com.kevin.dao.db2.UserRoleMapper;
import com.kevin.model.db2.Permission;
import com.kevin.model.db2.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class PermissionService extends BaseService<Permission,Integer> {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 添加菜单基础操作
     *
     * @param pid 菜单id
     */
    public void addBaseOpe(Integer pid, String pClassName) {
        List<Permission> pList = new ArrayList<Permission>();
        pList.add(new Permission(pid, "添加", "O", "", "sys:" + pClassName + ":add"));
        pList.add(new Permission(pid, "删除", "O", "", "sys:" + pClassName + ":delete"));
        pList.add(new Permission(pid, "修改", "O", "", "sys:" + pClassName + ":update"));
        pList.add(new Permission(pid, "查看", "O", "", "sys:" + pClassName + ":view"));

        //添加没有的基本操作
        List<Permission> existPList = getMenuOperation(pid);
        for (Permission permission : pList) {
            boolean exist = false;
            for (Permission existPermission : existPList) {
                if (permission.getPermCode().equals(existPermission.getPermCode())) {
                    exist = true;
                    break;
                } else {
                    exist = false;
                }
            }
            if (!exist)
                save(permission);
        }
    }

    /**
     * 获取角色拥有的权限集合
     *
     * @param userId
     * @return 结果集合
     */
    public List<Permission> getPermissions(Integer userId) {
        return permissionMapper.findPermissions(userId);
    }

    /**
     * 获取角色拥有的菜单
     *
     * @param userId
     * @return 菜单集合
     */
    public List<Permission> getMenus(Integer userId) {
        return permissionMapper.findMenusByUserId(userId);
    }

    /**
     * 获取所有菜单
     *
     * @return 菜单集合
     */
    public List<Permission> getMenus() {
        return permissionMapper.findMenus();
    }

    /**
     * 获取菜单下的操作
     *
     * @param pid
     * @return 操作集合
     */
    public List<Permission> getMenuOperation(Integer pid) {
        return permissionMapper.findMenuOperationByUserId(pid);
    }

    /**
     * 新增菜单并插入角色权限信息
     *
     * @param  record, naem
     * @return 操作集合
     */
    @Transactional
    public int savePremissionRole(Permission record,String name){
        getMapper().insert(record);
        RolePermission rolePermission=new RolePermission();
        int roleId= userRoleMapper.serchRoleIdByName(name);
        List<Permission> permissions= findPressmionByname(record.getName());
        for (Permission permission :permissions) {
            if(permission.getPid().equals(record.getPid())){
                rolePermission.setRoleId(roleId);
                rolePermission.setPermissionId(permission.getId());
                return rolePermissionService.insertSelectives(rolePermission);
            }
        }
        return 0;
    }

    @Override
    public BaseMapper<Permission, Integer> getMapper() {
        return permissionMapper;
    }

    //根据权限名获取权限
    public List<Permission> findPressmionByname(String name){
        return permissionMapper.findPressmionByname(name);
    }
}
