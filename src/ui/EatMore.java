package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class EatMore {
    static Scanner scanner;
    static ArrayList<Integer> calHistory;

    public static void main(String[] args) {
        calHistory = new ArrayList<>();
        scanner = new Scanner(System.in);
        EatMore();
    }
    public static void EatMore() {
        String operation = "";
        Integer calories = 0;
        while (true) {
            System.out.println("Can you eat more today?");
            operation = scanner.nextLine();
            if (operation.equals("yes")) {
                System.out.println("Are you sure?");
                operation = scanner.nextLine();
                if (operation.equals("yes")) {
                    System.out.println("Fine ... How many calories?");
                    calories = scanner.nextInt();
                    System.out.println("You have entered " + calories + " calories");
                    operation = scanner.nextLine();
                    ableToEat(calories);
                }
                else if (operation.equals("no")) {
                    System.out.println("Good Job!");
                }
            }
            else if (operation.equals("no")) {
                System.out.println("Good Job!");
                break;
            }
        }
    }
    public static void ableToEat(Integer calories) {
        Integer totalCal = totalCalories(calories);
        if (totalCal <= 2000) {
            System.out.println("You are within your caloric quota");
            System.out.println("Your total calorie intake is: " + totalCal + " calories");
        }
        else {
            System.out.println("You have reached/exceeded your caloric quota");

        }
    }
    public static Integer totalCalories(Integer calories) {
        calHistory.add(calories);
        Integer sum = 0;
        for(Integer i: calHistory) {
            sum = sum + i;
        }
        return sum;
    }
}