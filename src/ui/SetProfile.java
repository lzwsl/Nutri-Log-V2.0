package ui;

import java.util.Scanner;

public class SetProfile {
    private Scanner scanner;
    private String input;

    public String SetProfile() {
        scanner = new Scanner(System.in);
        System.out.println("Please Enter/Create Profile Name:");
        input = scanner.nextLine();
        System.out.println("You Have Entered: " + input);
        return input;
    }

    public String getProfile() {
        return input;
    }
}
