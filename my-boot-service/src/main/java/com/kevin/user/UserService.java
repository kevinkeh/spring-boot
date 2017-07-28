package com.kevin.user;

import com.kevin.BaseService;
import com.kevin.dao.BaseMapper;
import com.kevin.dao.db2.UserMapper;
import com.kevin.dao.db2.UserRoleMapper;
import com.kevin.model.db2.User;
import com.kevin.persistence.Page;
import com.kevin.persistence.PropertyFilter;
import com.kevin.util.DateUtils;
import com.kevin.util.Digests;
import com.kevin.util.Encodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xwlin on 2017/3/11.
 */
@Service
public class UserService extends BaseService<User, Integer> {
	
	/**加密方法*/
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;	//盐长度

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	public Page<User> search(Page<User> page , List<PropertyFilter> filters){
		List<User> users= userMapper.search(page.getFrom(),page.getTo());
		page.setResult(users);
		page.setTotalCount(userMapper.getTotalCount());
		return page;
	}
	/**
	 * 保存用户
	 * @param user
	 */
	public void saveUsr(User user) {
		entryptPassword(user);
		user.setDatachangeCreatetime(DateUtils.getSysTimestamp());
		super.save(user);
	}

	/**
	 * 保存用户
	 * @param user
	 */
	public void repwd(User user) {
		if(user.getId()==null){
			user.setId(getId(user));
		}
		entryptPassword(user);
		user.setDatachangeCreatetime(DateUtils.getSysTimestamp());
		 userMapper.resetPassword(user);
	}

	/**
	 * 获取用户id
	 * @param user
	 */
	public  int getId(User user){
		int id=getUser(user.getLoginName()).getId();
		return id;
	}







	/**
	 * 修改密码
	 * @param user
	 */
	public void updatePwd(User user) {
		entryptPassword(user);
		super.save(user);
	}

	@Override
	public BaseMapper<User, Integer> getMapper() {
		return userMapper;
	}

	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteUsr(Integer id){
		if(!isSupervisor(id))
			super.delete(id);
		userRoleMapper.deleteURbyUid(id);
	}
	
	/**
	 * 按登录名查询用户
	 * @param loginName
	 * @return 用户对象
	 */
	public User getUser(String loginName) {
		return userMapper.findUniqueByLoginName(loginName);
	}
	
	/**
	 * 判断是否超级管理员
	 * @param id
	 * @return boolean
	 */
	private boolean isSupervisor(Integer id) {
		return id == 1;
	}
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(),salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	/**
	 * 验证原密码是否正确
	 * @param user
	 * @param oldPassword
	 * @return
	 */
	public boolean checkPassword(User user,String oldPassword){
		byte[] salt =Encodes.decodeHex(user.getSalt()) ;
		byte[] hashPassword = Digests.sha1(oldPassword.getBytes(),salt, HASH_INTERATIONS);
		if(user.getPassword().equals(Encodes.encodeHex(hashPassword))){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 修改用户登录
	 * @param user
	 */
	public void updateUserLogin(User user){
		user.setLoginCount((user.getLoginCount()==null?0:user.getLoginCount())+1);
		user.setPreviousVisit(user.getLastVisit());
		user.setLastVisit(DateUtils.getSysTimestamp());
		update(user);
	}

	/**
	 * 多条件分页查询机场数据（carsdvendordb）
	 * @param page
	 * @param filters
	 * @return
	 */
	@Transactional(value = "osdvcTransactionManager")
	public Page<User> searchByDto(Page<User> page , List<PropertyFilter> filters, User user){
		page.setResult(searchUserList(user,page));
		page.setTotalCount(userMapper.selectTotalByDto(user));
		return page;
	}
	/**
	 * 根据条件分页查询
	 * @param user
	 * @param page
	 * @return
	 */
	public List<User> searchUserList(User user, Page<User> page){
		user.setFrom(page.getFrom());
		user.setTo(page.getTo());
		return  userMapper.searchUserList(user);
	}
	
}
