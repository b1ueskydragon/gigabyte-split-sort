
package jp.ma.jang;

import static jp.ma.jang.FilePath.*;
import static jp.ma.jang.Utility.*;

public class App {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    String input;
    String output;

    if (System.getProperty("user.dir").contains(MY_PC)) {
      input = TARGET_PATH;
      output = RESULT_PATH;
    } else {
      input = TARGET_PATH_;
      output = RESULT_PATH_;
    }

    FileLogic fl = new FileLogic(input, output);
    QuickSortLogic qs = new QuickSortLogic();

    int branch = 0;

    for (int n = 1; n <= SPLIT_LINE; n++) {
      int[] ary = fl.read(branch, DIVISION_RANGE);
      qs.quickSort(ary, 0, ary.length - 1);
      fl.write(ary);
      ary = null; // GC

      branch += DIVISION_RANGE;
      System.out.println(n + " th");
    }

    long end = System.currentTimeMillis();
    System.out.println((end - start) / 1000 + " second");
  }
}
