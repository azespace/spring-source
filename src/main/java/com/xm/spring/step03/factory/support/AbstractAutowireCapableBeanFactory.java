package com.xm.spring.step03.factory.support;

import com.xm.spring.step03.exception.BeanException;
import com.xm.spring.step03.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/3/27 22:54
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 创建bean并且加入单例容器后返回该对象 再抽象一层 单一职责
     */
    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed");
        }
        addSingleton(beanName,bean);
        return bean;
    }
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName,beanDefinition,args);
        } catch (Exception e) {
            throw new BeanException("Instantiation of bean failed");
        }
        addSingleton(beanName,bean);
        return bean;
    }
    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args){
        //获取类的所有构造函数Constructor 以便于决定通过什么参数去实例化这个对象
        Constructor[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        Constructor constructor = null;
        //循环比较每个构造函数的 参数的个数 参数的类型  以便于找得到正确的constructor
        for (Constructor declaredConstructor : declaredConstructors) {
            //获取其中一个的构造函数的参数类型
            Class[] parameterTypes = declaredConstructor.getParameterTypes();
            //比较
            if (args != null && parameterTypes.length == args.length) {
                boolean match = true;
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (!parameterTypes[i].isAssignableFrom(args[i].getClass())) {
                        match = false;
                        break;
                    }
                }
                //如果长度和类型全部可以匹配则表示找到了正确的
                if (match) {
                    constructor = declaredConstructor;
                    break;
                }
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,beanName,constructor,args);
    }
}
