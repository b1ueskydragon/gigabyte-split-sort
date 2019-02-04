package file;

public interface FileLogic {
  /**
   * Read-in file with split lines
   *
   * @param base     number of times of division
   * @param division range of number division which partitionRead-in
   * @return partitionRead-in result (array)
   */
  int[] partitionRead(int base, int division);

  /**
   * write to file
   *
   * @param ary result array to be wrote
   */
  void write(int[] ary);
}
