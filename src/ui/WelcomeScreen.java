package ui;

import exceptions.InvalidConsumableType;
import model.Consumable;
import user.CalTotal;
import user.SetCalQuota;
import model.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WelcomeScreen implements Serializable{
//    private Scanner welcomeScan;

    private ArrayList<Consumable> calHistory;
    private SetCalQuota settingQuota;
    private EatMore moreEating;
    private CalTotal totaCal;
    private AllItems everyItem;

    //MODIFIES: this, SetCalQuota, EatMore, CalTotal, ArrayList<Integer>
    //EFFECTS: interface for user to navigate application
    public WelcomeScreen() {
        settingQuota = new SetCalQuota();
        settingQuota.CalQuota();
        moreEating = new EatMore();
        totaCal = new CalTotal();
        calHistory = new ArrayList<>();
        everyItem = new AllItems();
    }

    //EFFECTS: runs the specified program that user chooses
    public void run() throws InvalidConsumableType {
        Scanner welcomeScan = new Scanner(System.in);
        String option;
        for (int i = 1; i != 0; ) {
            System.out.println("");
            System.out.println("Please choose from the following;");
            System.out.println("(1) View/Edit Calorie Quota");
            System.out.println("(2) Input Items To Be Consumed");
            System.out.println("(3) View/Edit Current Calorie Total");
            System.out.println("(4) View Consumed Items");
            System.out.println("(0) Close Application");
            option = welcomeScan.nextLine();
            System.out.println("");
            if (option.equals("1")) {
                System.out.println("Your Set Quota is: " + settingQuota.getCalorieQuota());
                settingQuota.editCalorieQuota();
            }
            else if (option.equals("2")) {
                Food f;
                moreEating.EatMore(totaCal, settingQuota, calHistory);
            }
            else if (option.equals("3")) {
                System.out.println("Your Current Calories Consumed: " + totaCal.getCurrentCalories());
                totaCal.clearCurrentCalories(calHistory);
            }
            else if (option.equals("4")) {
                System.out.println("Your Most Recently Consumed Items:");
                everyItem.AllItems(calHistory);
            }
            else if (option.equals("0")) {
                i = 0;
            }
            else
                System.out.println("Invalid Entry, Try Again.");

        }
    }
}
