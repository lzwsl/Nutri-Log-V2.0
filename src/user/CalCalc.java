package user;


import java.util.ArrayList;

public class CalCalc {

    public void ableToEat(Integer calories, CalTotal c, SetCalQuota s, ArrayList<Integer> a) {
//        CalTotal caloricTotal = new CalTotal();
//        SetCalQuota caloricQuotaSet = new SetCalQuota();
        Integer totalCal = c.totalCalories(calories, a);
        if (totalCal <= s.getCalorieQuota()) {
            System.out.println("You are within your caloric quota");
            System.out.println("Your total calorie intake is: " + totalCal + " calories");
        } else {
            System.out.println("You have reached/exceeded your caloric quota");

        }
    }
}
