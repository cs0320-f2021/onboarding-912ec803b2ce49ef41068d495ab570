package edu.brown.cs.student.main.repl;

/**
 * Interface representing a source of String inputs to a {@link REPL}.
 */
public interface REPLInputSource {

  /**
   * When called by a {@link REPL}, returns the next line of input to the {@link REPL}.
   * @return the next line of input
   */
  String readLine();

}
