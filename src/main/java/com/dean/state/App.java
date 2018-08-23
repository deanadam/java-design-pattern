
package com.dean.state;

/**
 * @author: Dean
 * @date: 2018/8/22 17:01
 * Desc:人有不同的情绪状态，可以变化状态
 * 状态模式和策略模式的区别：？？
 * 策略模式与状态模式及其相似，但是二者有其内在的差别，策略模式将具体策略类暴露出去，调用者需要具体明白每个策略的不同之处以便正确使用。
 * 而状态模式状态的改变是由其内部条件来改变的，与外界无关，二者在思想上有本质区别。
 */
public class App {

  public static void main(String[] args) {

    //初始化状态
    Person person = new Person();
    //变愤怒
    person.angry();
    //变安静
    person.peaceful();
    //坠入爱河
    person.lovery();
    //便安静
    person.peaceful();

  }


}
