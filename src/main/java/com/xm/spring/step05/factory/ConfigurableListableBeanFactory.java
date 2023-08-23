package com.xm.spring.step05.factory;

import com.xm.spring.step05.factory.config.AutowireCapableBeanFactory;
import com.xm.spring.step05.factory.config.BeanDefinition;
import com.xm.spring.step05.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
