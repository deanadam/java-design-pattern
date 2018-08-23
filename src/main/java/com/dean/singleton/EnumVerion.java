package com.dean.singleton;

/**
 * @author: Dean
 * @Date: 2018/7/30 17:47
 * @Description: 通关反射去改变  构造方法的私有属性
 */
public enum EnumVerion {

    INSTANCE;

    private StaticInnerClass instance;

    EnumVerion(){
        instance = StaticInnerClass.getInstance();
    }

    public StaticInnerClass getInstance() {
        return instance;
    }



}
