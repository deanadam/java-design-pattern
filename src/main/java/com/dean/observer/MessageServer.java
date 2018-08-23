package com.dean.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dean
 * @Date: 2018/8/22 18:34
 * @Description:  被观察者
 *
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 *
 */
public class MessageServer implements Observerable{
    /**
     * 注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
     */
    private List<Observer> list;
    private String message;

    public MessageServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {

        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty())
            list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("消息服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
