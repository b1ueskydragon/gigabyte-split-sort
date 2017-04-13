package jp.ma.fileS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortTester {
	/*
	 * a[i]よりa[i+1]の方が大きかったら正解 を一個ずつ進めていく
	 */
	String tester(int[] ary, int index) {
		String result = "false";

		while (index < ary.length - 1) {
			if (ary[index] <= ary[index + 1]) {
				result = "true";
				index++;
			} else {
				StringBuilder sb = new StringBuilder();
				result = (sb.append(index).append("番と").append(index + 1).append("番要素のところがfalse")).toString();
				break; // 修正ロジック? 優しすぎる?(笑)
			}
		}

		return result;
	}

	/*
	 * 読み込みロジック
	 */
	int[] reader(String path, int r) {

		BufferedReader br = null;
		List<Integer> list = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader(new File(path)));
			String ln = null;
			try {
				while ((ln = br.readLine()) != null) {
					int line = Integer.parseInt(ln);
					if (line <= 200000000 + r && r < line)
						list.add(line);
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int[] ary = new int[list.size()];
		int index = 0;
		for (int s : list) {
			ary[index] = s;
			index++;
		}

		return ary;
	}

	/*
	 * Tester
	 */
	public static void main(String[] args) {

		// int[] ary = { 1, 2, 3, 2, 5 };

		SortTester ster = new SortTester();
		int r = 0;

		for (int n = 1; n <= 10; n++) {

			int[] ary = ster.reader("", r);
			String result = ster.tester(ary, 0);
			System.out.println(result);
			r += 200000000;
		}

	}

}
