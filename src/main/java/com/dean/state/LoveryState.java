
package com.dean.state;

/**
 * @author: Dean
 * @date: 2018/8/22 17:18
 * Desc:Angry state.
 */
public class LoveryState implements State {


  @Override
  public void onEnterState() {
    System.out.println("我坠入爱河！！" );
  }

}
