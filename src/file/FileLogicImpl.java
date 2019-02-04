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

  public int[] partitionRead(int base, int division) {
    List<Integer> nums = new ArrayList<>();
    String line;

    try (BufferedReader br = new BufferedReader(new FileReader(new File(input)))) {
      while ((line = br.readLine()) != null) {
        int num = Integer.parseInt(line);
        if (num <= division + base && base < num) nums.add(num);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return toIntArray(nums);
  }

  public void write(int[] nums) {
    // @param true - write continually
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output), true))) {
      for (int num : nums) {
        bw.write(String.valueOf(num));
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
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
    for (int el : list) ary[index++] = el;
    return ary;
  }
}
