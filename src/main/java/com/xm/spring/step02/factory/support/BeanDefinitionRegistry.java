package com.xm.spring.step02.factory.support;

import com.xm.spring.step02.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    //注册默认beanDefinition的接口
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
