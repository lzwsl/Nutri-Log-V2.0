package ui;

import user.CalCalc;
import user.CalTotal;
import user.SetCalQuota;

import java.util.ArrayList;
import java.util.Scanner;

public class EatMore {
    private Scanner scanner;

    public void EatMore(CalTotal c, SetCalQuota s, ArrayList<Integer> a) {
        CalCalc caloricCalc = new CalCalc();
        scanner = new Scanner(System.in);
        String operation;
        Integer calories;
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
                caloricCalc.ableToEat(calories, c, s, a);
            } else if (operation.equals("no")) {
                System.out.println("Return to Welcome Screen?");
            }
        } else if (operation.equals("no")) {
            System.out.println("Return to Welcome Screen?");
        }
    }
}
