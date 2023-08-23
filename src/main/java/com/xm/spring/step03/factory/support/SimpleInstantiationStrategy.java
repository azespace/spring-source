package com.xm.spring.step03.factory.support;

import com.xm.spring.step03.exception.BeanException;
import com.xm.spring.step03.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 13:04
 **/
public class SimpleInstantiationStrategy implements  InstantiationStrategy{
    /**
     * JDK反射 性能接口较差
     * @param beanDefinition
     * @param beanName
     * @param constructor
     * @param args
     * @return
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
        Class beanClass = beanDefinition.getBeanClass();
        try{
            if (null != constructor){
                //通过给定参数类型来确定实例化的对象,然后将需要的参数通过newInstance方法传入完成实例化
                //举例  beanClass.getDeclaredConstructor(int.class).newInstance(22222);
                beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else{
                //获取一个无参构造方法去实例化一个基本对象
                beanClass.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException|InstantiationException|IllegalAccessException| InvocationTargetException e){
            throw new BeanException("Failed to instantiate => "+beanClass.getName());
        }
        return null;
    }
}
