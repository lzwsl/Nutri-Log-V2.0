package user;

import java.util.ArrayList;

public class CalTotal {
    private ArrayList<Integer> calHistory;
    private Integer calorietotal;

    //MODIFIES: this, Arraylist<Integer>
    //EFFECTS: calculates total calories consumed.
    public Integer totalCalories(Integer calories, ArrayList<Integer> a) {
//        ArrayList<Integer> calHistory = new ArrayList<Integer>();
        a.add(calories);
        Integer sum = 0;
        for(Integer i: a) {
            sum = sum + i;
        }
        calorietotal = sum;
        return sum;
    }

    //EFFECTS: retreives total calories consumed.
    public Integer retrieveCurrentCalories() {
        return calorietotal;
    }
}
