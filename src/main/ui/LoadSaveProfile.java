package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadSaveProfile {

    private static SetLoadProfile sp = new SetLoadProfile();
    private static WelcomeScreen menu;

    //EFFECTS: Loads/Creates user profile
    public static WelcomeScreen loadingProfile() {
        sp.setProfile();
        try {
            FileInputStream openFile = new FileInputStream(sp.getProfile() + "UserProfile");
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
            FileOutputStream saveFile = new FileOutputStream(sp.getProfile() + "UserProfile");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(menu);
            System.out.println("");
            System.out.println("Nutri-Log, Always With You!");
        } catch (Exception exc) {
            System.out.println("Something Went Wrong!");
        }
    }
}
