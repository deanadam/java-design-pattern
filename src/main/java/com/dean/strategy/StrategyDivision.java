package com.dean.strategy;

/**
 * @author: Dean
 * @Date: 2018/8/17 18:51
 * @Description:
 */
public class StrategyDivision implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        //此处注重策略模式的应用，只给出简单实现，不考虑除数为0的情况
        return num1 / num2;
    }
}
