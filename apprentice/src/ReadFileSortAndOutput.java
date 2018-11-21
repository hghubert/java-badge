import java.nio.charset.Charset;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileSortAndOutput {
  public static void main(String[] args) {
    List<String> fileContents = new ArrayList<String>();
    String inputFile = "sample.txt";
    String sortedFile = "sorted.txt";
    String reversedFile = "reversed.txt";

    System.setProperty("user.dir", System.getProperty("user.dir") + "/apprentice");

    fileContents = ReadFile(inputFile);

    java.util.Collections.sort(fileContents);

    WriteFile(fileContents, sortedFile);

    java.util.Collections.reverse(fileContents);

    WriteFile(fileContents, reversedFile);
  }

  public static List<String> ReadFile(String filename) {
    List<String> fileContents = new ArrayList<String>();

    Charset charset = Charset.forName("US-ASCII");

    try {
      BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/" + filename));

      String line = null;
      while ((line = reader.readLine()) != null) {
        fileContents.add(line);
      }
      reader.close();
    } catch (IOException e) {
      System.err.format("IOException: %s%n", e);
    }

    return fileContents;
  }

  public static int WriteFile(List<String> contents, String fileName) {
    Charset charset = Charset.forName("US-ASCII");

    int iCount = 0;

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/" + fileName));

      if (contents.size() > 0) {
        for (String line : contents) {
          writer.write(line);
          writer.newLine();
          iCount++;
        }
      }
      writer.flush();
      writer.close();
    } catch (IOException e) {
      System.err.format("IOException: %s%n", e);
    }
    return iCount;
  }
}
