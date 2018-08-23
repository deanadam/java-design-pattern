package com.dean.observer;

/**
 * @author: Dean
 * @Date: 2018/8/22 18:31
 * @Description: 抽象被观察者接口
 *
 * 声明了添加、删除、通知观察者方法
 */
public interface Observerable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
