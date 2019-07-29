package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadSaveProfile {

    private static SettingProfile sp = new SettingProfile();
    private static WelcomeScreen menu;

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

    public static WelcomeScreen savingProfile() {
        try {
            FileOutputStream saveFile = new FileOutputStream(sp.getProfile() + "UserProfile");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(menu);
        } catch (Exception exc) {
            System.out.println("See You Next Time!");
        }
        return menu;
    }
}
