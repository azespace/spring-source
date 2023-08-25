package com.xm.spring.step06.context;

import com.xm.spring.step06.beans.factory.ListableBeanFactory;

/**
 * @author XM
 * description 通过实现ListableBeanFactory接口，可以让ApplicationContext上下文拥有获取bean和创建bean的以及获取bean清单的能力
 */
public interface ApplicationContext extends ListableBeanFactory {
}
