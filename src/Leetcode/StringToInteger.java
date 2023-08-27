package Leetcode;

public class StringToInteger {

  public static void main(String[] args) {
    String s = "+-2";
    System.out.println(atoi(s));
  }

  public static int atoi(String s) {
    boolean isNegative = false;
    String sout="";
    s = s.trim();
    int start = 0;

    if (s.charAt(0) == '-'){
      isNegative = true;
      start++;
    }else if (s.charAt(0) == '+'){
      start++;
    }

    for (int i = start; i<s.length(); i++) {
      if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
          sout += s.charAt(i);
        }
      else {
        break;
      }
    }

    if (sout.isEmpty())
      return 0;
    else if (isNegative){
      try{
        return -1*Integer.parseInt(sout);
      }catch (NumberFormatException n) {
        return Integer.MIN_VALUE;
      }
    }else {
      try {
        return Integer.parseInt(sout);
      }catch (NumberFormatException n) {
        return Integer.MAX_VALUE;
      }
    }
  }
}
