package jp.ma.tester;

import jp.ma.jang.FileLogic;

import static jp.ma.jang.FilePath.RESULT_PATH;
import static jp.ma.jang.Utility.*;

/**
 * a[i] より a[i+1] の方が大きい場合のみ, 正解を一個ずつ進めていくアルゴリズム
 */
public class SortTester { // TODO 改良する

  private static void check(int[] ary) {
    int index = 0;
    while (index < ary.length - 1) {
      if (ary[index] <= ary[index + 1]) {
        index++;
      } else {
        System.out.println("index " + index + " and " + "index " + (index + 1) + " are not sorted.");
        break;
      }
    }
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    int r = 0;

    for (int n = 1; n <= 10; n++) {
      int[] ary = new FileLogic(RESULT_PATH, null).reader(r, DIVISION_RANGE); // TODO わけない
      check(ary);

      r += DIVISION_RANGE;
    }

    long end = System.currentTimeMillis();
    System.out.println((end - start) / 1000 + "秒");
  }
}