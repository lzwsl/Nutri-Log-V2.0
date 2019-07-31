package ui;

import model.Consumable;

import java.io.Serializable;
import java.util.ArrayList;

public class AllItems implements Serializable {

    //EFFECTS: prints out every item on ArrayList
    public void allItems(ArrayList<Consumable> a) {
        for (Consumable f: a) {
            System.out.println(f.getName() + " - " + f.getCalories() + " calories");
        }
    }
}
