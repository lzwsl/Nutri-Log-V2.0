package user;

import java.util.Scanner;

public class SetCalQuota {
    private Scanner CalInput;
    private int calquote;
    private Integer caloriequota;
    private String quotaEdit;

    public void CalQuota() {
        CalInput = new Scanner(System.in);
        System.out.println("Please set your caloric quota:");
        caloriequota = CalInput.nextInt();
        calquote = caloriequota;
        System.out.println("You have entered "+caloriequota+" calories");
    }

    public int getCalorieQuota() {
        return calquote;
    }

    public void editCalorieQuota() {
        CalInput = new Scanner(System.in);
        System.out.println("Do you want to edit your quota value? (yes/no)");
        quotaEdit = CalInput.nextLine();
        if (quotaEdit.equals("yes")) {
            System.out.println("Please enter your new calorie quota:");
            calquote = CalInput.nextInt();
            System.out.println("Your new calorie quota is: "+calquote);
        }
        else
        System.out.println("Your calorie quota is unchanged");
    }
}
