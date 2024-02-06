
/*
 * Activity 3.7.3
 */
import java.util.ArrayList;

public class HorseBarnRunner {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_BOLD = "\033[0;1m";
  public static void main(String[] args) {
    HorseBarn barn = new HorseBarn();
    ArrayList<Horse> barnSpaces = barn.getSpaces();

    // Task 3a, b, c

    for (int i = 0; i < barnSpaces.size(); i++) {
      if (barnSpaces.get(i).getName().equals("Duke")) {
        barnSpaces.set(i, new Horse("Princess", 1445));
      }

      if (barnSpaces.get(i).getName().equals("Silver")) {
        barnSpaces.add(i + 1, new Horse("Chief", 1505));
      }

      if (barnSpaces.get(i).getName().equals("Buddy")) {
        barnSpaces.add(i, new Horse("Gypsy", 1335));
        barnSpaces.add(i + 2, new Horse("Magic", 1425));
      }

      break;
    }

    // Average Weight:
    double avg = 0;
    for (int i = 0; i < barnSpaces.size(); i++) {
      avg += barnSpaces.get(i).getWeight();
    }
    avg = avg/barnSpaces.size();
    System.out.println(ANSI_BOLD + ANSI_BLUE + "Average weight: " + avg + ANSI_RESET);

    // Display Horses weighing more than average
    ArrayList<Horse> moreThanAvg = new ArrayList<>();
    for(int i = 0; i < barnSpaces.size(); i++){
      if(barnSpaces.get(i).getWeight() > avg){
        moreThanAvg.add(barnSpaces.get(i));
      }
    }
    System.out.println(ANSI_BOLD + ANSI_GREEN + "\nHorses weighing more than the average:" + ANSI_RESET);

    for(int i = 0; i < moreThanAvg.size(); i++){
      System.out.print(ANSI_BOLD + ANSI_BLUE + "    " + moreThanAvg.get(i).getName() + ANSI_RESET);
    }
    System.out.println();

    //Display Lightest horse and Heaviest Horse
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int minIndex = 0;
    int maxIndex = 0;
    for(int i = 0; i < barnSpaces.size(); i++){
      int weight = barnSpaces.get(i).getWeight();
      if(weight > max){
        max = weight;
        maxIndex = i;
      }if(weight < min){
        min = weight;
        minIndex = i;
      }
    }

    

    System.out.println(ANSI_BOLD + ANSI_GREEN + "\nBiggest/smallest horses:" + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + barnSpaces.get(minIndex).getName() + ANSI_RESET + ANSI_YELLOW + " is our minimum weighted horse, weighting " + min +" pounds." + ANSI_RESET);
    System.out.println(ANSI_BOLD + ANSI_BLUE + barnSpaces.get(maxIndex).getName() + ANSI_RESET + ANSI_YELLOW + " is our maximum weighted horse, weighting " + min +" pounds." + ANSI_RESET);

    System.out.println(ANSI_BOLD + ANSI_GREEN + "\nAdded and deleted:" + ANSI_RESET);
    for (Horse horse : barnSpaces) {
      System.out.println(ANSI_BOLD + ANSI_BLUE + horse.getName() + ": " + ANSI_RESET + ANSI_YELLOW + horse.getWeight() + " pounds" + ANSI_RESET);
    }


    ArrayList<ArrayList<Horse>> pairs = barn.makePairs();

    System.out.println(ANSI_BOLD + ANSI_GREEN + "\nPairs of horses:" + ANSI_RESET);
    for (int i = 0; i < pairs.size(); i++) {
      System.out.print(ANSI_BOLD + ANSI_BLUE + "Pair " + (i + 1) + ": " + ANSI_RESET);
      System.out.println(ANSI_YELLOW + pairs.get(i).get(0).getName() + " and " + pairs.get(i).get(1).getName() + ANSI_RESET);
    }
  }
}