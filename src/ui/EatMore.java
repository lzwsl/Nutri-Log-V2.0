package ui;

import model.Food;
import user.CalCalc;
import user.CalTotal;
import user.SetCalQuota;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EatMore implements Serializable {
    private transient Scanner scanner;
    private Food foodItem;

    //MODIFIES: this, CalTotal, SetCalQuota, ArrayList<Integer>
    //EFFECTS: questions user and confirms calorie consumption, takes in
    //         user input and forwards to calorie calculations.
    public void EatMore(CalTotal c, SetCalQuota s, ArrayList<Food> a) {
        CalCalc caloricCalc = new CalCalc();
        scanner = new Scanner(System.in);
        String operation;
        System.out.println("Can you eat more today? (yes/no)");
        operation = scanner.nextLine();
        if (operation.equals("yes")) {
            System.out.println("Are you sure? (yes/no)");
            operation = scanner.nextLine();
            if (operation.equals("yes")) {
                foodItem = new Food("",0);
                System.out.println("Please Enter Name of Item Consumed");
                foodItem.setFoodName(scanner.nextLine());
                System.out.println("Please Enter Calories Consumed");
                foodItem.setFoodCalories(scanner.nextInt());
                System.out.println("You have entered item: " + foodItem.getFoodName() + " with " + foodItem.getFoodCalories() + " calories");
                operation = scanner.nextLine();
                caloricCalc.ableToEat(foodItem, c, s, a);
            } else if (operation.equals("no")) {
                System.out.println("Return to Welcome Screen?");
            }
        } else if (operation.equals("no")) {
            System.out.println("Return to Welcome Screen?");
        }
    }
}
