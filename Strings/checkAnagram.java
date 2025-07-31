import java.util.*;

public class Main {
    public static boolean checkAnagram(String str1, String str2){
      
      str1 = str1.replaceAll("\\s","").toLowerCase();
      str2 = str2.replaceAll("\\s","").toLowerCase();
      
      //Condition 1 : same length
      if(str1.length() != str2.length()){
        return false;
      }
      //Condition 2 : same Characters
      char[] s1 = str1.toCharArray();
      char[] s2 = str2.toCharArray();
      Arrays.sort(s1);
      Arrays.sort(s2);
      return(Arrays.equals(s1,s2));
      
    }
    public static void main(String[] args) {
      String str1 = "silent";
      String str2 = "listen";
      if (checkAnagram(str1, str2)){
        System.out.println("Strings are Anagrams");
      }
      else{
        System.out.println("Not anagrams");
      }
  }
}
