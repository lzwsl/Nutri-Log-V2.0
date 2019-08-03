package ui;

import model.Consumable;

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

    //EFFECTS: HashMap of printouts
    private void promptPrintout() {
        optionPrompt.put("linebreak", "");
        optionPrompt.put("pc", "Please choose from the following:");
        optionPrompt.put("1", "(1) View/Edit Calorie Quota");
        optionPrompt.put("2", "(2) Input Items To Be Consumed");
        optionPrompt.put("3", "(3) View/Edit Current Calorie Total");
        optionPrompt.put("4", "(4) View Consumed Food Items");
        optionPrompt.put("0", "(0) Close Application");
        mainMenuSelections();
    }

    //EFFECTS: main menu
    private void mainMenuSelections() {
        System.out.println(optionPrompt.get("linebreak"));
        System.out.println(optionPrompt.get("pc"));
        System.out.println(optionPrompt.get("1"));
        System.out.println(optionPrompt.get("2"));
        System.out.println(optionPrompt.get("3"));
        System.out.println(optionPrompt.get("4"));
        System.out.println(optionPrompt.get("0"));
        System.out.println(optionPrompt.get("linebreak"));
    }

    //MODIFIES: this, SetCalQuota, eatMore, CalTotal, ArrayList<Integer>
    //EFFECTS: interface for user to navigate application
    public WelcomeScreen() {
        settingQuota = new SetCalQuota();
        settingQuota.calQuota();
        moreEating = new EatMore();
        totalCal = new CalTotal();
        calHistory = new ArrayList<>();
        everyItem = new AllItems();
    }

    //EFFECTS: runs the specified program that user chooses
    public void run() {
        for (int i = 1; i != 0; ) {
            promptPrintout();
            welcomeScan = new Scanner(System.in);
            String option = welcomeScan.nextLine();
            if (option.equals("1")) {
                settingQuota.editCalorieQuota(settingQuota);
            } else if (option.equals("2")) {
                moreEating.eatMore(totalCal, settingQuota, calHistory);
            } else if (option.equals("3")) {
                totalCal.clearCurrentCalories(calHistory, totalCal);
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
//        System.out.println("Your Set Quota is: " + settingQuota.getCalorieQuota());
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