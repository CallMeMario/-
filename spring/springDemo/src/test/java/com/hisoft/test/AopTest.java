package com.hisoft.test;

import com.hisoft.pojo.User;
import com.hisoft.service.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void test01(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
     userService.saveUser(new User());
    }
}
