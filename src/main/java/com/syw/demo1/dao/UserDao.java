package com.syw.demo1.dao;

import com.syw.demo1.entity.User;
import com.syw.rad.annotation.persistence.annotation.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface UserDao {
    List<User> findListAll();
    User get(User user);
    void add(User user);
    void edit(User user);
    void delete(User user);
    User getByPassword(User user);
}
