package com.xm.spring.test;

import com.xm.spring.step03.factory.UserService;
import com.xm.spring.step03.factory.config.BeanDefinition;
import com.xm.spring.step03.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 14:07
 **/
public class test03 {
    @Test
    public void test03(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class));
        UserService userService = (UserService)defaultListableBeanFactory.getBean("userService", 23);
        userService.queryById();
    }
}
