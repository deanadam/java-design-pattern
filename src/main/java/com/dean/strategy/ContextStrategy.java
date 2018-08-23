package com.dean.strategy;

/**
 * @author: Dean
 * @Date: 2018/8/17 18:52
 * @Description:
 */
public class ContextStrategy {

    private Strategy strategy;

    public ContextStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1, num2);
    }

}
