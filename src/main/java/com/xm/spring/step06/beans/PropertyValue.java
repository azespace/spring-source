package com.xm.spring.step06.beans;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/4/1 15:09
 **/
public class PropertyValue {
    //类中的属性数据保存
    /*
    final case Class  不可以被子类继承
          case Method 不可以被重写
          case Value  只可以被赋值一次
          case Param  该参数的值不可以被改变
     public method(final int i,final Person p){
        i = i+1;//不可以，因为i不可变
        int j = i; j++ ; //可以，只是将值给了j j本身不是final 所以可以改变
        p = new Person(); //不可以，因为final修饰不可以变
        Person l = p ; //可以，只是多引用了一下，还是原来的Person
        Person.setName("xxx"); //name属性假如被final修饰则不可以 没有被final修饰则可以，而且会改变原始的传进来的Person对象 因为他们用的同一个引用 属于同一个对象。
     }
     */
    private final String name;
    private final Object value;
    public PropertyValue(String name,Object value){
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public Object getValue() {
        return value;
    }
}
