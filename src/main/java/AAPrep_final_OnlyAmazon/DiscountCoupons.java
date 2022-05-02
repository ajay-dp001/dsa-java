package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DiscountCoupons {

  public static void main(String[] args) {
    List<String> couponsList = Arrays.asList("abba", "abca", "abbacbbc", "aabb", "xaaxybbyzccz", "vaas",
        "jay","abbaccddbbaa");
    System.out.println("Result of Valid discount Coupons : " + coupons(couponsList));
  }

  public static List<Integer> coupons(List<String> discounts) {
    List<Integer> list = new ArrayList<>();
    for (String discount : discounts) {
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < discount.length(); i++) {
        if (!stack.isEmpty() && stack.peek() == discount.charAt(i)) {
          stack.pop();
        } else {
          stack.push(discount.charAt(i));
        }
      }
      if (stack.isEmpty()) {
        list.add(new Integer(1));
      } else {
        list.add(new Integer(0));
      }
    }
    return list;
  }

}
