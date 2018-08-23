package com.dean.observer;

/**
 * @author: Dean
 * @Date: 2018/8/22 18:37
 * @Description:
 *
 * 这个模式是松偶合的。改变主题或观察者中的一方，另一方不会受到影像。
 */
public class App {
    public static void main(String[] args) {
        MessageServer server = new MessageServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}
