package jp.ma.fileS;

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

		while (k <= max && ary[min] >= ary[k]) {

			if (ary[min] < ary[k]) {
				if (ary[k] > pivot)
					ret = k;
				else
					ret = min;
			} else {
				k++;
			}
		}

		return ret = k;
	}

	/*
	 * Tester
	 */
	public static void main(String[] args) {

		//int[] ary = { 3, 2, 4, 5, 6 };
		int[] ary2 = { 9, 4, 2, 54, 75, 67, 8, 98 };

		System.out.println(new FindPivot().findLogic(ary2, 0, ary2.length - 1));

		int result = ary2[new FindPivot().findLogic(ary2, 0, ary2.length - 1)];
		System.out.println(result);
		System.out.println("------");
		for (int a : new QuickSortLogic().quickSort(ary2, 0, ary2.length - 1)) {

			System.out.println(a);

		}

	}

}
