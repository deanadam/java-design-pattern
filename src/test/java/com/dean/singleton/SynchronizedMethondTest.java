package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/8/7 09:58
 * @Description:
 */
public class SynchronizedMethondTest extends SingletonTest<SynchronizedMethond>{
    public SynchronizedMethondTest(){
        super(SynchronizedMethond::getInstance);
    }
}
