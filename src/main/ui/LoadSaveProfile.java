package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadSaveProfile {

    private static WelcomeScreen menu;
    private static String profileNm;

    //EFFECTS: Loads/Creates user profile
    public static WelcomeScreen loadingProfile(String profileName) {
        profileNm = profileName;
        try {
            FileInputStream openFile = new FileInputStream(profileName + "UserProfile");
            ObjectInputStream open = new ObjectInputStream(openFile);
            menu = (WelcomeScreen) open.readObject();
        } catch (Exception exc) {
            menu = new WelcomeScreen();
        } finally {
            System.out.println("");
            System.out.println("Profile Loaded/Created Successfully");
        }
        return menu;
    }

    //EFFECTS: saves user profile state into file
    public static void savingProfile() {
        try {
            FileOutputStream saveFile = new FileOutputStream(profileNm + "UserProfile");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(menu);
            System.out.println("");
            System.out.println("Nutri-Log, Always With You!");
            System.exit(0);
        } catch (Exception exc) {
            System.out.println("Something Went Wrong!");
        }
    }
}
