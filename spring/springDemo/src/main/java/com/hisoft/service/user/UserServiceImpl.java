package com.hisoft.service.user;

import com.hisoft.dao.user.UserDao;
import com.hisoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
//    @Autowired//自动装配,默认安装类型
//    @Qualifier("userDao")
@Resource
    private UserDao userDao;


    public UserServiceImpl() {
    }

//    @Autowired
//    public void setUserDao(@Qualifier("userDao") UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public Integer saveUser(User user) {
        return userDao.add(user);
    }
}
