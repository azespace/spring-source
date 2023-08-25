package com.xm.spring.step06.beans.factory;

import com.xm.spring.step06.beans.factory.config.AutowireCapableBeanFactory;
import com.xm.spring.step06.beans.factory.config.ConfigurableBeanFactory;
import com.xm.spring.step06.beans.factory.config.BeanDefinition;
import org.springframework.beans.BeansException;

/**
 * @author XM
 * description 扩展了bean清单接口，自动装配bean接口，配置bean接口，对getBeanDefinition应该很熟悉，之前是在写在抽象类AbstractBeanFactory里面的现在提升到了接口中
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 通过bean名称获取bean的定义信息
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 实例化bean之前操作
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

}
