package ui;

import java.io.Serializable;
import java.util.Scanner;

public class SetCalQuota implements Serializable {
    private transient Scanner calInput;
    private int calQuote;
    private Integer calorieQuota;

    //MODIFIES: this
    //EFFECTS: takes in user input and sets the calorie quota.
    public void calQuota() {
        calInput = new Scanner(System.in);
        System.out.println("Please set your caloric quota:");
        try {
            calorieQuota = calInput.nextInt();
            calQuote = calorieQuota;
        } catch (Exception exp) {
            System.out.println("Invalid Entry, Try Again");
            calQuota();
        }
        System.out.println("You have entered " + calorieQuota + " calories");
    }

    //EFFECTS: sets the calorie quota.
    public int getCalorieQuota() {
        return calQuote;
    }

    //MODIFIES: this
    //EFFECTS: edits the calorie quota if user desires.
    public void editCalorieQuota(SetCalQuota settingQuota) {
        System.out.println("Your Set Quota is: " + settingQuota.getCalorieQuota());
        calInput = new Scanner(System.in);
        System.out.println("Do you want to edit your quota value? (yes/no)");
        try {
            String quotaEdit = calInput.nextLine();
            if (quotaEdit.equals("yes")) {
                System.out.println("Please enter your new calorie quota:");
                calQuote = calInput.nextInt();
                System.out.println("Your new calorie quota is: " + calQuote);
            } else {
                System.out.println("Your calorie quota is unchanged");
            }
        } catch (Exception exp) {
            System.out.println("Invalid Entry, Try Again");
            editCalorieQuota(settingQuota);
        }
    }
}
