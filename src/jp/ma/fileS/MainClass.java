
package jp.ma.fileS;

public class MainClass {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		String input = "";
		String output = "";
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

			r += 200000000;
			StringBuilder sba = new StringBuilder();
			System.out.println(sba.append(n).append("回目"));
		}

		long end = System.currentTimeMillis();

		StringBuilder sba = new StringBuilder();
		System.out.println(sba.append((end - start) / 1000).append("秒"));
	}

}
