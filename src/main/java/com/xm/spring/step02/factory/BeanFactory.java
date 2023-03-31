package com.xm.spring.step02.factory;

import com.xm.spring.step01.framework.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 20:50
 **/
public interface BeanFactory {
    //Bean的获取 接口其实属于是给他一个规范
    Object getBean(String beanName);
}
