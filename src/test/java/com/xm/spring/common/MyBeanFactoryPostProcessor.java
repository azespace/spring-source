package com.xm.spring.common;
import com.xm.spring.step06.beans.BeanException;
import com.xm.spring.step06.beans.PropertyValue;
import com.xm.spring.step06.beans.PropertyValues;
import com.xm.spring.step06.beans.factory.ConfigurableListableBeanFactory;
import com.xm.spring.step06.beans.factory.config.BeanDefinition;
import com.xm.spring.step06.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
