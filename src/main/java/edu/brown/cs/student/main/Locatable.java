package edu.brown.cs.student.main;

/**
 * A {@link Locatable} is an interface designed to allow for polymorphism on methods that operate
 * on objects that have an instance of {@link Point3D} but the associated object cannot be fully
 * separated from the {@link Point3D}.
 * <p>
 * For instance, {@link Star}s have locations represented by {@link Point3D}s, and we often need
 * to order a collection of {@link Star}s relative to their {@link Point3D}s. However, we cannot
 * simply detach the {@link Point3D} from the {@link Star} (and just order the {@link Point3D}s,
 * since after the ordering operation we still need all of the associated {@link Star} data.
 */
public interface Locatable {

  /**
   * Returns the location of this {@link Locatable} object.
   *
   * @return a {@link Point3D} representing the location of this object
   */
  Point3D getPoint();

}
