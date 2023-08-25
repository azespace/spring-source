package com.xm.spring.step06.beans.factory.config;

import com.xm.spring.step06.beans.factory.HierarchicalBeanFactory;

/**
 * @author XM
 * description 扩展了spring容器基本接口和单例对象容器基本接口，主要扩展的内容提供添加BeanPostProcessor的能力  使用子接口的方式体现了设计的单一职责和接口隔离原则，其他类实现的时候只需要实现自己需要的接口即可，避免了不必要的实现
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加BeanPostProcessor
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
