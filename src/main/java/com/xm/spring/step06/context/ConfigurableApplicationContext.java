package com.xm.spring.step06.context;

import org.springframework.beans.BeansException;

/**
 * @author XM
 * description 通过继承ApplicationContext，间接拥有获取bean和创建bean的以及获取bean清单的能力  并且该接口再次扩展，拥有刷新容器的功能
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
