package com.xm.spring.step02.factory.support;

import com.xm.spring.step02.exception.BeanException;
import com.xm.spring.step02.factory.config.BeanDefinition;

/**
 * @description: 创建bean并且加入单例容器后返回该对象 再抽象一层 单一职责
 * @author: 小明长高高
 * @date: 2023/3/27 22:54
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean ;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("Instantiation of bean failed");
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
