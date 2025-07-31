import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      String str ="welcome to dsa";
      String[] result = str.split("\\s+");
      System.out.println(Arrays.toString(result));
      System.out.println("No.of words: "+result.length);
  }
}
