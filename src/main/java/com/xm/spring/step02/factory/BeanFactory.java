package com.xm.spring.step02.factory;

/**
 * @description: Bean的获取
 * @author: 小明长高高
 * @date: 2023/3/27 20:50
 **/
public interface BeanFactory {
    Object getBean(String beanName);
}
