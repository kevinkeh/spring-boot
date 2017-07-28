package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.UserOrgMapper;
import com.kevin.model.db2.UserOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class UserOrgService extends BaseService<UserOrg, Integer> {

	@Autowired
	private UserOrgMapper userOrgMapper;

	/**
	 * 添加修改用户机构
	 *
	 * @param newList
	 */
	public void updateUserOrg(Integer userId, List<Integer> newList) {
		// 删除老的机构关系
		userOrgMapper.deleteUO(userId);
		// 添加新的机构关系
		for (Integer integer : newList) {
			save(new UserOrg(userId, integer));
		}
	}

	/**
	 * 获取用户拥有机构id集合
	 * 
	 * @param userId
	 * @return 结果集合
	 */
	public List<Integer> getOrgIdList(Integer userId) {
		return userOrgMapper.findOrgIds(userId);
	}

	@Override
	public BaseMapper<UserOrg, Integer> getMapper() {
		return userOrgMapper;
	}
}
