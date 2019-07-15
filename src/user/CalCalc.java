package user;


import model.Food;

import java.io.Serializable;
import java.util.ArrayList;

public class CalCalc implements Serializable {

    //MODIFIES: this, CalTotal, SetCalQuota, ArrayList<Integer>
    //EFFECTS: takes in total calories and compares to the calorie quota set by the user,
    //         if the total calories is less or more, will output different responses.
    public void ableToEat(Food f, CalTotal c, SetCalQuota s, ArrayList<Food> a) {
        Integer totalCal = c.totalCalories(f, a);
        if (totalCal <= s.getCalorieQuota()) {
            System.out.println("You are within your caloric quota");
            System.out.println("Your total calorie intake is: " + totalCal + " calories");
        } else {
            System.out.println("You have reached/exceeded your caloric quota");

        }
    }
}
