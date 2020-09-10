package com.hisoft.dao.user;

import com.hisoft.pojo.User;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public Integer add(User user) {
        System.out.println("添加用户成功");
        return 1;
    }
}
