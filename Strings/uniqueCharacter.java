import java.util.*;

public class Main {
    public static boolean uniqueCharacter(String str){
      HashSet<Character> set = new HashSet<>();
      str = str.replaceAll("\\s","").toLowerCase();
      for(char ch: str.toCharArray()){
        if(set.contains(ch)) return false;
        else{
          set.add(ch);
        }
      }
      return true;
    }
    public static void main(String[] args) {
      String str1 = "abcde";
      String str2 = "hello";
      if (uniqueCharacter(str1)){
        System.out.println("true");
      }
      else{
        System.out.println("false");
      }
  }
}
