package com.xm.spring.step06.beans.factory;
/**
 * @author XM
 * description 扩展了spring容器基本接口，扩展内容暂未实现  使用子接口的方式体现了设计的单一职责和接口隔离原则，其他类实现的时候只需要实现自己需要的接口即可，避免了不必要的实现
 */
public interface HierarchicalBeanFactory extends BeanFactory {
}
