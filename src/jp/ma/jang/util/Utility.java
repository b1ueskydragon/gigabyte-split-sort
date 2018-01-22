package jp.ma.jang.util;

import java.util.List;

public class Utility {

  /**
   * リストから配列へ変換する
   *
   * @param list リスト
   * @return 変換後の配列
   */
  public static int[] ConvertIntegerListToAry(List<Integer> list) {
    int[] ary = new int[list.size()];
    int index = 0;

    for (Integer i : list) {
      ary[index] = i;
      index++;
    }
    return ary;
  }

  /**
   * 読み取りの分割間隔
   */
  public final static Integer DIVISION_RANGE = 200_000_000;

  /**
   * 読み取りの分割間隔
   */
  public final static Integer SPLIT_LINE = 10;
}
