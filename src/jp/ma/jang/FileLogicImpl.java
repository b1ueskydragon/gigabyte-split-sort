package jp.ma.jang;

/**
 * 読んだものをどう処理して, どこに何を書き出すか.
 */
public interface FileLogicImpl {

  /**
   * ファイルを分割して読み込む
   *
   * @param branch   読み取りの分割の分岐点
   * @param division 数字データの分割間隔
   * @return         読み取ったデータの配列
   */
  int[] read(int branch, int division);

  /**
   * データをファイルに書き出す
   *
   * @param ary 書き出し対象の配列
   */
  void write(int[] ary);
}
