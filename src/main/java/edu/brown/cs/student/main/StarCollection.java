package edu.brown.cs.student.main;

import java.util.List;

public interface StarCollection {

  void setStars(List<Star> stars);
  List<Star> getStars();
  Star findStarWithName(String name);

}
