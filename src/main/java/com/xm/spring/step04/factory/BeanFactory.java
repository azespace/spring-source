package com.xm.spring.step04.factory;

import org.springframework.beans.BeansException;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 20:50
 **/
public interface BeanFactory {
    //Bean的获取 接口其实属于是给他一个规范
    Object getBean(String beanName) throws BeansException;
    //有参数的Bean的获取
    Object getBean(String name ,Object...args) throws BeansException, NoSuchMethodException;
}
