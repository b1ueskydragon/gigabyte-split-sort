
package jp.ma.fileS;

import static jp.ma.fileS.FilePath.*;

public class MainClass {

	private final static Integer DIVISION_RANGE = 200_000_000;

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		String input;
		String output;

		if (System.getProperty("user.dir").contains(MY_PC)) {
			input = TARGET_PATH;
			output = RESULT_PATH;
		} else {
			input = TARGET_PATH_;
			output = RESULT_PATH_;
		}

		FileLogic fl = new FileLogic(input, output);

		QuickSortLogic qs = new QuickSortLogic();

		/*
		 * 10回繰り返し
		 */
		int r = 0; // 基準値
		// nは回数
		for (int n = 1; n <= 10; n++) {
			// System.out.println(r);
			int[] ary = fl.reader(r);
			qs.quickSort(ary, 0, ary.length - 1);
			fl.writer(ary);
			ary = null;

			r += DIVISION_RANGE;
			System.out.println(n + "回目");
		}

		long end = System.currentTimeMillis();

		StringBuilder sba = new StringBuilder();
		System.out.println(sba.append((end - start) / 1000).append("秒"));
	}
}
