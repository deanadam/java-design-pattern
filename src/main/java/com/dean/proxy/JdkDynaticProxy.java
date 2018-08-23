package com.dean.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Dean
 * @Date: 2018/8/7 14:05
 * @Description:
 */
public class JdkDynaticProxy implements InvocationHandler{

    private Object obj;

    public JdkDynaticProxy(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        //通过反射获取
        method.invoke(obj, args);
        doAfter();
        return null;
    }

    public void doBefore(){
        System.out.println("doBefore....");
    }

    public void doAfter(){
        System.out.println("doAfter....");
    }

    public static void main(String[] args) {
        Person person = new Person();
        InvocationHandler invocation = new JdkDynaticProxy(person);
        Class clazz = person.getClass();

        Proxy proxy = (Proxy) java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), invocation);
        proxy.todo();
    }
}
/**
 * @author: Dean
 * @date: 2018/8/7 15:27
 * Desc: 被代理的类
 */
class Person implements Proxy{
    @Override
    public void todo(){
        System.out.println("person TO DO");
    };
}