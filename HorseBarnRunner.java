
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
    for(int i = 0; i < barnSpaces.size(); i++){
      if(barnSpaces.get(i).getWeight() > avg){
        System.out.println("Horse: " + barnSpaces.get(i).getName() + ". Weight: " + barnSpaces.get(i).getWeight());
      }
    }

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

    System.out.println(barn.makePairs());
}}
