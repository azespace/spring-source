package com.xm.spring.step02.factory.support;


import com.xm.spring.step02.factory.BeanFactory;
import com.xm.spring.step02.factory.config.BeanDefinition;

/**
 * @description: 模板方法设计模式，相同实现放在一块，具体的不同的实现交给继承他的子类完成
 * @author: 小明长高高
 * @date: 2023/3/27 22:43
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 改成抽象类实现公共的获取Bean的方法，并且因为不同的子类实现不一样，所以交给不同的子类实现，也是模板方法设计模式的体现
     * 并且这个类拥有了父类的注册单例Bean的方法，注册方法每个类都会用到放到父类中
     * @param beanName
     * @return
     */
    @Override
    public Object getBean(String beanName) {
        Object singleton = getSingleton(beanName);
        if (singleton!=null){
            return singleton;
        }
        //谁继承了这个类，继承这个类就需要定义getBeanDefinition那么getBean就会使用自己定义的方法
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName);
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition);
}
