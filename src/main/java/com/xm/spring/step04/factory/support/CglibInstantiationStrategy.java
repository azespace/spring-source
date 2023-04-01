package com.xm.spring.step04.factory.support;

import com.xm.spring.step04.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 13:19
 **/
public class CglibInstantiationStrategy implements InstantiationStrategy {
    //通过Cglib实例化 使用ASM字节码技术，比反射性能高很多
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) {
        //cglib库提供的类，通过生成子类动态创建代理对象 常见的代理模式，用于动态运行时为目标对象提供额外的功能
        Enhancer enhancer = new Enhancer();
        //将父类Class传入
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        //如果只是实例化对象而不需要增强的话就传个空的对象NoOp随便实现一个方法
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        //如果实例化后需要对某些方法增强
        //这里就非常熟悉了，AOP可以对某个目标方法增强，且他是在运行时生成的代理类字节码，避免编译器就需要定义代理类
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                //doSomething....
//                Object result = methodProxy.invokeSuper(objects, args);
//                //doSomething....
//                return result;
//            }
//        });
        //创建无参数的对象
        if (null ==constructor) return enhancer.create();
        //创建有参数的对象
        return enhancer.create(constructor.getParameterTypes(),args);
    }
}
