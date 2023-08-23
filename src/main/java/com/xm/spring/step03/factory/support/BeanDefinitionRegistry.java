package com.xm.spring.step03.factory.support;

import com.xm.spring.step03.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    /**
     * 注册默认beanDefinition的接口
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
