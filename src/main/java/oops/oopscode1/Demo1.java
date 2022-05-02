package oops.oopscode1;

public class Demo1 {
/*
  public static void main(String[] args) {

  }

  public Painter findCheapest(double sqMeter, List<Painter> painters) {
    //Special Values & NUll
    Money lowestCost = Mone.ZERO;
    Painter winner = null;

    for (Painter candidate : painters) {
      if (candidate.isAvailable()) {
        Money cost = candidate.estimateCompensation(sqMeter);
        // Check for edge case
        if (winner == null || cost.compareTo(lowestCost) <= 0) {
          winner = candidate;
          lowestCost = cost;
        }
      }
    }
    // Making the result hard to predict
    return winner;
  }

  public Optional<Painter> findCheapestOOPs1(double sqMeter, List<Painter> painters) {
    return painters.stream()
        .filter(Painter::isAvailable)
        .min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeter)));
  }

  public Optional<Painter> findCheapestOOPs2(double sqMeter, List<Painter> painters) {
    return painters.stream()
        .filter(Painter::isAvailable)
        .min(Comparator.comparing(painter -> painter.estimateCompensation(sqMeter)))
        .get();
  }

  private static Optional<Painter> findCheapestOOPs1(double sqMeter, List<Painter> painters) {
    return painters.stream()
        .filter(Painter::isAvailable)
        .reduce((acc, current) -> acc.estimateCompensation(sqMeter)
            .compareTo(current.estimateCompensation(sqMeter)) <= 0 ? acc : current)
        .get();
  }

  private static Money getCostOOPs(double sqMeter, List<Painter> painters) {
    return painters.stream()
        .filter(Painter::isAvailable)
        .map(painter -> painter.estimateCompensation(sqMeter))
        .reduce(Money::add)
        .orElse(Money.ZERO);
  }
*/
}
