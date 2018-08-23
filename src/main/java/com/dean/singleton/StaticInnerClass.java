package com.dean.singleton;

import java.lang.reflect.Constructor;

/**
 * @author: Dean
 * @Date: 2018/7/30 17:51
 * @Description:
 * 这个模式综合使用了java的类级内部类和多线程缺省同步锁的知识，很巧妙的同时实现了延迟加载和线程安全。
 *
 * 为了解决并发问题，主要是通过使用synchronized来加互斥锁进行同步控制，但是在某些情况下，JVM已经隐含的为您执行了同步，这些情况下就不用自己再来进行同步控制了。
 * （1）由静态初始化器（在静态字段上或static{}块中的初始化器）初始化数据时
 * （2）访问final字段时
 * （3）在创建线程之前创建对象时
 * （4）线程可以看见它将要处理的对象时
 *
 * 实现原理：类级内部类里面去创建对象实例。这样一来，只要不使用到这个类级内部类， 那就不会创建对象实例，从而同步实现延迟加载和线程安全。
 * 因为内部静态类是要在有引用了以后才会装载到内存的。所以在你第一次调用getInstance()之前，SingletonHolder是没有被装载进来的，只有在你
 * 第一次调用了getInstance()之后，里面涉及到了return SingletonHolder.instance; 产生了对SingletonHolder的引用，内部静态类的实例才会真正装载。这也就是懒加载的意思
 *
 * 存在问题：还是会存在我通过反射去得到他的构造方法，然后把构造方法改为公共的，然后newInstance()创建对象
 *
 * 解决方法：考虑用枚举 ，因为枚举的构造器  可见性 是不可改变的 参考：com.dean.singleton\EnumVerion.java
 */
public class StaticInnerClass {
    private static class InnerSingle{
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    private StaticInnerClass(){}

    public static StaticInnerClass getInstance(){
        return InnerSingle.INSTANCE;
    }


    /**
     * @author: Dean
     * @date: 2018/7/30 17:55
     * Desc: 通关反射去改变  构造方法的私有属性
     */
    public static void main(String[] args) throws Exception{

        Constructor<StaticInnerClass> declaredConstructor = StaticInnerClass.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        StaticInnerClass sic1 = declaredConstructor.newInstance();
        StaticInnerClass sic2 = declaredConstructor.newInstance();

        for (int i = 0; i <5 ; i++) {
            System.out.println(StaticInnerClass.getInstance());
        }

        System.out.println("========================");
        System.out.println(sic1);
        System.out.println(sic2);

        System.out.println("sic1 与 sic2 是否相等：" + sic2.equals(sic1));


    }

}
