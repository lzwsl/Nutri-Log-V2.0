package user;

public class CalCalc {

    public static void ableToEat(Integer calories) {
        Integer totalCal = CalTotal.totalCalories(calories);
        if (totalCal <= quota()) {
            System.out.println("You are within your caloric quota");
            System.out.println("Your total calorie intake is: " + totalCal + " calories");
        } else {
            System.out.println("You have reached/exceeded your caloric quota");

        }
    }
    private static int quota(){
        int quota = SetCalQuota.CalQuota();
        return quota;
    }
}