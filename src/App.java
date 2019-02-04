import check.CheckSortAsc;
import file.FileLogicImpl;
import sort.QuickSort;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    String dir = new Scanner(System.in).nextLine();
    String given = dir + "/sort_median.txt";
    String result = dir + "/sort_result.txt";

    // TODO on-memory (read-in)
    sortAsc(given, result);
    checkAsc(result);
  }

  private final static Integer DIVISION_RANGE = 200_000_000;

  private final static Integer REPEAT_TIME = 10;

  private static void sortAsc(String input, String output) {
    long s = System.currentTimeMillis();

    FileLogicImpl fl = new FileLogicImpl(input, output);
    int base = 0;

    for (int n = 0; n < REPEAT_TIME; n++) {
      int[] ary = fl.read(base, DIVISION_RANGE);
      QuickSort.quickSort(ary, 0, ary.length - 1);
      fl.write(ary);
      base += DIVISION_RANGE;
    }

    long e = System.currentTimeMillis();
    System.out.println((e - s) / 1000 + " second");
  }

  private static void checkAsc(String output) {
    long s = System.currentTimeMillis();

    System.out.println(CheckSortAsc.check(output));

    long e = System.currentTimeMillis();
    System.out.println((e - s) / 1000 + " second");
  }

}
