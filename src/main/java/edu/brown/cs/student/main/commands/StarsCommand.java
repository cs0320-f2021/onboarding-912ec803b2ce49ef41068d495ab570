package edu.brown.cs.student.main.commands;

import edu.brown.cs.student.main.Point3D;
import edu.brown.cs.student.main.Star;
import edu.brown.cs.student.main.StarCollection;
import edu.brown.cs.student.main.csv.CSVParser;
import edu.brown.cs.student.main.csv.CSVRecord;
import edu.brown.cs.student.main.repl.REPLCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StarsCommand implements REPLCommand {

  private final StarCollection starCollection;

  private static final int FILENAME_ARGS_INDEX = 1;

  public StarsCommand(StarCollection starCollection) {
    this.starCollection = starCollection;
  }

  @Override
  public Boolean apply(List<String> args) {
    if (args.size() != 2) {
      System.err.println("ERROR: Invalid arguments");
      return false;
    }

    String filename = args.get(FILENAME_ARGS_INDEX);

    File csvFile = new File(filename);
    try {
      CSVParser parser = CSVParser.parse(csvFile, true);
      List<CSVRecord> records = parser.getRecords();

      List<Star> stars = new ArrayList<>();
      for (CSVRecord record : records) {
        int starID = Integer.parseInt(record.get("StarID"));
        String properName = record.get("ProperName");
        double x = Double.parseDouble(record.get("X"));
        double y = Double.parseDouble(record.get("Y"));
        double z = Double.parseDouble(record.get("Z"));

        stars.add(new Star(starID, properName, new Point3D(x, y, z)));
      }

      System.out.println("Read " + stars.size() + " stars from " + filename);
      starCollection.setStars(stars);

    } catch (FileNotFoundException e) {
      System.err.println("ERROR: File not found");
      e.printStackTrace();
    } catch (NumberFormatException e) {
      System.err.println("ERROR: CSV file contained a malformed number");
      e.printStackTrace();
    }

    return null;
  }
}
