package user;

import model.Food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CalTotal implements Serializable {
    private Integer calorieTotal;
    private transient Scanner scanner;

    //MODIFIES: this, Arraylist<Integer>
    //EFFECTS: calculates total calories consumed.
    public Integer totalCalories(Food f, ArrayList<Food> a) {
        a.add(f);
        Integer sum = 0;
        for(Food i: a) {
            sum = sum + i.getFoodCalories();
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
    public ArrayList<Food> clearCurrentCalories(ArrayList<Food> a) {
        System.out.println("Would You Like to Clear Current Calories? (yes/no)");
        scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("yes")) {
            a.clear();
            calorieTotal = 0;
            Integer retval = a.size();
            System.out.println("Calorie History is Cleared, Set To "+retval+" Calories");
        }
        else {
            return a;
        }
        return a;
    }
}
