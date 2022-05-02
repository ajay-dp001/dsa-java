package AAAMSPrepare.array;

public class BasicCalculator {

  public static void main(String[] args) {
    String str = "3-2*2*4";
    System.out.println(basicCalculator(str));
  }

  private static int basicCalculator(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int num = 0, sum = 0, tempSum = 0;
    char lastSign = '+';

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch)) {
        num = num * 10 + ch - '0';
      }
      if (!Character.isDigit(ch) && ch != ' ' || i == str.length() - 1) {
        switch (lastSign) {
          case '+':
            sum += tempSum;
            tempSum = num;
            break;
          case '-':
            sum += tempSum;
            tempSum = -num;
            break;
          case '*':
            tempSum *= num;
            break;
          case '/':
            tempSum /= num;
            break;
        }
        lastSign = ch;
        num = 0;
      }
    }
    sum += tempSum;
    return sum;
  }

}
