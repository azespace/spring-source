package com.xm.spring.step02.factory.config;

/**
 * @description: 换成class可以实现更多更强大的功能，也可以在需要实例化的时候再实例化
 * @author: 小明长高高
 * @date: 2023/3/27 22:26
 **/
public class BeanDefinition {
    private Class beanClass;
    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }
    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
