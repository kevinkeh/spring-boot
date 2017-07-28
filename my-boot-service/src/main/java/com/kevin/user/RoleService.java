package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.RoleMapper;
import com.kevin.model.db2.Role;
import com.kevin.persistence.Page;
import com.kevin.persistence.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class RoleService extends BaseService<Role, Integer> {

	@Autowired
	private RoleMapper roleMapper;
	public Page<Role> search(Page<Role> logPage, List<PropertyFilter> filters ){
		logPage.setResult(super.search(logPage.getFrom(),logPage.getTo()));
		return logPage;
	}
	@Override
	public BaseMapper<Role, Integer> getMapper() {
		return roleMapper;
	}
}
