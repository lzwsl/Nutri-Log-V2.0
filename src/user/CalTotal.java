package user;

import model.Consumable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CalTotal implements Serializable {
    private Integer calorieTotal;
    private transient Scanner scanner;

    //MODIFIES: this, Arraylist<Integer>
    //EFFECTS: calculates total calories consumed.
    public Integer totalCalories(Consumable f, ArrayList<Consumable> a) {
        a.add(f);
        Integer sum = 0;
        for (Consumable i: a) {
            sum = sum + i.getCalories();
        }
        calorieTotal = sum;
        return sum;
    }

    //EFFECTS: get total calories consumed.
    public Integer getCurrentCalories() {
        return calorieTotal;
    }

    //MODIFIES: this
    //EFFECTS: clears total calorie history if user decides
    public ArrayList<Consumable> clearCurrentCalories(ArrayList<Consumable> a) {
        System.out.println("Would You Like to Clear Current Calories? (yes/no)");
        scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("yes")) {
            a.clear();
            calorieTotal = 0;
            Integer retVal = a.size();
            System.out.println("Calorie History is Cleared, Set To " + retVal + " Calories");
        } else {
            return a;
        }
        return a;
    }


}
