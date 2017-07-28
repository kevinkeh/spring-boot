package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.UserRoleMapper;
import com.kevin.model.db2.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class UserRoleService extends BaseService<UserRole, Integer> {

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
	 * 添加修改用户角色
	 * 
	 * @param oldList
	 * @param newList
	 */
	public void updateUserRole(Integer userId, List<Integer> oldList, List<Integer> newList) {
		// 是否删除
		for (int i = 0, j = oldList.size(); i < j; i++) {
			if (!newList.contains(oldList.get(i))) {
				userRoleMapper.deleteUR(userId, oldList.get(i));
			}
		}

		// 是否添加
		for (int m = 0, n = newList.size(); m < n; m++) {
			if (!oldList.contains(newList.get(m))) {
				save(getUserRole(userId, newList.get(m)));
			}
		}
	}

	/**
	 * 构建UserRole
	 * 
	 * @param userId
	 * @param roleId
	 * @return UserRole
	 */
	private UserRole getUserRole(Integer userId, Integer roleId) {
		UserRole ur = new UserRole();
		ur.setUserId(userId);
		ur.setRoleId(roleId);
		return ur;
	}

	/**
	 * 获取用户角色
	 * @param userId
	 * @return
	 */
	public List<String> findRoles(Integer userId) {
		return userRoleMapper.findRoles(userId);
	}


	/**
	 * 获取用户拥有角色id集合
	 * 
	 * @param userId
	 * @return 结果集合
	 */
	public List<Integer> getRoleIdList(Integer userId) {
		return userRoleMapper.findRoleIds(userId);
	}

/*
	public Set<UserRole>  getRoleIdSet(Integer userId) {
		return userRoleMapper.getUserRole(userId);
	}*/

	@Override
	public BaseMapper<UserRole, Integer> getMapper() {
		return userRoleMapper;
	}
}
