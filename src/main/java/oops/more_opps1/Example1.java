package oops.more_opps1;

public class Example1 {

  // This code is Bad..?
  // Why : It lacks flexibility and flexibility is top of the list on any customer expectation.
  /*public int sum(int[] values, boolean oddNumOnly, Selector selector) {
    int sum = 0;
    for (int value : selector.applyTo(values)) {
      if (oddNumOnly || value % 2 != 0) {
        sum += value;
      }
    }
    return sum;
  }
  */
}
