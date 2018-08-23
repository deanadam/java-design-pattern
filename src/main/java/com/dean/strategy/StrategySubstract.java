package com.dean.strategy;

/**
 * @author: Dean
 * @Date: 2018/8/17 18:49
 * @Description:
 */
public class StrategySubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
