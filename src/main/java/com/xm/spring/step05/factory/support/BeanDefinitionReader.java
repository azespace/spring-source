package com.xm.spring.step05.factory.support;

import com.xm.spring.step05.core.io.Resource;
import com.xm.spring.step05.core.io.ResourceLoader;
import org.springframework.beans.BeansException;

/**
 * @author XM
 * description 用于从配置中读取BeanDefinition
 */
public interface BeanDefinitionReader {
    /**
     * 获取BeanDefinitionRegistry 不同的子类实现不同的注册表 默认实现是DefaultListableBeanFactory
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器 不同的子类实现不同的资源加载器 默认实现是DefaultResourceLoader
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 从指定的资源中读取BeanDefinition
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 从指定的资源中读取BeanDefinition 多个资源
     * @param resources
     * @throws BeansException
     */

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 从指定的资源中读取BeanDefinition
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

}
