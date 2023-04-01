package com.xm.spring.step04.factory.config;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 15:10
 **/
public class BeanReference {
    //如果是类的属性是引用类型则用到这个类
    private String beanName;
    public BeanReference(String beanName){
        this.beanName = beanName;
    }
    public String getBeanName() {
        return beanName;
    }
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
