package edu.brown.cs.student.main.commands;

import edu.brown.cs.student.main.Point3D;
import edu.brown.cs.student.main.Star;
import edu.brown.cs.student.main.StarCollection;
import edu.brown.cs.student.main.commands.naiveneighbors.DoubleStarPair;
import edu.brown.cs.student.main.repl.REPLCommand;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NaiveNeighborsCommand implements REPLCommand {

  private StarCollection starCollection;

  public NaiveNeighborsCommand(StarCollection starCollection) {
    this.starCollection = starCollection;
  }

  @Override
  public Boolean apply(List<String> args) {
    try {
      int k = Integer.parseInt(args.get(1));
      Point3D point;
      if (args.size() == 3) {
        String starName = args.get(2);
        Star star = starCollection.findStarWithName(starName);
        if (star == null) {
          System.err.println("ERROR: Star with name " + starName + " does not exist");
          return null;
        }
        point = star.getPoint();
      } else if (args.size() == 5) {
        double x = Double.parseDouble(args.get(2));
        double y = Double.parseDouble(args.get(3));
        double z = Double.parseDouble(args.get(4));
        point = new Point3D(x, y, z);
      } else {
        System.err.println("ERROR: Invalid arguments");
        return false;
      }

      List<DoubleStarPair> distances = new LinkedList<>();
      for (Star star : starCollection.getStars()) {
        double distance = star.getPoint().distance(point);
        distances.add(new DoubleStarPair(distance, star));
      }
      distances.sort(Comparator.comparingDouble(DoubleStarPair::getNumber));

      List<DoubleStarPair> nearestPairs = distances.stream()
                                                   .limit(k)
                                                   .collect(Collectors.toList());
      for (DoubleStarPair pair : nearestPairs) {
        System.out.println(pair.getStar().getId());
      }
      return true;
    } catch (NumberFormatException e) {
      System.err.println("ERROR: Got non-number when a number was expected");
      return false;
    }
  }
}
