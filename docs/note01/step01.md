### 实现一个简单的Spring容器

> Spring拥有并管理对象的生命周期和配置，一个对象交给Spring，那么这个Bean对象就应该像零件一样被拆解后放入到Bean的定义中，解耦后使得对象更容易被管理，比如处理循环依赖。

1. 首先需要自定义一个容器，让他符合Spring的设计，用于存放名称切且是索引式的数据结构，HashMap非常合适，基于HashTable设计，效率高。
2. 容器的实现需要有Bean的定义，注册，获取三个基本步骤。
   - Bean的定义BeanDefinition，用于保存Bean的基本信息，这里我们简单处理，用Object
   - Bean的注册，就是把Bean放入Spring容器(HashMap)，这里使用BeanFactory做包装
   - Bean的获取，获取对象在Map中使用getKey获取(初始化的时候会将对象放入容器中)