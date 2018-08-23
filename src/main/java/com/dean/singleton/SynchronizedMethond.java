package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/7/30 17:35
 * @Description: 懒汉式(线程安全，同步方法)[不推荐用]
 * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 */
public class SynchronizedMethond {
    private static SynchronizedMethond instance = null;

    private SynchronizedMethond(){}

    /**
     * @author: Dean
     * @date: 2018/7/30 16:01
     * Desc:静态方法发挥实力
     */
    public static synchronized SynchronizedMethond getInstance(){
        if(instance == null){
            instance = new SynchronizedMethond();
        }
        return instance;
    }
}
