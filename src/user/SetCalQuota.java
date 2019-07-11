package user;

import java.util.Scanner;

public class SetCalQuota {
    static Scanner CalInput;
    static int calquote;
    static Integer caloriequota = 0;
    static String quotaEdit = "";

    public static int CalQuota() {
        CalInput = new Scanner(System.in);
        System.out.println("Please set your caloric quota:");
        caloriequota = CalInput.nextInt();
        calquote = caloriequota;
        System.out.println("You have entered "+caloriequota+" calories");
        return caloriequota;
    }

    public static int getCalorieQuota() {
        return calquote;
    }

    public static void editCalorieQuota() {
        CalInput = new Scanner(System.in);
        System.out.println("Do you want to edit your quota value? (yes/no)");
        quotaEdit = CalInput.nextLine();
        if (quotaEdit.equals("yes")) {
            System.out.println("Please enter your new calorie quota:");
            caloriequota = CalInput.nextInt();
            System.out.println("Your new calorie quota is: "+caloriequota);
        }
        else
        System.out.println("Your calorie quota is unchanged");
    }
}
