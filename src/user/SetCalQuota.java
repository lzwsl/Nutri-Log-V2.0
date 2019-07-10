package user;

import java.util.Scanner;

public class SetCalQuota {
    static Scanner CalInput = new Scanner(System.in);
    static int calquote;

    public static int CalQuota() {
        Integer caloriequota = 0;
        System.out.println("Please set your caloric quota:");
        caloriequota = CalInput.nextInt();
        calquote = caloriequota;
        System.out.println("You have entered "+caloriequota+" calories");
        return caloriequota;
    }

    public static int getCalorieQuota() {
        return calquote;
    }
}
