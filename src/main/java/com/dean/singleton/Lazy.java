package com.dean.singleton;

/**
 * @author: Dean
 * @date: 2018/7/30 16:02
 * Desc:懒汉式 延迟加载
 */
public class Lazy {

    private static Lazy instance = null;

    private Lazy(){}

    /**
     * @author: Dean
     * @date: 2018/7/30 16:01
     * Desc:存在很多问题：线程不安全，效率也不高
     */
    public static  Lazy getInstance(){
        if(instance == null){
            instance = new Lazy();
        }
        return instance;
    }

}
