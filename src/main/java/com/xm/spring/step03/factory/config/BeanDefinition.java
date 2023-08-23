package com.xm.spring.step03.factory.config;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 22:26
 **/
public class BeanDefinition {
    /**
     * 换成class可以将bean实例化的操作放入容器中处理，而不是实例化后放入容器。
     */
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
