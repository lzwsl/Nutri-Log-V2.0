package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
//        GetFromOnline g = new GetFromOnline();
//        try {
//            g.initialMessage();
//        } catch (IOException exp) {
//            System.out.println("Oops!");
//        }
//        System.out.println("Nutri-Log v1.1");
//        System.out.println("");
//        WelcomeScreen menu = LoadSaveProfile.loadingProfile();
//        menu.run();
//        LoadSaveProfile.savingProfile();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nutri-Log V2.0");
        Button button = new Button();
        button.setText("Enter/Initialize Profile");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("pressed!");
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}



//ORIGINACL MAIN CODE:
//    public static void main(String[] args) {
//        GetFromOnline g = new GetFromOnline();
//        try {
//            g.initialMessage();
//        } catch (IOException exp) {
//            System.out.println("Oops!");
//        }
//        System.out.println("Nutri-Log v1.1");
//        System.out.println("");
//        WelcomeScreen menu = LoadSaveProfile.loadingProfile();
//        menu.run();
//        LoadSaveProfile.savingProfile();
//    }































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