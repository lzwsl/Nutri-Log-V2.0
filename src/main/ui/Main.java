package ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Button btnSubmit;
    private Button btnClear;
    private Button btnExit;

    private Label lblName;
    private Label lblPwd;

    private TextField tfName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nutri-Log V2.0");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(12);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column2);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);

        btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(b -> profileExists());
        btnClear = new Button("Clear");
        btnClear.setOnAction(b -> tfName.clear());
        btnExit = new Button("Exit");
        btnExit.setOnAction(b -> System.exit(0));

        lblName = new Label("User Profile Name:");
        tfName = new TextField();

        hbButtons.getChildren().addAll(btnSubmit, btnClear, btnExit);
        grid.add(lblName, 0, 0);
        grid.add(tfName, 1, 0);
        grid.add(hbButtons, 0, 2, 2, 1);

        Scene scene = new Scene(grid, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void profileExists() {
        if (tfName.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING,"You Have Not Entered A Profile Name");
            a.setTitle("No PROFILE!");
            a.showAndWait();
        } else {
            LoadSaveProfile.loadingProfile();
        }
    }
}


























//ORIGINAL MAIN CODE:
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
//}







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