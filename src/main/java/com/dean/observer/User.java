package com.dean.observer;

/**
 * @author: Dean
 * @Date: 2018/8/22 18:36
 * @Description: 观察者
 *
 * 实现了update方法
 */
public class User implements Observer{

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
