
package jp.ma.jang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jp.ma.jang.Utility.*;

public class FileLogic implements FileLogicImpl {

  private String input;
  private String output;

  public FileLogic(String input, String output) {
    this.input = input;
    this.output = output;
  }

  public int[] reader(int r, int d) {
    BufferedReader br = null;
    List<Integer> list = new ArrayList<>();

    String ln;

    try {
      br = new BufferedReader(new FileReader(new File(this.input)));

      while ((ln = br.readLine()) != null) {
        int line = Integer.parseInt(ln);
        if (line <= d + r && r < line)
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

    return ConvertIntegerListToAry(list);
  }

  public void writer(int[] ary) {
    BufferedWriter bw = null;

    try {
      bw = new BufferedWriter(new FileWriter(new File(this.output), true)); // 続けて書き出す

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
