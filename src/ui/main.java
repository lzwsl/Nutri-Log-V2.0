package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class main {

    public static void main(String[] args) {
        System.out.println("Nutri-Log v1.0");
        SetProfile sp = new SettingProfile();
        sp.SetProfile();
        WelcomeScreen menu;
        try {
            FileInputStream openFile = new FileInputStream(sp.getProfile()+"UserProfile");
            ObjectInputStream open = new ObjectInputStream(openFile);
            menu = (WelcomeScreen) open.readObject();
        }
        catch(Exception exc) {
            menu = new WelcomeScreen();
            exc.printStackTrace();
        }
        menu.run();
        try {
            FileOutputStream saveFile = new FileOutputStream(sp.getProfile()+"UserProfile");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(menu);
        }
        catch(Exception exc) {
            exc.printStackTrace();
        }
    }
}
