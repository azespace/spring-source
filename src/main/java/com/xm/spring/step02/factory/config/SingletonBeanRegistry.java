package com.xm.spring.step02.factory.config;

public interface SingletonBeanRegistry {
    //定义一个获取单例对象的接口
    Object getSingleton(String beanName);
}
