package edu.brown.cs.student.main.commands.naiveneighbors;

import edu.brown.cs.student.main.Star;

/**
 * Small utility class used to pair together a {@link Double} and a {@link Star} to make it easier
 * to use a {@link java.util.Comparator} to order {@link Star}s by their distances (represented by
 * a {@link Double}).
 */
public class DoubleStarPair {

  private final double number;
  private final Star star;

  public DoubleStarPair(double number, Star star) {
    this.number = number;
    this.star = star;
  }

  public double getNumber() {
    return this.number;
  }

  public Star getStar() {
    return this.star;
  }

}
