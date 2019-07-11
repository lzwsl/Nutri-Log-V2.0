package ui;

import user.SetCalQuota;

import java.util.Scanner;

public class WelcomeScreen {
    static Scanner welcomeScan;

    public static void main(String[] args) {
        System.out.println("Nutri-Log V1");
        SetCalQuota.CalQuota();
        WelcomeScreen.WelcomeScreen();
        EatMore.EatMore();
    }

    public static void WelcomeScreen() {
        welcomeScan = new Scanner(System.in);
        Integer option = 0;
        System.out.println("Please choose from the following;");
        System.out.println("(1) View/Edit Calorie Quota");
        System.out.println("(2) Input New Food Item");
        System.out.println("(3) View Current Calorie Total");
        System.out.println("(0) Close Application");
        option = welcomeScan.nextInt();
        if (option.equals(1)){
            System.out.println("Your Set Quota is: " + SetCalQuota.getCalorieQuota());
            SetCalQuota.editCalorieQuota();
        }
        if (option.equals(2)){
            EatMore.EatMore();
        }
        if (option.equals(3)){
            System.out.println("Your Current Calories Consumed: " + user.CalTotal.retrieveCurrentCalories());
        }
        if (option.equals(0)){
            System.exit(0);
        }
        WelcomeScreen();
    }
}
