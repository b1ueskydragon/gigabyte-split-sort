
package jp.ma.jang;

public class QuickSortLogic {
  /**
   * 配列の要素を相互交換する
   *
   * @param ary  配列
   * @param inxA 要素のインデックス A
   * @param inxB 要素のインデックス B
   */
  private void swap(int[] ary, int inxA, int inxB) {
    int box = ary[inxA];
    ary[inxA] = ary[inxB];
    ary[inxB] = box;
  }

  /**
   * 再帰的にクイックソートを行う
   *
   * @param ary   配列
   * @param left  分割する区間の先頭要素の index
   * @param right 分割する区間の末尾要素の index
   * @return      ソート済みの配列
   */
  public int[] quickSort(int[] ary, int left, int right) {
    int cl = left;
    int cr = right;
    int center = ary[(cl + cr) / 2];

    while (true) {
      while (ary[cl] < center) cl++;
      while (ary[cr] > center) cr--;
      if (cl <= cr) swap(ary, cl++, cr--);

      // カーソルの左右の向きが変わったら抜け出す
      if (cl > cr) break;
    }

    // 左半分
    if (left < cr) quickSort(ary, left, cr);
    // 左半分終了後, 右半分
    if (cl < right) quickSort(ary, cl, right);

    return ary;
  }
}
