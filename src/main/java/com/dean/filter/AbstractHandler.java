package com.dean.filter;

/**
 * @author: Dean
 * @Date: 2018/8/22 18:11
 * @Description:
 */
public class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
