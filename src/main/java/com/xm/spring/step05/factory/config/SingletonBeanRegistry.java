package com.xm.spring.step05.factory.config;

public interface SingletonBeanRegistry {
    /**
     * 定义一个获取单例对象的接口
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
