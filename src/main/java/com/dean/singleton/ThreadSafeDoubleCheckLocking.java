package com.dean.singleton;

/**
 * @author: duanyaguang
 * @Date: 2018/7/27 11:23
 * @Description:
 */
public class ThreadSafeDoubleCheckLocking {
    /**
     * volatile 作用：假设没有关键字volatile的情况下，两个线程A、B，都是第一次调用该单例方法，线程A先执行instance = new Instance()，
     * 该构造方法是一个非原子操作，编译后生成多条字节码指令，由于JAVA的指令重排序，可能会先执行instance的赋值操作，
     * 该操作实际只是在内存中开辟一片存储对象的区域后直接返回内存的引用，之后instance便不为空了，但是实际的初始化操作却还没有执行，
     * 如果就在此时线程B进入，就会看到一个不为空的但是不完整（没有完成初始化）的Instance对象，所以需要加入volatile关键字，禁止指令重排序优化，
     * 从而安全的实现单例。
     */
    private static volatile ThreadSafeDoubleCheckLocking instance;
    private ThreadSafeDoubleCheckLocking() {
        // to prevent instantiating by Reflection call
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * @author: Dean
     * @date: 2018/7/27 11:24
     * Desc:用synchronized 块  代替 synchronized 方法  提高效率
     */
    public static ThreadSafeDoubleCheckLocking getInstance() {
        ThreadSafeDoubleCheckLocking result = instance;
        // 判断有没有初始话，如果有就直接返回
        if (result == null) {
            //加锁，确保只有一个线程进入 确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时避免了每次都同步的性能损耗。
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                //这里是为了，如果已经有线程已经创建了实例，也直接赋值返回
                result = instance;
                if (result == null) {
                    //到这了，这里可以安全的创建我们的单实例
                    instance = result = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
