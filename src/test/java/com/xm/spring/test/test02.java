package com.xm.spring.test;

import com.xm.spring.step02.factory.UserService;
import com.xm.spring.step02.factory.config.BeanDefinition;
import com.xm.spring.step02.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/29 21:47
 **/
public class test02 {
    @Test
    public void test(){
        //初始化BeanDefinition工厂，因为由这个工厂完成类的实例化操作。
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //这个方法由BeanDefinitionRegistry接口定义，defaultListableBeanFactory实现后的registerBeanDefinition方法要求传入BeanName和BeanDefinition
        //BeanDefinition属性用的是Class,而不是Object,这样可以保证实例化对象的过程放入到Bean工厂中。
        //Service注册成功啦！
        defaultListableBeanFactory.registerBeanDefinition("userService",new BeanDefinition(UserService.class));
        //接下来就是重头戏，我们获取这个UserService类
        //这个getBean是这个类的父类(抽象类)AbstractAutowireCapableBeanFactory的父类AbstractBeanFactory(抽象类)实现的
        //AbstractAutowireCapableBeanFactory这个抽象类用于BeanDefinition的class的实例化，实现了createBean
        //AbstractBeanFactory就是定义了getBean方法，因为他继承了DefaultSingletonBeanRegistry所以拥有单例的注册和获取
        //AbstractBeanFactory的getBean方法获取到对象直接返回，获取不到则由子类的子类DefaultListableBeanFactory完成getBeanDefinition的实现获取BeanDefinition
        //AbstractBeanFactory的子类AbstractAutowireCapableBeanFactory完成对象实例化并放入单例容器后返回
        UserService userService = (UserService)defaultListableBeanFactory.getBean("userService");
        userService.queryById();
        //已经实例化后，就可以直接从单例容器中拿到之前注册的由Bean工厂父类实例化后的对象了，不用再注册了。
        UserService userService1 = (UserService)defaultListableBeanFactory.getBean("userService");
        System.out.println(userService == userService1);//true
    }
}
