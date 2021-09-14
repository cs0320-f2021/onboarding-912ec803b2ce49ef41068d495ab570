package edu.brown.cs.student.main.repl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class REPLTokenizer {

  public REPLTokenizer() { }

  /**
   * Tokenizes the given {@link String} on its spaces while respecting quotation marks.
   * @param line a line of input from a {@link REPL}
   * @return a list of Strings of all tokens from the input line
   */
  public List<String> parseLine(String line) {
    List<String> tokens = Arrays.asList(line.split(" "));
    List<String> result = new ArrayList<>();
    StringBuilder dummyToken = null;

    for (String token : tokens) {
      if (token.isEmpty()) {
        continue;
      }

      char firstChar = token.charAt(0);
      char lastChar = token.charAt(token.length() - 1);

      if (firstChar == '"' && lastChar == '"') {
        result.add(token.substring(1, token.length() - 1));
      } else if (firstChar == '"') {
        dummyToken = new StringBuilder(token.substring(1));
      } else if (lastChar == '"') {
        dummyToken.append(" ").append(token.substring(0, token.length() - 1));
        result.add(dummyToken.toString());
        dummyToken = null;
      } else {
        if (dummyToken == null) {
          result.add(token);
        } else {
          dummyToken.append(" ").append(token);
        }
      }
    }
    return result;
  }

}
