package com.dean.state;

/**
 * @author: Dean
 * @date: 2018/8/22 16:55
 * Desc:
 */
public class PeacefulState implements State {

  @Override
  public void onEnterState() {
    System.out.println("我已经安静了！" );
  }

}
