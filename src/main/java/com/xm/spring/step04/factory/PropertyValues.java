package com.xm.spring.step04.factory;

import com.xm.spring.step04.factory.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 15:09
 **/
public class PropertyValues {
    //用于给BeanDefinition用的，因为属性比较复杂而且多，很需要这个包装类。
    private final List<PropertyValue> propertyValueList = new ArrayList<>();
    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }
    public PropertyValue[] getPropertyValues(){
        //将List转化为PropertyValue类型的数组  参数表示指定转成什么类型  new PropertyValue[0] 容量为0的PropertyValue数组
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }
}
