package ui;

import model.Consumable;
import model.Food;
import model.Supplements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

public class WelcomeScreen extends Observable implements Serializable {

    private transient Scanner welcomeScan;
    private HashMap<String, String> optionPrompt = new HashMap<>();
    private ArrayList<Consumable> calHistory;
    private SetCalQuota settingQuota;
    private EatMore moreEating;
    private CalTotal totalCal;
    private AllItems everyItem;

    //EFFECTS: main menu
    public void mainMenuSelections() {
        System.out.println(optionPrompt.get(""));
        System.out.println(optionPrompt.get("Please choose from the following:"));
        System.out.println(optionPrompt.get("(1) View/Edit Calorie Quota"));
        System.out.println(optionPrompt.get("(2) Input Items To Be Consumed"));
        System.out.println(optionPrompt.get("(3) View/Edit Current Calorie Total"));
        System.out.println(optionPrompt.get("(4) View Consumed Food Items"));
        System.out.println(optionPrompt.get("(0) Close Application"));
        System.out.println(optionPrompt.get(""));
    }

    //MODIFIES: this, SetCalQuota, eatMore, CalTotal, ArrayList<Integer>
    //EFFECTS: interface for user to navigate application
    public WelcomeScreen() {
        settingQuota = new SetCalQuota();
        settingQuota.setCalQuota(0);
        moreEating = new EatMore();
        totalCal = new CalTotal();
        calHistory = new ArrayList<>();
        everyItem = new AllItems();
    }

    public void setCalQuota(int i) {
        settingQuota.setCalQuota(i);
    }

    public int getCalQuota() {
        return settingQuota.getCalQuota();
    }

    public void addFood(String name, Integer calories) {
        Consumable f = new Food(name, calories);
        calculateTotal(f);
    }

    public void addSupplement(String name) {
        Consumable s = new Supplements(name, 0);
        calHistory.add(s);
    }

    public Integer getCurrentCalories() {
        return totalCal.getCurrentCalories();
    }

    public void resetCalorieHistory() {
        totalCal.clearCurrentCalories(calHistory);
    }

    public void calculateTotal(Consumable c) {
        totalCal.totalCalories(c, calHistory);
    }

    public ArrayList<Consumable> getHistory() {
        return calHistory;
    }

    //EFFECTS: runs the specified program that user chooses
    public void run() {
        for (int i = 1; i != 0; ) {
            mainMenuSelections();
            welcomeScan = new Scanner(System.in);
            String option = welcomeScan.nextLine();
            if (option.equals("1")) {
                settingQuota.editCalorieQuota(settingQuota);
            } else if (option.equals("2")) {
                moreEating.eatMore(totalCal, settingQuota, calHistory);
            } else if (option.equals("3")) {
                totalCal.clearCurrentCalories(calHistory);
            } else if (option.equals("4")) {
                totalCal.getConsumableFoods(everyItem, calHistory);
            } else if (option.equals("0")) {
                i = 0;
            } else {
                System.out.println("Invalid Entry, Try Again.");
            }
        }
    }
}













//ORIGINAL CODE:
//if (option.equals("1")) {
//        System.out.println("Your Set Quota is: " + settingQuota.getCalQuota());
//        settingQuota.editCalorieQuota();
//        } else if (option.equals("2")) {
//        moreEating.eatMore(totalCal, settingQuota, calHistory);
//        } else if (option.equals("3")) {
//        System.out.println("Your Current Calories Consumed: " + totalCal.getCurrentCalories());
//        totalCal.clearCurrentCalories(calHistory, totalCal);
//        } else if (option.equals("4")) {
//        System.out.println("Your Most Recently Consumed Items:");
//        everyItem.allItems(calHistory);
//        } else if (option.equals("0")) {
//        i = 0;
//        } else {
//        System.out.println("Invalid Entry, Try Again.");
//        }