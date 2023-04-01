package com.xm.spring.test;

import com.xm.spring.step04.factory.UserService;
import com.xm.spring.step04.factory.config.BeanDefinition;
import com.xm.spring.step04.factory.config.BeanReference;
import com.xm.spring.step04.factory.support.DefaultListableBeanFactory;
import com.xm.spring.step04.factory.PropertyValue;
import com.xm.spring.step04.factory.UserDao;
import com.xm.spring.step04.factory.PropertyValues;
import org.junit.Test;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 16:49
 **/
public class test04 {
    @Test
    public void test() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id","1"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        defaultListableBeanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class,propertyValues));
        UserService userService = (UserService)defaultListableBeanFactory.getBean("userService");
        userService.queryById();
    }
}
