package com.xm.spring.step06.beans.factory.support;


import com.xm.spring.step06.beans.factory.config.BeanDefinition;
import com.xm.spring.step06.beans.factory.config.BeanPostProcessor;
import com.xm.spring.step06.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 模板方法设计模式，相同实现放在一块，具体的不同的实现交给继承他的子类完成
 * @author: 小明长高高
 * @date: 2023/3/27 22:43
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /**
     * 改成抽象类实现公共的获取Bean的方法，并且因为不同的子类实现不一样，所以交给不同的子类实现，也是模板方法设计模式的体现
     * 并且这个类拥有了父类的注册单例Bean的方法，注册方法每个类都会用到放到父类中
     * @param beanName
     * @return
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) getBean(beanName);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
