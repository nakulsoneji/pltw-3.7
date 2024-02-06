
/*
 * Activity 3.7.3
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
// To randomize list easily:
import java.util.Collections;

/**
 * A class to manage the location of horses in a barn.
 */
public class HorseBarn {
  // The stalls or spaces in the barn. Each array element holds a reference to the
  // horse
  // that is currently occupying the space. A null value indicates an empty space.
  private ArrayList<Horse> spaces = new ArrayList<Horse>();

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_BOLD = "\033[0;1m";

  /**
   * Constructor for the HorseBarn class. Loads data from the horsedata.txt file
   * and populates the ArrayList spaces. If a blank line occurs in the data file,
   * the array element is assigned a value of null to indicate the absense of a
   * horse.
   */
  public HorseBarn() {
    // a try is like an if statement, "throwing" an error if the body of the try
    // fails
    try {
      Scanner sc = new Scanner(new File("horsedata.txt"));
      // The Scanner method hasNextLine returns true if there is
      // another line of input
      while (sc.hasNextLine()) {
        // String method trim removes whitepsace from the beginning
        // and end of strings
        String temp = sc.nextLine().trim();
        if (temp.equals("")) {
          // no horse in this stall, add a null entry
          spaces.add(null);
        } else {
          // String method split splits this string based on the
          // specified token and returns an array of individual substrings
          String[] tokens = temp.split(",");
          String name = tokens[0];
          int weight = Integer.parseInt(tokens[1]);

          // add the horse to the array list
          spaces.add(new Horse(name, weight));
        }
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing horsedata.txt" + e);
    }
  }

  /**
   * Returns the current list of spaces in the barn. If a space does not
   * have a horse in it, the element will be null.
   * 
   * @return the ArrayList of spaces
   */
  public ArrayList<Horse> getSpaces() {
    return spaces;
  }

  private ArrayList<Horse> randomizeList() {
    ArrayList<Horse> temp = new ArrayList<Horse>();
    for (Horse h : spaces) {
      if (h != null) {
        temp.add(h);
      }
    }
    Collections.shuffle(temp);
    return temp;
  }

  public ArrayList<Horse> makePairs() {
    ArrayList<Horse> temp = randomizeList();
    ArrayList<Horse> pairs = new ArrayList<Horse>();
    for (int i = 0; i < temp.size(); i += 2) {
      if (i + 1 < temp.size()) {
        pairs.add(temp.get(i));
        pairs.add(temp.get(i + 1));
      } else {
        pairs.add(temp.get(i));
        System.out.println(ANSI_RED + "One horse is not paired with another horse: " + ANSI_RESET + ANSI_BOLD + ANSI_YELLOW + temp.get(i) + ANSI_RESET);
      }
    }
    return pairs;
  }
}
