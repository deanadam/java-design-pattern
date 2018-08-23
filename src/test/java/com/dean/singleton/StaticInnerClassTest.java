package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/8/7 09:59
 * @Description:
 */
public class StaticInnerClassTest extends SingletonTest<StaticInnerClass>{
    public StaticInnerClassTest(){
        super(StaticInnerClass::getInstance);
    }
}
