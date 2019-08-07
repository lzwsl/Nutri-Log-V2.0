package ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private WelcomeScreen menu;

    private Button btnSubmit;
    private Button btnClear;
    private Button btnExit;

    private RadioButton opt1;
    private RadioButton opt2;
    private RadioButton opt3;
    private RadioButton opt4;

    private Label lblName;
    private Label lblPwd;

    private TextField tfName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Nutri-Log V2.0");
        MainGuiSetup mainGuiSetup = new MainGuiSetup().invoke();
        GridPane grid = mainGuiSetup.getGrid();
        HBox hbButtons = mainGuiSetup.getHbButtons();
        setInitialButtons(primaryStage, grid, hbButtons);
        Scene scene = new Scene(grid, 480, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setInitialButtons(Stage primaryStage, GridPane grid, HBox hbButtons) {
        btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(b -> profileExists(primaryStage));
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
    }

    public void profileExists(Stage primaryStage) {
        if (tfName.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING,"You Have Not Entered A Profile Name");
            a.setTitle("No PROFILE!");
            a.showAndWait();
        } else {
            menu = LoadSaveProfile.loadingProfile(tfName.getText());
            Alert b = new Alert(Alert.AlertType.INFORMATION, "Profile Successfully Loaded/Created");
            b.setTitle("Loaded/Created Successfully");
            b.showAndWait();
            afterProfLoad(primaryStage);
        }
    }

    private void afterProfLoad(Stage primaryStage) {
        GridPane bp = new GridPane();
        AplSetup aplSetup = new AplSetup(bp).invoke();
        VBox vb = aplSetup.getVb();
        Scene scene = aplSetup.getScene();
        ToggleGroup mainTog = aplSetup.getMainTog();
        Button proceed = new Button("Proceed");
        vb.getChildren().addAll(opt1, opt2, opt3, opt4, proceed);
        proceed.setOnAction(b -> bigDecision(mainTog, primaryStage));
        bp.add(vb,1,1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void bigDecision(ToggleGroup mt, Stage primaryStage) {
        if (mt.getSelectedToggle().equals(opt1)) {
            editCalQuota(primaryStage);
        }
        if (mt.getSelectedToggle().equals(opt2)) {
            makeFood(primaryStage);
        }
        if (mt.getSelectedToggle().equals(opt3)) {
            System.out.println("opt3");
        }
        if (mt.getSelectedToggle().equals(opt4)) {
            System.out.println("opt4");
        }
    }

    private void editCalQuota(Stage primaryStage) {
        GridPane ecq = new GridPane();
        EcqSetup ecqSetup = new EcqSetup(ecq).invoke();
        HBox ecqBttns = ecqSetup.getEcqBttns();
        Scene ecqScene = ecqSetup.getEcqScene();

        btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(b -> System.out.println("hih"));
        btnClear = new Button("Clear");
        btnClear.setOnAction(b -> tfName.clear());
        btnExit = new Button("Exit");
        btnExit.setOnAction(b -> LoadSaveProfile.savingProfile());

        Label lblQuota = new Label("Enter Caloric Quota:");
        tfName = new TextField();

        ecqBttns.getChildren().addAll(btnSubmit, btnClear, btnExit);
        ecq.add(lblQuota, 0, 0);
        ecq.add(tfName, 1, 0);
        ecq.add(ecqBttns, 0, 2, 2, 1);
        primaryStage.setScene(ecqScene);
        primaryStage.show();
    }


    protected class MainGuiSetup {
        private GridPane grid;
        private HBox hbButtons;

        public GridPane getGrid() {
            return grid;
        }

        public HBox getHbButtons() {
            return hbButtons;
        }

        public MainGuiSetup invoke() {
            grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(12);

            ColumnConstraints column1 = new ColumnConstraints();
            column1.setHalignment(HPos.RIGHT);
            grid.getColumnConstraints().add(column1);

            ColumnConstraints column2 = new ColumnConstraints();
            column2.setHalignment(HPos.LEFT);
            grid.getColumnConstraints().add(column2);

            hbButtons = new HBox();
            hbButtons.setSpacing(10.0);
            return this;
        }
    }

    private void makeFood(Stage primaryStage) {
        GridPane ecq = new GridPane();
        MakeFoodSetup makeFoodSetup = new MakeFoodSetup(ecq).invoke();
        HBox ecqBttns = makeFoodSetup.getEcqBttns();
        Scene ecqScene = makeFoodSetup.getEcqScene();

        mfInteraction(ecq, ecqBttns);
        primaryStage.setScene(ecqScene);
        primaryStage.show();
    }

    private void mfInteraction(GridPane ecq, HBox ecqBttns) {
        btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(b -> System.out.println("hih"));
        btnClear = new Button("Clear");
        btnClear.setOnAction(b -> tfName.clear());
        btnExit = new Button("Exit");
        btnExit.setOnAction(b -> LoadSaveProfile.savingProfile());

        Label lblName = new Label("Enter Food Name:");
        TextField foodName = new TextField();
        Label lblCalories = new Label("Enter Food Calories:");
        TextField foodCalories = new TextField();

        ecqBttns.getChildren().addAll(btnSubmit, btnClear, btnExit);
        ecq.add(lblName, 0, 0);
        ecq.add(foodName, 1, 0);
        ecq.add(lblCalories, 0, 1);
        ecq.add(foodCalories, 1, 1);
        ecq.add(ecqBttns, 0, 3, 2, 1);
    }

    private class MakeFoodSetup {
        private GridPane ecq;
        private HBox ecqBttns;
        private Scene ecqScene;

        public MakeFoodSetup(GridPane ecq) {
            this.ecq = ecq;
        }

        public HBox getEcqBttns() {
            return ecqBttns;
        }

        public Scene getEcqScene() {
            return ecqScene;
        }

        public MakeFoodSetup invoke() {
            ecq.setAlignment(Pos.CENTER);
            ecq.setHgap(10);
            ecq.setVgap(12);
            ecqBttns = new HBox();
            ecqBttns.setSpacing(10.0);
            ecqScene = new Scene(ecq, 480, 720);

            ColumnConstraints column1 = new ColumnConstraints();
            column1.setHalignment(HPos.RIGHT);
            ecq.getColumnConstraints().add(column1);

            ColumnConstraints column2 = new ColumnConstraints();
            column2.setHalignment(HPos.LEFT);
            ecq.getColumnConstraints().add(column2);
            return this;
        }
    }

    private class EcqSetup {
        private GridPane ecq;
        private HBox ecqBttns;
        private Scene ecqScene;

        public EcqSetup(GridPane ecq) {
            this.ecq = ecq;
        }

        public HBox getEcqBttns() {
            return ecqBttns;
        }

        public Scene getEcqScene() {
            return ecqScene;
        }

        public EcqSetup invoke() {
            ecq.setAlignment(Pos.CENTER);
            ecq.setHgap(10);
            ecq.setVgap(12);
            ecqBttns = new HBox();
            ecqBttns.setSpacing(10.0);
            ecqScene = new Scene(ecq, 480, 720);

            ColumnConstraints column1 = new ColumnConstraints();
            column1.setHalignment(HPos.RIGHT);
            ecq.getColumnConstraints().add(column1);

            ColumnConstraints column2 = new ColumnConstraints();
            column2.setHalignment(HPos.LEFT);
            ecq.getColumnConstraints().add(column2);
            return this;
        }
    }

    private class AplSetup {
        private GridPane bp;
        private VBox vb;
        private Scene scene;
        private ToggleGroup mainTog;

        public AplSetup(GridPane bp) {
            this.bp = bp;
        }

        public VBox getVb() {
            return vb;
        }

        public Scene getScene() {
            return scene;
        }

        public ToggleGroup getMainTog() {
            return mainTog;
        }

        public AplSetup invoke() {
            bp.setAlignment(Pos.CENTER);
            bp.setHgap(10);
            bp.setVgap(12);
            vb = new VBox();
            vb.setSpacing(10);
            scene = new Scene(bp, 480, 720);
            opt1 = new RadioButton("View/Edit Calorie Quota");
            opt2 = new RadioButton("Input Items To Be Consumed");
            opt3 = new RadioButton("View/Edit Current Calorie Total");
            opt4 = new RadioButton("View Consumed Food Item");
            mainTog = new ToggleGroup();
            opt1.setToggleGroup(mainTog);
            opt2.setToggleGroup(mainTog);
            opt3.setToggleGroup(mainTog);
            opt4.setToggleGroup(mainTog);
            return this;
        }
    }
}