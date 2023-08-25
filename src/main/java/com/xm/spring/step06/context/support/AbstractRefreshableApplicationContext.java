package com.xm.spring.step06.context.support;

import com.xm.spring.step06.beans.factory.ConfigurableListableBeanFactory;
import com.xm.spring.step06.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.BeansException;

/**
 * @author XM
 * description 内部提供了DefaultListableBeanFactory完全体工厂，提供了加载BeanDefinition的能力，由子类去实现具体的加载BeanDefinition的逻辑
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 由子类去实现具体的加载BeanDefinition的逻辑
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
