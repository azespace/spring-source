package com.xm.spring.step06.core.io;

/**
 * @author XM
 * description 获取资源的资源加载器
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源 主要是让子类提供一种默认实现获取资源
     * @param location
     * @return
     */
    Resource getResource(String location);

}
