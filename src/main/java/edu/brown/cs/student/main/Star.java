package edu.brown.cs.student.main;

import java.util.Objects;

/**
 * Represents a star and all of its associated data.
 */
public class Star implements Locatable {

  private final Integer id;
  private final String name;
  private final Point3D point;

  /**
   * Creates a new instance of a {@link Star}.
   *
   * @param id    the ID of the {@link Star}
   * @param name  the name of the {@link Star}
   * @param point the {@link Point3D} representing the location of the {@link Star}
   */
  public Star(final Integer id, final String name, final Point3D point) {
    this.id = id;
    this.name = name;
    this.point = point;
  }

  /**
   * Gets the ID of the {@link Star}.
   *
   * @return the ID of the {@link Star}
   */
  public Integer getId() {
    return id;
  }

  /**
   * Gets the name of the {@link Star}.
   *
   * @return the name of the {@link Star}
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the {@link Point3D} of where the {@link Star} is located in space.
   *
   * @return the {@link Point3D} of the {@link Star}
   */
  public Point3D getPoint() {
    return point;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Star star = (Star) o;
    return id.equals(star.id) && name.equals(star.name) && point.equals(star.point);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, point);
  }

}
