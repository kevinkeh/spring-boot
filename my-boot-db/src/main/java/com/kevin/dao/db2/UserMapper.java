package com.kevin.dao.db2;

import com.kevin.dao.BaseMapper;
import com.kevin.model.db2.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User,Integer> {
    User findUniqueByLoginName(String loginName);
    List<User> search(int fromParam, int toParam);
     void resetPassword(User user);
     int getTotalCount();
     List<User> searchUserList(User user);
    int  selectTotalByDto(User user);
}