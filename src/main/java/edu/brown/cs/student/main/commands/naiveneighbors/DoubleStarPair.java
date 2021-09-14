package edu.brown.cs.student.main.commands.naiveneighbors;

import edu.brown.cs.student.main.Star;

public class DoubleStarPair {

  private double number;
  private Star star;

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
