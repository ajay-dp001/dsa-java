package designpattern.behavioral.strategy.example1;

public class Main {

  public static void main(String[] args) {
    FlyBehaviour flyBehaviour = new FlyWithWings();

    Duck mallardDuck = new MallardDuck(flyBehaviour);
    mallardDuck.performFly();
  }
}
