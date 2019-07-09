package user;

import java.util.Scanner;

public class SetCalQuota {
    static Scanner CalInput = new Scanner(System.in);

    public static int CalQuota() {
        Integer caloriequota = 0;
        System.out.println("Please set your caloric quota:");
        caloriequota = CalInput.nextInt();
        System.out.println("You have entered "+caloriequota+" calories");
        return caloriequota;
    }
}
