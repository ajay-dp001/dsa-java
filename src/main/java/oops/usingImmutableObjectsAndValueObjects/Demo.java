package oops.usingImmutableObjectsAndValueObjects;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Demo {

  private boolean isHappyHour;

  private Money reserve(Money cost) {
    Money finalCost = this.isHappyHour ? cost.scale(.5) : cost;
    System.out.println("Reversing an item costing " + finalCost);
    return finalCost;
  }

  private void buy(Money wallet, Money cost) {
    boolean enoughMoney = wallet.compareTo(cost) >= 0;
    this.reserve(cost);

    if (enoughMoney) {
      System.out.println("You will pay " + cost + " with your " + wallet);
    } else {
      System.out.println("You cannot pay " + cost + " with your " + wallet);
    }
  }

  public void run() {
    Currency eur = new Currency("EUR");
    Money eur2 = new Money(new BigDecimal(2), eur);
    Euro coin = new Euro(new BigDecimal(2), eur, "de");

    System.out.println();
    System.out.println(eur2 + " is " + (eur2.equals(coin) ? "" : "Not") + "equals to " + coin);
    System.out.println(coin + " is " + (coin.equals(eur2) ? "" : "Not") + "equals to " + eur2);

    System.out.println();
    Map<Integer, String> amountToName = new HashMap<>();
    amountToName.put(42, "Meaning of Life");

    Integer key = 42;
    System.out.println(key + " -> " + amountToName.getOrDefault(key, "Nothing, Really.."));

    Map<Money, String> costToName = new HashMap<>();
    costToName.put(new Money(new BigDecimal(42), new Currency("USD")), "Cost Of Life");
    Money cost = new Money(new BigDecimal(42), new Currency("USD"));
    System.out.println(cost + "->" + costToName.getOrDefault(cost, "Nothing, Really.."));
  }

}
