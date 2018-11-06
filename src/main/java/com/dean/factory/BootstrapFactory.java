package com.dean.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Dean
 * @Date: 2018/11/5 16:59
 * @Description:
 * 参考：https://www.jianshu.com/p/05791ca6264b
 * bean工厂：不是bean，在spring中一般指的是DefaultListableBeanFactory对象，管理和维护spring中所有的bean
 * 工厂bean：一种特殊的bean，在xml文件中配置的，用来生成新的bean的加工厂，通过getObject()方法可以获取其生产的新bean，如果想获取该工厂bean本身，需要使用类似于getBean("&" + beanName)的样式。
 *
 * BeanFactory有三个子类：ListableBeanFactory、HierarchicalBeanFactory和Autowire Capable Bean Factory。但是从上图中我们可以发现最终的
 * 默认实现类是DefaultListableBeanFactory，他实 现了所有的接口。那为何要定义这么多层次的接口呢？查阅这些接口的源码和说明发现，每个接口都有他使用的场合，
 * 它主要是为了区分在Spring内部在操作过程中对象的传递和转化过程中，对对象的 数据访问所做的限制。例如ListableBeanFactory接口表示这些Bean是可列表的，
 * 而HierarchicalBeanFactory表示的是这些Bean是有继承关系的，也就是每个Bean有可能有父Bean。 AutowireCapableBeanFactory接口定义Bean的自动装配规则。
 * 这四个接口共同定义了Bean的集合、Bean之间的关系、以及Bean行为
 *
 * 看几个类：DefaultListableBeanFactory  默认实现类、AbstractAutowireCapableBeanFactory  真正创建对象的方法
 *
 * spring load xml : https://blog.csdn.net/zhengyong15984285623/article/details/51682276
 * spring create bean : https://blog.csdn.net/zhengyong15984285623/article/details/51684339
 *
 * sample  ： https://blog.csdn.net/zhengyong15984285623/article/details/51690969
 *
 */
public class BootstrapFactory {
    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        // 生成工厂类生成的具体实体类，值的是studentFactory生成的类
        Object people = applicationContext.getBean("myFactoryBean");
        System.out.println(people.toString());

        // 名字加了一个& 获取的是studentFactory本身
        MyFactoryBean myFactoryBean = (MyFactoryBean) applicationContext.getBean("&myFactoryBean");
        System.out.println(myFactoryBean.toString());


        /**
         * ==================================
         */

        Object studentSingle = applicationContext.getBean("studentSingle");
        Object studentSingle1 = applicationContext.getBean("studentSingle");

        Object studentPrototype = applicationContext.getBean("studentPrototype");
        Object studentPrototype1 = applicationContext.getBean("studentPrototype");
        Object studentPrototype2 = applicationContext.getBean("studentPrototype");

        System.out.println(studentSingle);
        System.out.println(studentSingle1);
        System.out.println("======aaa====");
        System.out.println(studentPrototype);
        System.out.println(studentPrototype1);
        System.out.println(studentPrototype2);

    }
}
