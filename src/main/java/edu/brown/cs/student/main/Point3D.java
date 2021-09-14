package edu.brown.cs.student.main;

import java.util.Objects;

/**
 * Represents a three-dimensional point in Euclidean space.
 */
public class Point3D {

  private final double x;
  private final double y;
  private final double z;

  /**
   * Creates a new instance of {@link Point3D}.
   *
   * @param x the x coordinate of the {@link Point3D}
   * @param y the y coordinate of the {@link Point3D}
   * @param z the z coordinate of the {@link Point3D}
   */
  public Point3D(final double x, final double y, final double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Gets the x coordinate of the {@link Point3D}.
   *
   * @return the x coordinate
   */
  public double getX() {
    return x;
  }

  /**
   * Gets the y coordinate of the {@link Point3D}.
   *
   * @return the y coordinate
   */
  public double getY() {
    return y;
  }

  /**
   * Gets the z coordinate of the {@link Point3D}.
   *
   * @return the z coordinate
   */
  public double getZ() {
    return z;
  }

  /**
   * Computes the distance between this {@link Point3D} and the coordinate (otherX, otherY,
   * otherZ).
   *
   * @param otherX the x coordinate of the other point
   * @param otherY the y coordinate of the other point
   * @param otherZ the z coordinate of the other point
   * @return the distance between this {@link Point3D} and (otherX, otherY, otherZ)
   */
  public double distance(final double otherX, final double otherY, final double otherZ) {
    final double x2 = Math.pow(otherX - x, 2);
    final double y2 = Math.pow(otherY - y, 2);
    final double z2 = Math.pow(otherZ - z, 2);
    return Math.sqrt(x2 + y2 + z2);
  }

  /**
   * Computes the distance between this {@link Point3D} and the specified, other
   * {@link Point3D}.
   *
   * @param other the other point
   * @return the distance between this {@link Point3D} and the specified {@link Point3D}
   */
  public double distance(Point3D other) {
    return this.distance(other.getX(), other.getY(), other.getZ());
  }

  @Override
  public String toString() {
    return new StringBuilder().append("(").append(x).append(", ").append(y).append(", ").append(z)
                              .append(")").toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point3D point3D = (Point3D) o;
    return Double.compare(point3D.x, x) == 0
        && Double.compare(point3D.y, y) == 0
        && Double.compare(point3D.z, z) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }

}
