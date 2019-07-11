package ui;

import user.CalCalc;

import java.util.Scanner;

public class EatMore {
    static Scanner scanner;

    public static void EatMore() {
        scanner = new Scanner(System.in);
        String operation = "";
        Integer calories = 0;
        System.out.println("Can you eat more today? (yes/no)");
        operation = scanner.nextLine();
        if (operation.equals("yes")) {
            System.out.println("Are you sure? (yes/no)");
            operation = scanner.nextLine();
            if (operation.equals("yes")) {
                System.out.println("Fine ... How many calories?");
                calories = scanner.nextInt();
                System.out.println("You have entered " + calories + " calories");
                operation = scanner.nextLine();
                CalCalc.ableToEat(calories);
            } else if (operation.equals("no")) {
                System.out.println("Return to Welcome Screen?");
            }
        } else if (operation.equals("no")) {
            System.out.println("Return to Welcome Screen?");
        }
    }
}
