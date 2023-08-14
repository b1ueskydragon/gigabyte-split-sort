package sort;

public class QuickSort {
  /**
   * QuickSort recursively.
   * mutable (original array could be modified).
   *
   * @param ary   given array
   * @param left  head index of split division
   * @param right last index of split division
   */
  public static void quickSort(int[] ary, int left, int right) {
    int cl = left;
    int cr = right;
    int pivot = cl + (cr - cl) / 2;
    int center = ary[pivot];

    // break a loop if cursor crossed
    while (cl <= cr) {
      while (ary[cl] < center) cl++;
      while (ary[cr] > center) cr--;

      if (cl <= cr) swap(ary, cl++, cr--);
    }

    // left side half
    if (left < cr) quickSort(ary, left, cr);
    // after sort left side, right side half
    if (cl < right) quickSort(ary, cl, right);
  }

  /**
   * swap two elements
   *
   * @param ary given array
   * @param x   index1
   * @param y   index2
   */
  private static void swap(int[] ary, int x, int y) {
    int tmp = ary[x];
    ary[x] = ary[y];
    ary[y] = tmp;
  }
}
