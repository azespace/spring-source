package com.xm.spring.step01.framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 20:50
 **/
public class BeanFactory {
    //定义Spring容器存储Bean对象
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();
    //Bean的获取
    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }
    //Bean的注册
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
