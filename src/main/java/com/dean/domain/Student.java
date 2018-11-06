package com.dean.domain;

/**
 * @author: Dean
 * @Date: 2018/11/5 18:40
 * @Description:
 */
public class Student extends People{
    @Override
    public String toString() {
        return this.hashCode()+"";
    }
}
