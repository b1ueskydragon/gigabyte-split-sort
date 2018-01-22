package jp.ma.tester;

import jp.ma.jang.FileLogic;

import static jp.ma.jang.FilePath.RESULT_PATH;

public class SortTester {

  //a[i]よりa[i+1]の方が大きかったら正解を一個ずつ進めていく
  private final static Integer DIVISION_RANGE = 200_000_000;

  private static String tester(int[] ary, int index) {
    String result = "false";

    while (index < ary.length - 1) {
      if (ary[index] <= ary[index + 1]) {
        result = "true";
        index++;
      } else {
        result = "" + index + "番と" + (index + 1) + "番要素のところがfalse";
        break; // 修正ロジック? 優しすぎる?(笑)
      }
    }
    return result;
  }

  public static void main(String[] args) {

    long start = System.currentTimeMillis();
    int r = 0;

    for (int n = 1; n <= 10; n++) {
      // 読み込みロジックはFileLogicクラスから
      int[] ary = new FileLogic(RESULT_PATH).reader(r, DIVISION_RANGE); // TODO わけない
      String result = tester(ary, 0);
      System.out.println(result);
      r += DIVISION_RANGE;
    }

    long end = System.currentTimeMillis();
    System.out.println((end - start) / 1000 + "秒");
  }
}