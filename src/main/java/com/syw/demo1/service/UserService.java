package com.syw.demo1.service;

import com.syw.demo1.dao.UserDao;
import com.syw.demo1.entity.User;
import com.syw.util.PageInfo;
import com.syw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public PageInfo<User> getUserPageList() {

        List<User> list =userDao.findListAll();
        return new PageInfo<>(list);
    }

    public List<User> findListAll(){
        //int i=1/0  测试页面exception
        return userDao.findListAll();
    }
    public void save(User user){
        userDao.add(user);
    }

    public void edit(User user){
        userDao.edit(user);

    }
    public void login(User user){
       User current= userDao.getByPassword(user);
       if(null==current){
           try {
               throw new Exception("账号或密码错误");
           } catch (Exception e) {
               e.printStackTrace();
           }
       }else {
           UserUtil.setCurrentUser(current);
       }

    }
}
