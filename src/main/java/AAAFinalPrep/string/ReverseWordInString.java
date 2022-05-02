package AAAFinalPrep.string;

public class ReverseWordInString {

  public static void main(String[] args) {
    String ans = "";
    String[] s = "getting good at coding needs a lot of practice".split("\\s");

    for (int i = s.length - 1; i >= 0; i--) {
      ans += s[i] + " ";
    }

    System.out.println("Reverse String is:");
    System.out.println(ans);
  }

}
