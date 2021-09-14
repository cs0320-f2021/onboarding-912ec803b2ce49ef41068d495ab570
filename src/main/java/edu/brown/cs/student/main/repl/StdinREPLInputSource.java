package edu.brown.cs.student.main.repl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A {@link REPLInputSource} that reads from standard input.
 */
public class StdinREPLInputSource implements REPLInputSource {

  private BufferedReader reader;

  public StdinREPLInputSource() {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  @Override
  public String readLine() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      System.err.println("ERROR: Could not read from stdin");
      return null;
    }
  }

}
