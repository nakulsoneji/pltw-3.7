
/*
 * Activity 3.7.3
 */
import java.util.ArrayList;

public class HorseBarnRunner {
  public static void main(String[] args) {
    HorseBarn barn = new HorseBarn();
    ArrayList<Horse> barnSpaces = barn.getSpaces();

    // Average Weight:
    double avg = 0;
    for (int i = 0; i < barnSpaces.size(); i++) {
      avg += barnSpaces.get(i).getWeight();
    }
    avg = avg/barnSpaces.size();
    System.out.println("Average weight: " + avg);

    // Display Horses weighing more than average
    ArrayList<Horse> moreThanAvg = new ArrayList<>();
    for(int i = 0; i < barnSpaces.size(); i++){
      if(barnSpaces.get(i).getWeight() > avg){
        moreThanAvg.add(barnSpaces.get(i));
      }
    }
    System.out.println("Horses weighing more than the average: ");
    for(int i = 0; i < moreThanAvg.size(); i++){
      System.out.print("    " + moreThanAvg.get(i).getName());
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

    System.out.println(barnSpaces.get(minIndex).getName() + " is our minimum weighted horse, weighting " + min +" pounds.");
    System.out.println(barnSpaces.get(maxIndex).getName() + " is our maximum weighted horse, weighting " + max + " pounds.");
}}
