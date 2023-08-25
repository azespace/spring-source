package com.xm.spring.step06.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @description: spring容器的基本接口，提供bean的 获取，创建，生命周期 基础功能
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

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
