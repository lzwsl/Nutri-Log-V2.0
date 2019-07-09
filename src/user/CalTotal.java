package user;

import java.util.ArrayList;


public class CalTotal {
    static ArrayList<Integer> calHistory = new ArrayList<>();

    public static Integer totalCalories(Integer calories) {
        calHistory.add(calories);
        Integer sum = 0;
        for(Integer i: calHistory) {
            sum = sum + i;
        }
        return sum;
    }
}
