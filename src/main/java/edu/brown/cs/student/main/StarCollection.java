package edu.brown.cs.student.main;

import java.util.List;

/**
 * Represents a collection of {@link Star}s.
 *
 * We define this as an interface since we expect to have more efficient {@link Star}
 * representations in the future.
 */
public interface StarCollection {

  /**
   * Sets the {@link StarCollection} to contain the given stars.
   * @param stars the {@link Star}s to set the collection of {@link Star}s to.
   */
  void setStars(List<Star> stars);

  /**
   * Returns all stars in the {@link StarCollection}.
   * @return a list of stars in the collection
   */
  List<Star> getStars();

  /**
   * Returns the star with the given name.
   * @param name the name of a star
   * @return the {@link Star} with the given name, or null if no such star exists
   */
  Star findStarWithName(String name);

}
