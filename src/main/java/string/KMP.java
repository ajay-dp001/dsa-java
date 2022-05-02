package string;

public class KMP {

  public final int R;     // The Radix
  private final int pat_len;
  private int[][] dfa;    // The KMP

  public KMP(final String pat) {
    this.R = 256;
    this.pat_len = pat.length();

    dfa = new int[R][pat_len];
    dfa[pat.charAt(0)][0] = 1;

    for (int i = 0, j = 1; j < pat_len; j++) {
      for (int k = 0; k < R; k++) {
        dfa[k][j] = dfa[k][i];
      }

      dfa[pat.charAt(j)][j] = j + 1;

      i = dfa[pat.charAt(j)][i];
    }
  }

  public KMP(final char[] pattern, int R) {
    this.R = R;
    this.pat_len = pattern.length;

    dfa = new int[R][pat_len];
    dfa[pattern[0]][0] = 1;
    for (int i = 0, j = 1; j < pat_len; j++) {
      for (int k = 0; k < R; k++) {
        dfa[k][j] = dfa[k][i];
      }
      dfa[pattern[j]][j] = j + 1;
      i = dfa[pattern[j]][i];
    }
  }

  public int search(String txt) {
    int len = txt.length();
    int i, j;
    for (i = 0, j = 0; i < len && j < pat_len; i++) {
      j = dfa[txt.charAt(i)][j];
    }
    if (j == pat_len) {
      return i - pat_len;
    }
    return len;
  }

  public int search(char[] txt) {
    int len = txt.length;
    int i, j;
    for (i = 0, j = 0; i < len && j < pat_len; i++) {
      j = dfa[txt[i]][j];
    }
    if (j == pat_len) {
      return i - pat_len;
    }
    return len;
  }

  public static void main(String[] args) {
    String txt = "ABABDABACDABABCABAB";
    String pat = "ABABCABAB";

    char[] text = txt.toCharArray();
    char[] pattern = pat.toCharArray();

    KMP kmp1 = new KMP(pat);
    int offset1 = kmp1.search(txt);

    KMP kmp2 = new KMP(pattern, 256);
    int offset2 = kmp2.search(text);

    System.out.println("text:" + txt);

    System.out.println("pattern: ");
    for (int i = 0; i < offset1; i++) {
      System.out.println(" ");
    }
    System.out.println(pat);

    System.out.println("pattern: ");
    for (int i = 0; i < offset2; i++) {
      System.out.println(" ");
    }
    System.out.println(pat);
  }

}
