package OtherProblems;

import Theory.Arays.Stacks;

public class BalancedParanthesis {

  public Boolean isValid(String str) {
    int length = str.length();
    Stacks stk = new Stacks();

    for (int i = 0; i < length; i++) {

      if (str.charAt(i) == '(') {
        stk.push(str.charAt(i));
      }else if (str.charAt(i) == '{') {
        stk.push(str.charAt(i));
      }else if (str.charAt(i) == '[') {
        stk.push(str.charAt(i));
      }else if (str.charAt(i) == ')') {
        if (stk.peak() != null && stk.peak().equals('(') && stk.size() > 0) {
          stk.pop();
        }else
          return false;
      }else if (str.charAt(i) == '}') {
        if (stk.peak() != null && stk.peak().equals('(') && stk.size() > 0) {
          stk.pop();
        }else
          return false;
      }else if (str.charAt(i) == ']') {
        if (stk.peak() != null && stk.peak().equals('(') && stk.size() > 0) {
          stk.pop();
        }else
          return false;
      }
    }
    return stk.size() == 0;
  }
}
