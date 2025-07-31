import java.util.*;

public class Main {
    public static void main(String[] args) {
      // count vowels and consonants
      String str ="Hello welcome to dsa";
      String lowerStr = str.toLowerCase();
      int vowels = 0;
      int consonants = 0;
      for(char ch : lowerStr.toCharArray()){
        if("aeiou".indexOf(ch)!=-1) vowels++;
        else consonants++;
      }
      System.out.println("Vowels: "+vowels+"\nConsonants: "+consonants);
  }
}
