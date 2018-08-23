package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/8/6 21:04
 * @Description:
 */
public class LazyTest extends SingletonTest<Lazy>{
    public LazyTest(){
        super(Lazy::getInstance);
    }
}
