package OtherProblems;

public class MaxNumberFive {

  public static int maxFive(int N) {

    String s = Integer.toString(N);
    System.out.println(s);
    int max = Integer.MIN_VALUE;
    for (int j1 = (N < 0) ? 1 : 0; j1 <= s.length(); ++j1) {
      int trial = Integer.parseInt(s.substring(0,j1) + "5" + s.substring(j1, s.length()));
      if (max < trial)
        max = trial;
    }
    return max;
  }
}
