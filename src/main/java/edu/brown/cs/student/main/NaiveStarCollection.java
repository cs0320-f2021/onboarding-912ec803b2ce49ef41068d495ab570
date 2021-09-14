package edu.brown.cs.student.main;

import java.util.List;

/**
 * A naive implementation of the {@link StarCollection} interface.
 */
public class NaiveStarCollection implements StarCollection {

  private List<Star> stars;

  public NaiveStarCollection(List<Star> stars) {
    this.stars = stars;
  }

  @Override
  public void setStars(List<Star> stars) {
    this.stars = stars;
  }

  @Override
  public List<Star> getStars() {
    return this.stars;
  }

  @Override
  public Star findStarWithName(String name) {
    for (Star star : stars) {
      if (star.getName().equals(name)) {
        return star;
      }
    }
    return null;
  }

}
