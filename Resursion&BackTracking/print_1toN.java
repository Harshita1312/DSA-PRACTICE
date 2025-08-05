import java.util.*;

public class Main {
    public static void printNum(int n){
      if(n==0) return;
      printNum(n-1);
      System.out.print(n+" ");
    }
    public static void main(String[] args) {
      printNum(5);
  }
}
/*
    | function call|returned value | n value
  1 | printNum(5)  | printNum(4)   |  5
  2 | printNum(4)  | printNum(3)   |  4
  3 | printNum(3)  | printNum(2)   |  3
  4 | printNum(2)  | printNum(1)   |  2
  5 | printNum(1)  | printNum(0)   |  1 
  6 | printNum(0)  |  return;   
  
  backtracking

*/
