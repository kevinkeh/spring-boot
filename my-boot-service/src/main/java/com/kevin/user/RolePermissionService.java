package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.RolePermissionMapper;
import com.kevin.model.db2.Permission;
import com.kevin.model.db2.Role;
import com.kevin.model.db2.RolePermission;
import com.kevin.shiro.AuthRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class RolePermissionService extends BaseService<RolePermission,Integer> {

	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	/**
	 * 获取角色权限id集合
	 * @param roleId
	 * @return List
	 */
	public List<Integer> getPermissionIds(Integer roleId){
		return rolePermissionMapper.findPermissionIds(roleId);
	}
	
	/**
	 * 修改角色权限
	 * @param id
	 * @param oldList
	 * @param newList
	 */
	public void updateRolePermission(Integer id, List<Integer> oldList, List<Integer> newList){
		//是否删除
		for(int i=0,j=oldList.size();i<j;i++){
			if(!newList.contains(oldList.get(i))){
				rolePermissionMapper.deleteRP(id,oldList.get(i));
			}
		}
		
		//是否添加
		for(int i=0,j=newList.size();i<j;i++){
			if(!oldList.contains(newList.get(i))){
				save(getRolePermission(id,newList.get(i)));
			}
		}
	}
	
	/**
	 * 清空该角色用户的权限缓存
	 */
	public void clearUserPermCache(PrincipalCollection pc){
		RealmSecurityManager securityManager =  (RealmSecurityManager) SecurityUtils.getSecurityManager();
		AuthRealm userRealm = (AuthRealm) securityManager.getRealms().iterator().next();
	    userRealm.clearCachedAuthorizationInfo(pc);
	}
	
	/**
	 * 构造角色权限对象
	 * @param roleId
	 * @param permissionId
	 * @return RolePermission
	 */
	private RolePermission getRolePermission(Integer roleId, Integer permissionId){
		RolePermission rp=new RolePermission();
		rp.setRoleId(roleId);
		rp.setRole(new Role(roleId));
		rp.setPermissionId(permissionId);
		rp.setPermission(new Permission(permissionId));
		return rp;
	}

	@Override
	public BaseMapper<RolePermission, Integer> getMapper() {
		return rolePermissionMapper;
	}

    /**
     * 删除角色相对应的权限
     * @param roleId
     */
	public  void deleteByRoleId(Integer roleId)
    {
        rolePermissionMapper.deleteByRoleId(roleId);
    }

	/**
	 *新增
	 */
	public int  insertSelectives(RolePermission rolePermission){
		return rolePermissionMapper.insertSelectives(rolePermission);
	}
}
