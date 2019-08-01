package ui;

import exceptions.InvalidConsumableType;
import model.Consumable;
import model.Food;
import model.Supplements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EatMore implements Serializable {
    private transient Scanner scanner;
    private Consumable consumableItem;

    //MODIFIES: this, CalTotal, SetCalQuota, ArrayList<Integer>
    //EFFECTS: questions user and confirms calorie consumption, takes in
    //         user input and forwards to calorie calculations.
    public void eatMore(CalTotal c, SetCalQuota s, ArrayList<Consumable> a) {
        CalCalc caloricCalc = new CalCalc();
        scanner = new Scanner(System.in);
        String operation;
        System.out.println("Can you eat more today? (yes/no)");
        try {
            operation = scanner.nextLine();
            if (operation.equals("yes")) {
                System.out.println("Are you sure? (yes/no)");
                try {
                    toEat(c, s, a, caloricCalc);
                } catch (InvalidConsumableType ict) {
                    System.out.println("Invalid Entry, Try Again.");
                }
            }
        } catch (Exception exp) {
            System.out.println("Invalid Entry, Try Again");
            eatMore(c, s, a);
        }
    }

    //EFFECTS: processes user input if they can or cannot eat
    private void toEat(CalTotal c, SetCalQuota s, ArrayList<Consumable> a, CalCalc cc) throws InvalidConsumableType {
        String operation;
        operation = scanner.nextLine();
        if (operation.equals("yes")) {
            yesCanEat(c, s, a, cc);
        } else {
            if (operation.equals("no")) {
                System.out.println("Returning to Welcome Screen?");
            } else {
                throw new InvalidConsumableType();
            }
        }
    }

    //EFFECTS: takes input for what user ate
    private void yesCanEat(CalTotal c, SetCalQuota s, ArrayList<Consumable> a, CalCalc caloricCalc) {
        String operation;
        System.out.println("Please Specify Consumable Type [food/supplement]");
        operation = scanner.nextLine();
        if (operation.equals("food")) {
            foodItemEnter(c);
            caloricCalc.ableToEat(consumableItem, c, s, a);
        }
        if (operation.equals("supplement")) {
            supplementItemEnter();
            caloricCalc.ableToEat(consumableItem, c, s, a);
        }
    }

    //EFFECTS: processes eaten food
    public void foodItemEnter(CalTotal c) {
        consumableItem = new Food("", 0);
        System.out.println("Please Enter Name of Item Consumed");
        consumableItem.setName(scanner.nextLine());
        System.out.println("Please Enter Calories Consumed");
        consumableItem.setCalories(scanner.nextInt());
        System.out.println("You have entered item: " + consumableItem.getName()
                + " with " + consumableItem.getCalories() + " calories");
    }

    //EFFECTS: processes supplement eaten
    public void supplementItemEnter() {
        consumableItem = new Supplements("", 0);
        System.out.println("Please Enter Name of Item Consumed");
        consumableItem.setName(scanner.nextLine());
        System.out.println("You have entered item: " + consumableItem.getName());
    }
}






















//ORIGINAL FOOD CODE:
//                            consumableItem = new Food("", 0);
//                            System.out.println("Please Enter Name of Item Consumed");
//                            consumableItem.setName(scanner.nextLine());
//                            System.out.println("Please Enter Calories Consumed");
//                            consumableItem.setCalories(scanner.nextInt());
//                            System.out.println("You have entered item: " + consumableItem.getName()
//                            + " with " + consumableItem.getCalories() + " calories");

//ORIGINAL SUPPLEMENT CODE:
//                            consumableItem = new Supplements("", 0);
//                            System.out.println("Please Enter Name of Item Consumed");
//                            consumableItem.setName(scanner.nextLine());
//                            System.out.println("You have entered item: " + consumableItem.getName());

//    //EFFECTS: processes eaten food
//    public void foodItemEnter(CalTotal c) {
//        consumableItem = new Food("", 0);
//        System.out.println("Please Enter Name of Item Consumed");
//        consumableItem.setName(scanner.nextLine());
//        System.out.println("Please Enter Calories Consumed");
//        consumableItem.setCalories(scanner.nextInt());
//        System.out.println("You have entered item: " + consumableItem.getName()
//                + " with " + consumableItem.getCalories() + " calories");
//        c.addConsumable(consumableItem);
//    }