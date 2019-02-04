package deprecated;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * a[i] より a[i+1] の方が大きい場合のみ, 一個ずつ進めていくアルゴリズム
 */
public class SortChecker { // TODO 続けて改良する

  /**
   * ソートされていないインデックスがある場合, 教示後終了する
   *
   * @param ary 検査する配列
   */
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

  /**
   * 走査しながら gigaSortAsc.check する. 未整列の要素が発見次第, 終了する
   */
  private static boolean checkWhileRead() {
    String res = "INPUT RESULT FILE PATH";
    BufferedReader br = null;
    List<Integer> buff = new ArrayList<>();
    int tmp;
    String ln;

    try {
      br = new BufferedReader(new FileReader(new File(res)));

      while ((ln = br.readLine()) != null) { // TODO そもそもここを改良
        int line = Integer.parseInt(ln);
        buff.add(line);

        if (buff.size() > 1) {
          if (buff.get(0) > buff.get(1)) {
            System.out.println("Not sorted.");
            return false;
          } else {
            tmp = buff.get(1);
            buff = new ArrayList<>();
            buff.add(tmp);
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)
          br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return true;
  }


  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    if (checkWhileRead()) System.out.println("All Green.");

    long end = System.currentTimeMillis();
    System.out.println((end - start) / 1000 + " second");
  }
}