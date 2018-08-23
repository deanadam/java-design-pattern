package com.dean.singleton;

/**
 * @author: duanyaguang
 * @Date: 2018/7/30 14:04
 * @Description:饿汉式  及时加载
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class Eager {

    private static Eager instance = new Eager();

    /**
     * 私有的构造方法
     */
    private Eager(){}

    public static Eager getInstance(){
        return instance;
    }

}
