package user;

import model.Food;

import java.beans.Transient;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class CalTotal implements Transient {
    private ArrayList<Integer> calHistory;
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

    @Override
    public boolean value() {
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
