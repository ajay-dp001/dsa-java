package designpattern.behavioral.strategy.example1;

public class MallardDuck extends Duck {

  public MallardDuck(FlyBehaviour flyBehaviour) {
    super(flyBehaviour);
  }

  public void performFly() {
    flyBehaviour.fly();
  }
}
