package com.dean.strategy;

import com.sun.istack.internal.NotNull;

/**
 * @author: Dean
 * @Date: 2018/8/17 18:58
 * @Description:
 */
public class ContextFactory {
    private Strategy strategy;

    /**
     * @author: Dean
     * @date: 2018/8/17 18:58
     * Desc:注意这里传入的参数是一个表示策略类型的字符串，而不是具体的策略对象
     */
    public ContextFactory(@NotNull String type){
        switch(type){
            case "add":
                StrategyAdd add = new StrategyAdd();
                strategy = add;
                break;
            case "substract":
                StrategySubstract substract = new StrategySubstract();
                strategy = substract;
                break;
            case "multiply":
                StrategyMulpitly mulpitly = new StrategyMulpitly();
                strategy = mulpitly;
                break;
            case "division":
                StrategyDivision division = new StrategyDivision();
                strategy = division;
                break;
        }
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1, num2);
    }
}
