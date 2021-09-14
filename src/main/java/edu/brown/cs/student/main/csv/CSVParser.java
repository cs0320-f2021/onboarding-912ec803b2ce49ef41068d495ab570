package edu.brown.cs.student.main.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public final class CSVParser {

  private Scanner scanner;
  private Boolean fileHasHeaderRow;

  /**
   * Constructor for {@link CSVParser}.
   *
   * This constructor is private; use the {@link CSVParser#parse} method instead to construct
   * instances.
   * @param scanner
   * @param fileHasHeaderRow
   */
  private CSVParser(Scanner scanner, boolean fileHasHeaderRow) {
    this.scanner = scanner;
    this.fileHasHeaderRow = fileHasHeaderRow;
  }

  /**
   * Constructs a {@link CSVParser} instance for the given {@link File} file.
   * @param file the input file
   * @param fileHasHeaderRow if the file has a header row, set to true; otherwise, false
   * @return
   * @throws FileNotFoundException
   */
  public static CSVParser parse(File file, boolean fileHasHeaderRow)
      throws FileNotFoundException {
    Scanner scanner = new Scanner(file);
    return new CSVParser(scanner, fileHasHeaderRow);
  }

  /**
   * Returns a List of {@link CSVRecord}s corresponding to each row of the CSV.
   * @return
   */
  public List<CSVRecord> getRecords() {
    boolean headersFound = false;

    HashMap<String, Integer> headersToIndices = new HashMap<>();
    List<CSVRecord> result = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String nextLine = scanner.nextLine();
      List<String> fields = Arrays.asList(nextLine.split(","));

      // The first row may be a row consisting of just headers, which the client code may
      // have specified to ignore via `fileHasHeaderRow`, so we check that here:
      if (fileHasHeaderRow && !headersFound) {
        System.out.println(fields);
        for (int index = 0; index < fields.size(); index++) {
          headersToIndices.put(fields.get(index), index);
        }
        headersFound = true;
      } else {
        result.add(new CSVRecord(headersToIndices, fields));
      }
    }

    return result;
  }

}
