package com.xm.spring.step03.factory.support;

import com.xm.spring.step03.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 11:48
 **/
public interface InstantiationStrategy {
    /**
     * 实例化策略将BeanDefinition中的类数据转成对象
     * 原来的那种方式无法实现构造器注入，所以这里需要传入构造器
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     */
    Object instantiate(BeanDefinition beanDefinition , String beanName , Constructor constructor,Object[] args);
}
