package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileLogicImpl implements FileLogic {

  public int[] partitionRead(int base, int division, Path inputPath) {
    List<Integer> nums = new ArrayList<>();
    String line;

    try (BufferedReader br = Files.newBufferedReader(inputPath)) {
      while ((line = br.readLine()) != null) {
        int num = Integer.parseInt(line);
        if (num <= division + base && base < num) nums.add(num);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return nums.stream().mapToInt(n -> n).toArray();
  }

  public void write(int[] nums, File outputFile) {
    // @param true - write continually
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
      for (int num : nums) {
        bw.write(String.valueOf(num));
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
