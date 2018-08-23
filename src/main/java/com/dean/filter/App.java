package com.dean.filter;

/**
 * @author: Dean
 * @Date: 2018/8/22 18:13
 * @Description:
 *
 * 职责链模式对于请求的处理是不知道最终处理者是谁 ，这里要区别下命令模式
 * 命令模式中对于命令的处理时在创建命令是已经显式或隐式绑定了接收者
 *
 * 不足之处：对于每一个请求都需要遍历职责链，性能是个问题
 */
public class App {
    public static void main(String[] args) {
        MyHandler h1=new MyHandler("张三");
        MyHandler h2=new MyHandler("李四");
        MyHandler h3=new MyHandler("王五");
        MyHandler h4=new MyHandler("麻子");
        //职责链模式对于请求的处理是不知道最终处理者是谁，所以是运行动态寻找并指定；
        h1.setHandler(h2);
        h2.setHandler(h3);
        h3.setHandler(h4);
        h1.operator();
    }
}
