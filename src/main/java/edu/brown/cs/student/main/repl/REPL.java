package edu.brown.cs.student.main.repl;

import java.util.HashMap;
import java.util.List;

/**
 * Provides basic read-eval-print-loop functionality. A {@link REPL} instance is responsible for
 * tokenizing input given to it by its associated {@link REPLInputSource}, and then delegates
 * control flow based on a client-defined mapping of command names (the first token in the input
 * stream) to {@link REPLCommand}s.
 */
public class REPL {

  private final REPLInputSource inputSource;
  private final REPLTokenizer tokenizer;
  private final HashMap<String, REPLCommand> commandDelegator;

  /**
   * Constructs a new {@link REPL} instance.
   *
   * @param inputSource      the {@link REPLInputSource} from which unparsed strings are sourced
   * @param tokenizer        the {@link REPLTokenizer} that parses input and generates tokens
   * @param commandDelegator mapping from command names (as {@link String}s) to {@link REPLCommand}s
   */
  public REPL(final REPLInputSource inputSource,
              final REPLTokenizer tokenizer,
              final HashMap<String, REPLCommand> commandDelegator) {
    this.inputSource = inputSource;
    this.tokenizer = tokenizer;
    this.commandDelegator = commandDelegator;
  }

  /**
   * Starts the {@link REPL}.
   * <p>
   * Infinitely loops until {@link REPLInputSource#readLine()} from the associated
   * {@link REPLInputSource} returns null.
   */
  public void startREPL() {
    while (true) {
      final String line = inputSource.readLine();
      if (line == null) {
        break;
      }

      final List<String> arguments = tokenizer.parseLine(line);
      final String command = arguments.get(0);
      if (commandDelegator.containsKey(command)) {
        commandDelegator.get(command).apply(arguments);
      } else {
        System.err.println("ERROR: Command not found");
      }
    }
  }

}
