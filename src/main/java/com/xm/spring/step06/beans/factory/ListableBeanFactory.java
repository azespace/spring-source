package com.xm.spring.step06.beans.factory;

import org.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author XM
 * description 扩展了spring容器基本接口，主要扩展的内容是bean清单查询  使用子接口的方式体现了设计的单一职责和接口隔离原则，其他类实现的时候只需要实现自己需要的接口即可，避免了不必要的实现
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
