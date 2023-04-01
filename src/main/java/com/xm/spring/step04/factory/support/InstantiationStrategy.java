package com.xm.spring.step04.factory.support;

import com.xm.spring.step04.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 11:48
 **/
public interface InstantiationStrategy {
    //实例化策略将BeanDefinition中的类数据转成对象
    // 接口规范定义，你想用那种策略呢，就定义好规范吧 由实现类决定具体实现
    Object instantiate(BeanDefinition beanDefinition , String beanName , Constructor constructor, Object[] args);
}
