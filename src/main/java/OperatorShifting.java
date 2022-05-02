public class OperatorShifting {

  public static void main(String[] args) {
    byte x = 10, y = -10;
    System.out.println("Bitwise Left Shift X<<2 :" + (x << 2));
    System.out.println("Bitwise Right Shift X>>2 :" + (x >> 2));
    System.out.println("Bitwise Zero fill Right Shift X>>>2 :" + (x >>> 2));
    System.out.println("Bitwise Zero Fill Right Shift Y>>>2:" + (y >>> 2));
  }

}
