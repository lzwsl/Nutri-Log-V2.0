package ui;

import exceptions.InvalidConsumableType;
import model.Consumable;
import model.Food;
import model.Supplements;
import user.CalCalc;
import user.CalTotal;
import user.SetCalQuota;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EatMore implements Serializable {
    private transient Scanner scanner;
    private Consumable consumableItem;

    //MODIFIES: this, CalTotal, SetCalQuota, ArrayList<Integer>
    //EFFECTS: questions user and confirms calorie consumption, takes in
    //         user input and forwards to calorie calculations.
    public void EatMore(CalTotal c, SetCalQuota s, ArrayList<Consumable> a) throws InvalidConsumableType {
        CalCalc caloricCalc = new CalCalc();
        scanner = new Scanner(System.in);
        String operation;
        System.out.println("Can you eat more today? (yes/no)");
        try {
            operation = scanner.nextLine();
            if (operation.equals("yes")) {
                System.out.println("Are you sure? (yes/no)");
                try {
                    operation = scanner.nextLine();
                    if (operation.equals("yes")) {
                        System.out.println("Please Specify Consumable Type [food/supplement]");
                        operation = scanner.nextLine();
                        if (operation.equals("food")) {
                            consumableItem = new Food("", 0);
                            System.out.println("Please Enter Name of Item Consumed");
                            consumableItem.setName(scanner.nextLine());
                            System.out.println("Please Enter Calories Consumed");
                            consumableItem.setCalories(scanner.nextInt());
                            System.out.println("You have entered item: " + consumableItem.getName() + " with " + consumableItem.getCalories() + " calories");
//                        operation = scanner.nextLine();
                            caloricCalc.ableToEat(consumableItem, c, s, a);
                        }
                        if (operation.equals("supplement")) {
                            consumableItem = new Supplements("", 0);
                            System.out.println("Please Enter Name of Item Consumed");
                            consumableItem.setName(scanner.nextLine());
                            System.out.println("You have entered item: " + consumableItem.getName());
                            caloricCalc.ableToEat(consumableItem, c, s, a);
                        }
                    } else {
                        if (operation.equals("no")) {
                            System.out.println("Returning to Welcome Screen?");
                        } else {
                            throw new InvalidConsumableType();
                        }
                    }
                } catch (InvalidConsumableType ict) {
                    System.out.println("Invalid Entry, Try Again.");
                }

//                consumableItem = new Food("",0);
//                System.out.println("Please Enter Name of Item Consumed");
//                consumableItem.setName(scanner.nextLine());
//                System.out.println("Please Enter Calories Consumed");
//                consumableItem.setCalories(scanner.nextInt());
//                System.out.println("You have entered item: " + consumableItem.getName() + " with " + consumableItem.getCalories() + " calories");
//                operation = scanner.nextLine();
//                caloricCalc.ableToEat(consumableItem, c, s, a);
//            } else if (operation.equals("no")) {
//                System.out.println("Return to Welcome Screen?");
////            }
//        } else if (operation.equals("no")) {
//            System.out.println("Return to Welcome Screen?");
            }
        } catch (Exception exp) {
            System.out.println("Invalid Entry, Try Again");
            EatMore(c, s, a);
        }
    }
}
