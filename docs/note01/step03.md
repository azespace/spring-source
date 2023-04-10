### 基于Cglib实现含构造函数的实例化策略

>完善一个功能，newInstance方法可以通过类的无参构造器实例化一个对象，但是如果这个类没有无参构造器比如被有参替代了，那么就会出现问题。因为上面的只提供了无参构造的实例化。

:smiling_face_with_three_hearts: 复习Class类的一些方法
````
//所有公共构造方法
public Constructor[] getConstructors()
//所有构造方法
public Constructor[] getDeclaredConstructors()
//获取某个构造方法
//参数表示的是：你要获取的构造方法的构造参数个数及数据类型的class字节码文件对象
public Constructor<T> getConstructor(Class<?>... parameterTypes)
````
````
//使用此Constructor对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例
public T newInstance(Object... initargs)
````
````
//获取所有的成员变量 公共的和全部的
Field[] fields = c.getFields();
Field[] fields = c.getDeclaredFields();
//获取单个的成员变量
Field addressField = c.getField("address")；
//获取所有的方法
Method[] methods = c.getMethods(); // 获取自己的包括父亲的公共方法
Method[] methods = c.getDeclaredMethods(); // 获取自己的所有的方法
//获取单个方法并使用
//第一个参数表示的方法名，第二个参数表示的是方法的参数的class类型
public Method getMethod(String name,Class<?>... parameterTypes)
````