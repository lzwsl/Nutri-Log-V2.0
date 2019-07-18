package user;

import java.io.Serializable;
import java.util.Scanner;

public class SetCalQuota implements Serializable {
    private transient Scanner CalInput;
    private int calquote;
    private Integer caloriequota;
    private String quotaEdit;

    //MODIFIES: this
    //EFFECTS: takes in user input and sets the calorie quota.
    public void CalQuota() {
        CalInput = new Scanner(System.in);
        System.out.println("Please set your caloric quota:");
        try { caloriequota = CalInput.nextInt();
            calquote = caloriequota;}
        catch(Exception exp) {
            System.out.println("Invalid Entry, Try Again");
            CalQuota();
        }
        System.out.println("You have entered "+caloriequota+" calories");
    }

    //EFFECTS: sets the calorie quota.
    public int getCalorieQuota() {
        return calquote;
    }

    //MODIFIES: this
    //EFFECTS: edits the calorie quota if user desires.
    public void editCalorieQuota() {
        CalInput = new Scanner(System.in);
        System.out.println("Do you want to edit your quota value? (yes/no)");
        try {
            quotaEdit = CalInput.nextLine();
            if (quotaEdit.equals("yes")) {
                System.out.println("Please enter your new calorie quota:");
                calquote = CalInput.nextInt();
                System.out.println("Your new calorie quota is: " + calquote);
            } else
                System.out.println("Your calorie quota is unchanged");
        } catch (Exception exp) {
            System.out.println("Invalid Entry, Try Again");
            editCalorieQuota();
        }
    }
}
