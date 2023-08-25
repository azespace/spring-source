package com.xm.spring.step06.context.support;


import com.xm.spring.step06.beans.factory.support.DefaultListableBeanFactory;
import com.xm.spring.step06.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author XM
 * description 实现了加载BeanDefinition的能力，
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
