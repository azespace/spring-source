package com.xm.spring.step05.factory;

import org.springframework.beans.BeansException;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 20:50
 **/
public interface BeanFactory {
    /**
     * 无参数的Bean的获取
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 有参数的Bean的获取
     * @param name
     * @param args
     * @return
     * @throws BeansException
     * @throws NoSuchMethodException
     */
    Object getBean(String name ,Object...args) throws BeansException, NoSuchMethodException;
}
