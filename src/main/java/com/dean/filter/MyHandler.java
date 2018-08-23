package com.dean.filter;

/**
 * @author: Dean
 * @Date: 2018/8/22 18:12
 * @Description:
 */
public class MyHandler extends AbstractHandler implements Handler{
    private String name;
    public MyHandler(String name){
        this.name=name;
    }
    @Override
    public void operator() {
        System.out.println(name+"filter....");
        if(getHandler()!=null){
            getHandler().operator();
        }
    }
}
