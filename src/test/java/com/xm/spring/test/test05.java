package com.xm.spring.test;

import cn.hutool.core.io.IoUtil;
import com.xm.spring.bean.UserDao;
import com.xm.spring.bean.UserService;
import com.xm.spring.step05.core.io.DefaultResourceLoader;
import com.xm.spring.step05.core.io.Resource;
import com.xm.spring.step05.factory.PropertyValue;
import com.xm.spring.step05.factory.PropertyValues;
import com.xm.spring.step05.factory.config.BeanDefinition;
import com.xm.spring.step05.factory.config.BeanReference;
import com.xm.spring.step05.factory.support.DefaultListableBeanFactory;
import com.xm.spring.step05.factory.xml.XmlBeanDefinitionReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/08/23
 * Description:
 **/
public class test05 {
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_file() throws Exception {
        Resource resource = resourceLoader.getResource("src/test/resources/step05.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws Exception {
        Resource resource = resourceLoader.getResource("https://github.com/aszespace/spring-source/src/test/resources/step05.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService)beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
