package user;

import model.Food;

import java.io.Serializable;
import java.util.ArrayList;

public class CalTotal implements Serializable {
    private Integer calorietotal;

    //MODIFIES: this, Arraylist<Integer>
    //EFFECTS: calculates total calories consumed.
    public Integer totalCalories(Food f, ArrayList<Food> a) {
        a.add(f);
        Integer sum = 0;
        for(Food i: a) {
            sum = sum + i.getFoodCalories();
        }
        calorietotal = sum;
        return sum;
    }

    //EFFECTS: get total calories consumed.
    public Integer getCurrentCalories() {
        return calorietotal;
    }
}
