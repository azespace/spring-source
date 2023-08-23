package com.xm.spring.step01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 定义Spring容器存储Bean对象
 * @author: 小明长高高
 * @date: 2023/3/27 20:50
 **/
public class BeanFactory {
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();

    /**
     * Bean的获取
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }

    /**
     * Bean的注册
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
