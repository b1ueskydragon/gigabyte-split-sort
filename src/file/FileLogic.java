package file;

import java.io.File;
import java.nio.file.Path;

public interface FileLogic {
  /**
   * Read-in file with split lines
   *
   * @param base      number of times of division
   * @param division  range of number division which partitionRead-in
   * @param inputPath path of original file
   * @return partitionRead-in result (array)
   */
  int[] partitionRead(int base, int division, Path inputPath);

  /**
   * write to file
   *
   * @param ary        result array to be wrote
   * @param outputFile a new file for output
   */
  void write(int[] ary, File outputFile);
}
