package com.xm.spring.step06.beans.factory.config;

import com.xm.spring.step06.beans.factory.BeanFactory;
import org.springframework.beans.BeansException;

/**
 * @author XM
 * description 扩展了spring容器基本接口，主要扩展的内容是bean的自动装备功能  使用子接口的方式体现了设计的单一职责和接口隔离原则，其他类实现的时候只需要实现自己需要的接口即可，避免了不必要的实现
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
