package ui;

import exceptions.InvalidConsumableType;

public class Main {

    public static void main(String[] args) throws InvalidConsumableType {
        System.out.println("Nutri-Log v1.0");
        System.out.println("");
        WelcomeScreen menu = LoadSaveProfile.loadingProfile();
        menu.run();
        LoadSaveProfile.savingProfile();
    }
}













//ORIGINAL LOAD CODE:
//        SetLoadProfile sp = new SetLoadProfile();
//        sp.setProfile();
//        WelcomeScreen menu = LoadSaveProfile.loadingProfile();
//        try {
//            FileInputStream openFile = new FileInputStream(sp.getProfile() + "UserProfile");
//            ObjectInputStream open = new ObjectInputStream(openFile);
//            menu = (WelcomeScreen) open.readObject();
//        } catch (Exception exc) {
//            menu = new WelcomeScreen();
//        } finally {
//            System.out.println("");
//            System.out.println("Profile Loaded/Created Successfully");
//        }


//ORIGINAL SAVE CODE:
//        try {
//            FileOutputStream saveFile = new FileOutputStream(sp.getProfile() + "UserProfile");
//            ObjectOutputStream save = new ObjectOutputStream(saveFile);
//            save.writeObject(menu);
//        } catch (Exception exc) {
//            System.out.println("See You Next Time!");
//        }