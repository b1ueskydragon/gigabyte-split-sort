package jp.ma.jang;

/*
 * (本)Fundamental Information Technology Engineer Examination PM/Algorithm
 *  page 253~254を自分なりにjava化
 */
public class FindPivot {
	/**
	 *
	 * @param ary
	 *            対象の配列
	 * @param min
	 *            先頭要素のインデックス
	 * @param max
	 *            末尾要素のインデックス
	 * @param ret
	 *            基準値が格納されているインデックス。ary[min], ary[min+1] ... , ary[max]の場合は -1。
	 *
	 * @return 中央値のインデックス
	 */
	int findLogic(int[] ary, int min, int max) {

		int pivot = ary[min];
		int k = min + 1;
		int ret = -1;
		// スタート

		// 全要素が同じな場合以外の条件を定義すればOKかも
		while (k <= max && ary[k] <= ary[min]) {

			if (ary[min] < ary[k]) {
				if (pivot < ary[k])
					ret = k;
				else
					ret = min;

			} else {
					k++;
			}

		}

		return ret;
		// return ret = k;

	}

	/*
	 * Tester
	 */
	public static void main(String[] args) {

		// int[] ary = { 3, 2, 4, 5, 6 };
		int[] ary2 = { 9, 8, 7, 6, 5, 1, 3 };

		int result_inx = new FindPivot().findLogic(ary2, 0, ary2.length - 1);

		System.out.println(result_inx);

		int result = 0;
		if (result_inx == -1) {
			result = -1;
		} else {
			result = ary2[result_inx];
		}

		System.out.println(result);

		System.out.println("------");

		for (int a : new QuickSortLogic().quickSort(ary2, 0, ary2.length - 1)) {

			System.out.println(a);

		}

	}

}
