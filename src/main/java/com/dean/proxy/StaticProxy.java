package com.dean.proxy;

/**
 * @author: Dean
 * @Date: 2018/8/7 11:12
 * @Description:
 */
public class StaticProxy {

    public static void main(String[] args) {
        //创建真实角色对象
        Proxy realityRole = new RealityRole();
        //创建代理角色对象，并制定真实对象
        ProxyRole proxyRole = new ProxyRole(realityRole);
        //代理角色工作，本质调用的还是真实角色的功能
        proxyRole.todo();
    }

}

/**
 * @author: Dean
 * @date: 2018/8/7 11:15
 * Desc:真实的代理角色
 */
class RealityRole implements Proxy{
    @Override
    public void todo(){
        System.out.println("真实角色的功能！");
    }
}

/**
 * @author: Dean
 * @date: 2018/8/7 11:15Re
 * Desc:代理角色
 */
class  ProxyRole implements Proxy {


    private Proxy realityRole ;

    public ProxyRole(Proxy p){
        this.realityRole = p;
    }

    @Override
    public void todo(){
        this.doBefore();
        this.realityRole.todo();
        this.doAfter();

    }
    private void doBefore() {
        System.out.println("代理角色,执行拦截的功能=============拦截前");
    }
    private void doAfter() {
        System.out.println("代理角色,执行拦截的功能=============拦截后");
    }
}
