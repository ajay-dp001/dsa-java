package misc;

import java.util.Random;
import java.util.Scanner;

public class RandomNum {

  public static void main(String[] args) {
    final Random random = new Random();
    System.out.println(random.nextInt(2));

    int num;
    float fnum;
    String str;
    String str2;

    Scanner in = new Scanner(System.in);

    //Get input String
    System.out.println("Enter a string: ");
    str = in.nextLine();
    System.out.println("Input String is: "+str);

    //Get input Integer
    System.out.println("Enter an integer: ");
    num = in.nextInt();
    System.out.println("Input Integer is: "+num);

    //Get input float number
    System.out.println("Enter a float number: ");
    fnum = in.nextFloat();
    System.out.println("Input Float number is: "+fnum);

    //Get input String
    System.out.println("Enter a string 2: ");
    str2 = in.nextLine();
    System.out.println("Input String 2 is: "+str2);
  }

}
