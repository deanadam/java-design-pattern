package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/7/30 17:36
 * @Description: 饿汉式（静态代码块）
 * 只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
public class SynchronizedBlock {

    private  static SynchronizedBlock instance ;

    static {
        instance = new SynchronizedBlock();
    }

    /**
     * 私有构造方法
     */
    private SynchronizedBlock(){}

    /**
     * @author: Dean
     * @date: 2018/7/31 9:15
     * Desc:静态方法
     */
    public static SynchronizedBlock getInstance(){
        return instance;
    }
}
