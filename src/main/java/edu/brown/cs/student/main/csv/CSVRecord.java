package edu.brown.cs.student.main.csv;

import java.util.HashMap;
import java.util.List;

public class CSVRecord {

  private HashMap<String, Integer> headersToIndices;
  private List<String> values;

  /**
   * Constructs a {@link CSVRecord} corresponding to a row of a CSV.
   * @param headersToIndices a mapping from string headers to indices of values
   * @param values the values in the row of the CSV
   */
  public CSVRecord(HashMap<String, Integer> headersToIndices, List<String> values) {
    this.headersToIndices = headersToIndices;
    this.values = values;
  }

  /**
   * Returns the CSV row's value at the input index.
   * @param index a index
   * @return the value at the input index, or null if out of bounds
   */
  public String get(Integer index) {
    if (index >= values.size()) {
      return null;
    }
    return values.get(index);
  }

  /**
   * Returns the CSV row's value corresponding to the column named header.
   * @param header a column name
   * @return the value associated with the given column name, or null if column doesn't exist
   */
  public String get(String header) {
    Integer index = headersToIndices.get(header);
    if (index == null) {
      return null;
    }
    return this.get(index);
  }

}
