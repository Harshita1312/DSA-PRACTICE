import java.util.*;

public class Main {
    public static int sumNaturalNum(int n){
      if(n==0) return 0;
      return n + sumNaturalNum(n-1);
    }
    public static void main(String[] args) {
      System.out.println(sumNaturalNum(5));
  }
}
