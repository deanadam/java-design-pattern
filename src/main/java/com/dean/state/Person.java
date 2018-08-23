
package com.dean.state;

/**
 * @author: Dean
 * @date: 2018/8/22 16:56
 * Desc: 人 有各种不同的状态
 */
public class Person {

  private State state;

  public Person() {
    state = new PeacefulState();
  }

  public void angry(){
    this.changeStateTo(new AngryState());
  }
  public void lovery(){
    this.changeStateTo(new LoveryState());
  }
  public void peaceful(){
    this.changeStateTo(new PeacefulState());
  }

  private void changeStateTo(State newState) {
    this.state = newState;
    this.state.onEnterState();
  }

}
