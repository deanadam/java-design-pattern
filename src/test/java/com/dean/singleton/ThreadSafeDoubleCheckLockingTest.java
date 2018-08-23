package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/8/6 20:53
 * @Description:
 */
public class ThreadSafeDoubleCheckLockingTest extends SingletonTest<ThreadSafeDoubleCheckLocking> {

    public ThreadSafeDoubleCheckLockingTest() {
        super(ThreadSafeDoubleCheckLocking::getInstance);
    }

}
