package check;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckSortAsc {

  public static String check(String path) {
    String currStr;
    String nextStr;
    int currNum;
    int nextNum;
    BufferedReader brTargetFile = null;

    try {
      brTargetFile = new BufferedReader(new FileReader(new File(path)));

      currStr = brTargetFile.readLine();
      nextStr = brTargetFile.readLine();
      currNum = Integer.parseInt(currStr);
      nextNum = Integer.parseInt(nextStr);

      if (currNum > nextNum) return "Not Sorted.";

      nextStr = brTargetFile.readLine();

      while (nextStr != null) {
        currNum = nextNum;
        nextNum = Integer.parseInt(nextStr);

        if (currNum > nextNum) return "Not Sorted.";

        nextStr = brTargetFile.readLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (brTargetFile != null) brTargetFile.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return "Sorted.";
  }
}