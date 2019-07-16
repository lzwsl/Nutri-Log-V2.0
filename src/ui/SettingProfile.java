package ui;

import java.util.Scanner;

public class SettingProfile {
    private Scanner scanner;
    private String input;

    //MODIFIES: this
    //EFFECTS: reads user inputted name and returns input name
    public String SetProfile() {
        scanner = new Scanner(System.in);
        System.out.println("Please Enter/Create Profile Name:");
        input = scanner.nextLine();
        System.out.println("You Have Entered: " + input);
        return input;
    }

    //EFFECTS: returns profile name
    public String getProfile() {
        return input;
    }
}
