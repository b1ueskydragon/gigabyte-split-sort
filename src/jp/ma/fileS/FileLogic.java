
package jp.ma.fileS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLogic {
	/*
	 * 読んだものをどう処理して、どこに何を書き出すか
	 */
	private String input;
	private String output;

	public FileLogic(String input, String output) {
		this.input = input;
		this.output = output;
	}

	int[] reader(int r) {

		BufferedReader br = null;
		List<Integer> list = new ArrayList<>();
		String ln = null;

		try {
			br = new BufferedReader(new FileReader(new File(this.input)));

			while ((ln = br.readLine()) != null) {
				int line = Integer.parseInt(ln);
				if (line <= 200000000 + r && r < line)
					list.add(line);
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		/*
		 * List<Integer>→int[]
		 */
		int[] ary = new int[list.size()];
		int index = 0;
		for (Integer i : list) {
			ary[index] = i;
			index++;
		}

		return ary;
	}

	void writer(int[] ary) {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(new File(this.output), true));
			// 引き続けて書き出すパラメータ

			for (int s : ary) {
				bw.write(Integer.toString(s) + System.getProperty("line.separator"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
