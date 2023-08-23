package com.xm.spring.step02.factory.support;

import com.xm.spring.step02.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 22:32
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 单例Bean容器
     */
    private Map<String,Object> singletonBean = new HashMap<>();

    /**
     * 默认的获取单例bean对象的实现
     * @param beanName
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonBean.get(beanName);
    }

    /**
     * 创建一个单独的注册bean的方法，使用protected保证子类可以使用该方法
     * @param beanName
     * @param singletonObj
     */
    protected void addSingleton(String beanName,Object singletonObj){
        singletonBean.put(beanName,singletonObj);
    }
}
