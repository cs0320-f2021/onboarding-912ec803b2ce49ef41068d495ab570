package edu.brown.cs.student.main.repl;

import java.util.List;
import java.util.function.Function;

/**
 * Interface representing a {@link REPL} command.
 *
 * The interface is effectively just a type alias for Function<List<String>, Boolean>, where
 * the List<String> argument represents the {@link REPL} tokens passed to the command, and the
 * Boolean return value is true if the command succeeded, or false if the command failed.
 */
public interface REPLCommand extends Function<List<String>, Boolean> { }
