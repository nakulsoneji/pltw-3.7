
/*
 * Activity 3.7.3
 */
import java.util.ArrayList;

public class HorseBarnRunner {
  public static void main(String[] args) {
    HorseBarn barn = new HorseBarn();
    ArrayList<Horse> barnSpaces = barn.getSpaces();
    int numSpaces = barnSpaces.size();
    for (int i = 0; i < numSpaces; i++) {
      Horse h = barnSpaces.get(i);
      if (h.getName().equals("Patches"))
        System.out.println("Bye bye " + barnSpaces.remove(i));
    }

  }
}
