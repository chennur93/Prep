package OtherProblems;

public class BalancedString {

  public static void main(String[] args) {
    balancedString("WQWRQQQW");
  }

  public static void balancedString(String s) {
    int len= s.length();
    int max = 0;
    for(int i=0; i< len;i+=4){
      int p=0, q=0, r=0, t=0;
      for(int j=0; j< 4;j++){
        if(s.charAt(i+j)=='Q'){
          p++;
        }
        else if(s.charAt(i+j)=='W') {
          q++;
        }
        else if(s.charAt(i+j)=='E') {
          r++;
        }
        else if(s.charAt(i+j)=='R') {
          t++;
        }
      }
      System.out.println("After Every Loop: "+p +" "+ +q +" "+ r +" "+ t);
      if ((p-1)>0)
        max+=p-1;
      else if(q-1>0)
        max+=q-1;
      else if(r-1>0)
        max+=r-1;
      else if(t-1>0)
        max+=t-1;
    }
  }
}
