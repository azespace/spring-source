package com.xm.spring.step03.factory.support;

import com.xm.spring.step03.exception.BeanException;
import com.xm.spring.step03.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 23:29
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    //职责分明 继承了抽象类，实现需要实现的方法 这里是注册和获取BeanDefinition
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeanException("No bean named"+beanName+"is defined");
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
