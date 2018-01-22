package jp.ma.jang;

/**
 * 読んだものをどう処理して, どこに何を書き出すか.
 */
public interface FileLogicImpl {

  /**
   * ファイルを分割して読み込む
   *
   * @param r  読み取りの分割のスタート地点
   * @param d  数字データの分割間隔
   * @return   読み取ったデータの配列
   */
  int[] reader(int r, int d);

  /**
   * データをファイルに書き出す
   *
   * @param ary 書き出し対象の配列
   */
  void writer(int[] ary);
}
