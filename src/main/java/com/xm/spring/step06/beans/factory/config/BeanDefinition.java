package com.xm.spring.step06.beans.factory.config;

import com.xm.spring.step06.beans.PropertyValues;

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
    /**
     * 又多个属性，用于给实例化的对象填充属性值
     */
    private PropertyValues propertyValues;
    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }
    public BeanDefinition(Class beanClass, PropertyValues propertyValues){
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues():propertyValues;
    }
    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
