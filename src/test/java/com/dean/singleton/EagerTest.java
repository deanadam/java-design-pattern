package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/8/6 21:23
 * @Description:
 */
public class EagerTest extends SingletonTest<Eager> {
    public EagerTest(){
        super(Eager::getInstance);
    }
}
