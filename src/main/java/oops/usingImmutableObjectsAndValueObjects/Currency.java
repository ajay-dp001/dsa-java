package oops.usingImmutableObjectsAndValueObjects;

import java.math.BigDecimal;

public final class Currency implements Comparable<Currency> {

  private String symbol;

  @Override
  public boolean equals(Object object) {
    return object instanceof Currency && this.equals((Currency) object);
  }

  private boolean equals(Currency other) {
    return this.symbol.equals(other.symbol);
  }

  @Override
  public int hashCode() {
    return this.symbol.hashCode();
  }

  public Currency(String symbol) {
    this.symbol = symbol;
  }

  public Money zero() {
    return new Money(BigDecimal.ZERO, this);
  }

  @Override
  public int compareTo(Currency other) {
    return this.symbol.compareTo(other.symbol);
  }

  @Override
  public String toString() {
    return this.symbol;
  }
}
