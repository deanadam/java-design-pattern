package com.dean.strategy;

import org.junit.jupiter.api.Test;

/**
 * @author: Dean
 * @Date: 2018/8/17 18:53
 * @Description:
 *
 * 策略模式是一种定义一系列算法的方法，从概念上来看，所有这些算法完成的都是相同的工作，只是实现不同
 *
 * 这个对我们的代码扩展非常方便
 *
 * 优点： 1、算法可以自由切换。2、避免使用多重条件判断。3、扩展性良好。4、简化了单元测试，因为每个算法都有自己的类，可以通过自己的接口单独测试。
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 *
 * 针对 缺点 所以可以和工厂模式混合使用
 *
 * 麦头条的热门算法 ，可以考虑用一下策略模式  排序逻辑  简单 复杂  降级
 *
 */
public class testStrategy {
    @Test
    public void testContextStrategy(){
        ContextStrategy contextAdd = new ContextStrategy(new StrategyAdd());
        System.out.println("6 + 3 = " + contextAdd.executeStrategy(6, 3));

        ContextStrategy contextSubstract = new ContextStrategy(new StrategySubstract());
        System.out.println("6 - 3 = " + contextSubstract.executeStrategy(6, 3));

        ContextStrategy contextMulpitly = new ContextStrategy(new StrategyMulpitly());
        System.out.println("6 * 3 = " + contextMulpitly.executeStrategy(6, 3));

        ContextStrategy contextDivision = new ContextStrategy(new StrategyDivision());
        System.out.println("6 / 3 = " + contextDivision.executeStrategy(6, 3));

    }


    @Test
    public void testStrategyFactory(){

        ContextFactory contextFactory = new ContextFactory("substract");
        System.out.println("结果：" + contextFactory.executeStrategy(6, 3));

    }
}
