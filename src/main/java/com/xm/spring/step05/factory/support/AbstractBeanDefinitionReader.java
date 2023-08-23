package com.xm.spring.step05.factory.support;

import com.xm.spring.step05.core.io.DefaultResourceLoader;
import com.xm.spring.step05.core.io.ResourceLoader;

/**
 * @author XM
 * description 用于读取beanDefinition的抽象类 提供统一的注册beanDefinition和资源的工具
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 用于注册beanDefinition和注册单例bean对象 他有个默认实现是DefaultListableBeanFactory
     */
    private final BeanDefinitionRegistry registry;

    /**
     * 用于加载xml资源的beanDefinition的资源加载器
     */
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
