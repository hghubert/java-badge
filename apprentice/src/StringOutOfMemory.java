import java.util.ArrayList;
import java.util.List;

public class StringOutOfMemory {
  public static void main(String[] args) {
    String s = "01234567890123456789012345678901234567890123456789";
    List<String> list = new ArrayList<>();
    long count = 0;
    long totalChars = 0;
    try {
      while(true) {
        count++;
        list.add(new StringBuilder(s).toString());
      }
    }
    catch (OutOfMemoryError e) {
      System.out.println("count: " + count + " totalChars: " + list.size() * s.length());
    }
  }
}
