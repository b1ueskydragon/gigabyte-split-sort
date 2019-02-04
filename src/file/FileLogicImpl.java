package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLogicImpl implements FileLogic {
  private String input;
  private String output;

  public FileLogicImpl(String input, String output) {
    this.input = input;
    this.output = output;
  }

  public int[] read(int base, int division) {
    BufferedReader br = null;
    List<Integer> list = new ArrayList<>();

    String ln;

    try {
      br = new BufferedReader(new FileReader(new File(this.input)));

      while ((ln = br.readLine()) != null) {
        int line = Integer.parseInt(ln);
        if (line <= division + base && base < line) list.add(line);
      }

    } catch (NumberFormatException | IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null) br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return toIntArray(list);
  }

  /**
   * Integer list to int array
   *
   * @param list given list
   * @return array
   */
  private int[] toIntArray(List<Integer> list) {
    int[] ary = new int[list.size()];
    int index = 0;

    for (int i : list) {
      ary[index] = i;
      index++;
    }
    return ary;
  }

  public void write(int[] ary) {
    BufferedWriter bw = null;

    try {
      // @param true - write continually
      bw = new BufferedWriter(new FileWriter(new File(this.output), true));
      for (int s : ary) {
        bw.write(Integer.toString(s) + System.getProperty("line.separator"));
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bw != null) bw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
