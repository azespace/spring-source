package com.xm.spring.step01;

/**
 * @ClassName BeanDefinition
 * @Description 简单的Bean对象包装，后续可以扩展属性，拥有更强大的功能,比如单例，ClassName相关属性的填充等
 * @Author XM
 * @Date 2022/11/02 11:35
 **/
public class BeanDefinition {
    private Object bean;
    public BeanDefinition(Object bean){
        this.bean = bean;
    }
    public Object getBean(){
        return bean;
    }
}
