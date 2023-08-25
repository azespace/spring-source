package com.xm.spring.step06.context.support;

import com.xm.spring.step06.beans.factory.ConfigurableListableBeanFactory;
import com.xm.spring.step06.beans.factory.config.BeanFactoryPostProcessor;
import com.xm.spring.step06.beans.factory.config.BeanPostProcessor;
import com.xm.spring.step06.context.ConfigurableApplicationContext;
import com.xm.spring.step06.core.io.DefaultResourceLoader;
import org.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author XM
 * description 继承DefaultResourceLoader拥有了解析资源的能力，实现了ConfigurableApplicationContext接口 该层是模板方法模式的最佳实践，让子类去实现具体逻辑，这层只做拼装
 * 使用模板方法进行算法模板定义的时候比如refresh方法，应该是拼接抽象层的方法的，而不是拼接继承的接口中的方法，这一层将接口的方法全部实现了，其实也可以不全部实现这里是因为需要委托给ConfigurableApplicationContext才全部实现的
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    /**
     * 刷新bean容器 模板方法模式 让子类去实现具体逻辑，这层只做拼装
     * @throws BeansException
     */
    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();
        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        // 5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 委托给ConfigurableListableBeanFactory，ConfigurableListableBeanFactory继承了全部的三个工厂接口
     * 那么子类DefaultListableBeanFactory就是一个万能的工厂，这里就相当于可以执行DefaultListableBeanFactory的方法了
     * @return
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 在Bean实例化之前，执行BeanFactoryPostProcessor
     * @param beanFactory
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * BeanPostProcessor 注册bean后执行该操作
     * @param beanFactory
     */
    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    /**
     * 这里是把getBeansOfType方法委托给了ConfigurableListableBeanFactory
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * 这里是把getBeanDefinitionNames方法委托给了ConfigurableListableBeanFactory
     * @return
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    /**
     * 这里是把getBean方法委托给了ConfigurableListableBeanFactory
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    /**
     * 这里是把getBean方法委托给了ConfigurableListableBeanFactory
     * @param name
     * @param args
     * @return
     * @throws BeansException
     * @throws NoSuchMethodException
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException, NoSuchMethodException {
        return getBeanFactory().getBean(name, args);
    }

    /**
     * 这里是把getBean方法委托给了ConfigurableListableBeanFactory
     * @param name
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

}
