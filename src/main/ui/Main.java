package ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Consumable;

public class Main extends Application {

    private static WelcomeScreen menu;

    private String buttonStyle = "-fx-background-color: \n"
            + "#000000,\n"
            + "linear-gradient(#7ebcea, #2f4b8f),\n"
            + "linear-gradient(#426ab7, #263e75),\n"
            + "linear-gradient(#395cab, #223768);\n"
            + "-fx-background-insets: 0,1,2,3;\n"
            + "-fx-background-radius: 3,2,2,2;\n"
            + "-fx-padding: 12 30 12 30;\n"
            + "-fx-text-fill: white;\n"
            + "-fx-font-size: 12px";

    private Button btnSubmit;
    private Button btnClear;
    private Button btnExit;
    private Button btnReturn;

    private RadioButton opt1;
    private RadioButton opt2;
    private RadioButton opt3;
    private RadioButton opt4;

    private Label lblName;

    private TextField tfName;

    private Integer quota;
    private Integer currentCal;
    private Integer difference;

    private ListView<String> listCons = new ListView();

    public static void main(String[] args) {
        menu = new WelcomeScreen();
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
        new IntialButtonLabelCreation(primaryStage).invoke();

        Label nutriLog = new Label("Nutri-Log V2.0");
        nutriLog.setStyle("-fx-font-size: 36px");
        Label nowWith = new Label("Now With A Graphical Interface!");
        nowWith.setStyle("-fx-font-size: 14px");

        hbButtons.getChildren().addAll(btnSubmit, btnClear, btnExit);

        GridPane vb = new GridPane();
        vb.setAlignment(Pos.CENTER);
        vb.add(nutriLog, 0,0);

        GridPane mb = new GridPane();
        mb.setAlignment(Pos.CENTER);
        mb.add(nowWith, 0,1);
        grid.add(vb, 0,0,2,2);
        grid.add(mb, 0, 2, 2,1);
        grid.add(lblName, 0, 8);
        grid.add(tfName, 1, 8);
        grid.add(hbButtons, 0, 10, 2, 1);
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
            if (menu.getCalQuota() == 0) {
                setCalQuota(primaryStage);
            } else {
                afterProfLoad(primaryStage);
            }
        }
    }

    private void setCalQuota(Stage s) {
        GridPane grid;
        QuotaSetup quotaSetup = new QuotaSetup().invoke();
        grid = quotaSetup.getGrid();
        HBox hb = quotaSetup.getHb();

        QuotaButton quotaButton = new QuotaButton(s, hb).invoke();
        TextField calQuota = quotaButton.getCalQuota();
        Label setQuote = quotaButton.getSetQuote();


        grid.add(setQuote, 0, 0);
        grid.add(calQuota, 1,0);
        grid.add(hb,0,2,2,1);
        Scene sc = new Scene(grid, 480, 720);
        s.setScene(sc);
        s.show();
    }

    private void quotaConfirm(TextField calQuota) {
        try {
            menu.setCalQuota(Integer.parseInt(calQuota.getText()));
            Alert conf = new Alert(Alert.AlertType.INFORMATION);
            conf.setTitle("Set Calorie Quota");
            conf.setContentText("You Have Set Your Caloric Quota To: " + calQuota.getText() + " Calories");
            conf.showAndWait();
        } catch (Exception exp) {
            Alert conf = new Alert(Alert.AlertType.WARNING);
            conf.setTitle("Invalid Response");
            conf.setContentText("Please Input Your Caloric Quota");
            conf.showAndWait();
        }
    }

    private void afterProfLoad(Stage primaryStage) {
        AfterProfileLoadGui afterProfileLoadGui = new AfterProfileLoadGui().invoke();
        GridPane bp = afterProfileLoadGui.getBp();
        AplSetup aplSetup = afterProfileLoadGui.getAplSetup();
        VBox vb = afterProfileLoadGui.getVb();
        HBox hb = afterProfileLoadGui.getHb();

        AfterProfLoadInteractions afterProfLoadInteractions = new AfterProfLoadInteractions(aplSetup).invoke();
        Label nutriLog = afterProfLoadInteractions.getNutriLog();
        Label mainMenu = afterProfLoadInteractions.getMainMenu();
        Scene scene = afterProfLoadInteractions.getScene();
        ToggleGroup mainTog = afterProfLoadInteractions.getMainTog();
        Button proceed = afterProfLoadInteractions.getProceed();

        hb.getChildren().addAll(proceed, btnExit);
        vb.getChildren().addAll(nutriLog, mainMenu, opt1, opt2, opt3, opt4, hb);
        proceed.setOnAction(b -> bigDecision(mainTog, primaryStage));
        bp.add(vb,1,1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void bigDecision(ToggleGroup mt, Stage primaryStage) {
        try {
            new BigDecisionOptions(mt, primaryStage).invoke();
        } catch (Exception exp) {
            Alert conf = new Alert(Alert.AlertType.WARNING);
            conf.setTitle("Invalid Selection");
            conf.setContentText("Please Select A Valid Option");
            conf.showAndWait();
        }
    }

    private void resetMessage() {
        menu.resetCalorieHistory();
        listCons.getItems().clear();
        Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
        conf.setTitle("Clear Caloric Consumption History");
        conf.setContentText("Caloric History Has Been Cleared");
        conf.showAndWait();
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

    private void mfInteraction(GridPane ecq, HBox ecqBttns, Stage primaryStage) {
        Label lblName = new Label("Enter Food Name:");
        TextField foodName = new TextField();
        Label lblCalories = new Label("Enter Food Calories:");
        TextField foodCalories = new TextField();

        new MakingFoodButtons(primaryStage, foodName, foodCalories).invoke();

        ecqBttns.getChildren().addAll(btnSubmit, btnClear, btnReturn, btnExit);
        ecq.add(lblName, 0, 0);
        ecq.add(foodName, 1, 0);
        ecq.add(lblCalories, 0, 1);
        ecq.add(foodCalories, 1, 1);
        ecq.add(ecqBttns, 0, 3, 2, 1);
    }

    private void msInteraction(GridPane ecq, HBox ecqBttns, Stage primaryStage) {
        Label lblName = new Label("Enter Supplement Name:");
        TextField supplementName = new TextField();

        new MakingSupplementButtons(primaryStage, supplementName).invoke();

        ecqBttns.getChildren().addAll(btnSubmit, btnClear, btnReturn, btnExit);
        ecq.add(lblName, 0, 0);
        ecq.add(supplementName, 1, 0);
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

    private class AplSetup {
        private GridPane bp;
        private VBox vb;
        private Scene scene;
        private ToggleGroup mainTog;
        private HBox hb;

        public AplSetup(GridPane bp) {
            this.bp = bp;
        }

        public VBox getVb() {
            return vb;
        }

        public HBox getHb() {
            return hb;
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
            hb = new HBox();
            hb.setSpacing(10);
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

    private class QuotaSetup {
        private GridPane grid;
        private HBox hb;

        public GridPane getGrid() {
            return grid;
        }

        public HBox getHb() {
            return hb;
        }

        public QuotaSetup invoke() {
            grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(12);
            hb = new HBox();
            hb.setSpacing(10);

            ColumnConstraints column1 = new ColumnConstraints();
            column1.setHalignment(HPos.RIGHT);
            grid.getColumnConstraints().add(column1);

            ColumnConstraints column2 = new ColumnConstraints();
            column2.setHalignment(HPos.LEFT);
            grid.getColumnConstraints().add(column2);
            return this;
        }
    }

    private class QuotaButton {
        private Stage stage;
        private HBox hb;
        private TextField calQuota;
        private Label setQuote;

        public QuotaButton(Stage stage, HBox hb) {
            this.stage = stage;
            this.hb = hb;
        }

        public TextField getCalQuota() {
            return calQuota;
        }

        public Label getSetQuote() {
            return setQuote;
        }

        public QuotaButton invoke() {
            Button proceed = new Button("Submit");
            calQuota = new TextField();
            setQuote = new Label("Enter Caloric Quota:");
            btnReturn = new Button("Return");
            btnReturn.setOnAction(b -> afterProfLoad(stage));
            proceed.setOnAction(b -> quotaConfirm(calQuota));
            btnClear = new Button("Clear");
            btnClear.setOnAction(b -> calQuota.clear());
            btnReturn.setStyle(buttonStyle);
            btnClear.setStyle(buttonStyle);
            proceed.setStyle(buttonStyle);
            hb.getChildren().addAll(proceed, btnClear, btnReturn);
            return this;
        }
    }

    private class IntialButtonLabelCreation {
        private Stage primaryStage;

        public IntialButtonLabelCreation(Stage primaryStage) {
            this.primaryStage = primaryStage;
        }

        public void invoke() {
            btnSubmit = new Button("Submit");
            btnSubmit.setOnAction(b -> profileExists(primaryStage));
            btnClear = new Button("Clear");
            btnClear.setOnAction(b -> tfName.clear());
            btnExit = new Button("Exit");
            btnExit.setOnAction(b -> System.exit(0));
            btnSubmit.setStyle(buttonStyle);
            btnExit.setStyle(buttonStyle);
            btnClear.setStyle(buttonStyle);

            lblName = new Label("User Profile Name:");
            tfName = new TextField();
        }
    }

    private class AfterProfileLoadGui {
        private GridPane bp;
        private AplSetup aplSetup;
        private VBox vb;
        private HBox hb;

        public GridPane getBp() {
            return bp;
        }

        public AplSetup getAplSetup() {
            return aplSetup;
        }

        public VBox getVb() {
            return vb;
        }

        public HBox getHb() {
            return hb;
        }

        public AfterProfileLoadGui invoke() {
            bp = new GridPane();
            aplSetup = new AplSetup(bp).invoke();
            vb = aplSetup.getVb();
            vb.setSpacing(22);
            hb = aplSetup.getHb();

            ColumnConstraints column1 = new ColumnConstraints();
            column1.setHalignment(HPos.RIGHT);
            bp.getColumnConstraints().add(column1);

            ColumnConstraints column2 = new ColumnConstraints();
            column2.setHalignment(HPos.LEFT);
            bp.getColumnConstraints().add(column2);
            return this;
        }
    }

    private class AfterProfLoadInteractions {
        private AplSetup aplSetup;
        private Label nutriLog;
        private Label mainMenu;
        private Scene scene;
        private ToggleGroup mainTog;
        private Button proceed;

        public AfterProfLoadInteractions(AplSetup aplSetup) {
            this.aplSetup = aplSetup;
        }

        public Label getNutriLog() {
            return nutriLog;
        }

        public Label getMainMenu() {
            return mainMenu;
        }

        public Scene getScene() {
            return scene;
        }

        public ToggleGroup getMainTog() {
            return mainTog;
        }

        public Button getProceed() {
            return proceed;
        }

        public AfterProfLoadInteractions invoke() {
            nutriLog = new Label("Nutri-Log V2.0");
            nutriLog.setStyle("-fx-font-size: 36px");
            mainMenu = new Label("Please Select From The Following:");

            scene = aplSetup.getScene();
            mainTog = aplSetup.getMainTog();
            proceed = new Button("Proceed");
            btnExit = new Button("Exit");
            btnExit.setOnAction(b -> LoadSaveProfile.savingProfile());
            btnExit.setStyle(buttonStyle);
            proceed.setStyle(buttonStyle);
            return this;
        }
    }

    private class BigDecisionOptions {
        private ToggleGroup mt;
        private Stage primaryStage;
        private RadioButton food;
        private RadioButton supplement;

        public BigDecisionOptions(ToggleGroup mt, Stage primaryStage) {
            this.mt = mt;
            this.primaryStage = primaryStage;
        }

        public void invoke() {
            if (mt.getSelectedToggle().equals(opt1)) {
                editCalQuota(primaryStage);
            }
            if (mt.getSelectedToggle().equals(opt2)) {
                whatToMake(primaryStage);
            }
            if (mt.getSelectedToggle().equals(opt3)) {
                getEditCurrentCalories(primaryStage);
            }
            if (mt.getSelectedToggle().equals(opt4)) {
                viewAllItems(primaryStage);
            }
        }

        private void whatToMake(Stage s) {
            ToMakeGuiSetup toMakeGuiSetup = new ToMakeGuiSetup().invoke();
            GridPane grid = toMakeGuiSetup.getGrid();
            VBox vb = toMakeGuiSetup.getVb();
            HBox hb = toMakeGuiSetup.getHb();

            Label choice = new WhatToButtons(s).invoke();

            vb.getChildren().addAll(food, supplement);
            hb.getChildren().addAll(btnSubmit, btnReturn);

            grid.add(choice, 0,0);
            grid.add(vb,0,1);
            grid.add(hb, 0,3,2,1);
            Scene sc = new Scene(grid, 480, 720);
            s.setScene(sc);
            s.show();
        }

        private void editCalQuota(Stage s) {
            GridPane grid;
            QuotaSetup quotaSetup = new QuotaSetup().invoke();
            grid = quotaSetup.getGrid();
            HBox hb = quotaSetup.getHb();

            Label currentQuota = new Label("Current Quota: " + menu.getCalQuota());
            QuotaButton quotaButton = new QuotaButton(s, hb).invoke();
            TextField calQuota = quotaButton.getCalQuota();
            Label setQuote = quotaButton.getSetQuote();

            grid.add(currentQuota, 0, 0);
            grid.add(setQuote, 0, 2);
            grid.add(calQuota, 1,2);
            grid.add(hb,0,4,2,1);
            Scene sc = new Scene(grid, 480, 720);
            s.setScene(sc);
            s.show();
        }

        private void makeFood(Stage primaryStage) {
            GridPane ecq = new GridPane();
            MakeFoodSetup makeFoodSetup = new MakeFoodSetup(ecq).invoke();
            HBox ecqBttns = makeFoodSetup.getEcqBttns();
            Scene ecqScene = makeFoodSetup.getEcqScene();

            mfInteraction(ecq, ecqBttns, primaryStage);
            primaryStage.setScene(ecqScene);
            primaryStage.show();
        }

        private void makeSupplement(Stage primaryStage) {
            GridPane ecq = new GridPane();
            MakeFoodSetup makeFoodSetup = new MakeFoodSetup(ecq).invoke();
            HBox ecqBttns = makeFoodSetup.getEcqBttns();
            Scene ecqScene = makeFoodSetup.getEcqScene();

            msInteraction(ecq, ecqBttns, primaryStage);
            primaryStage.setScene(ecqScene);
            primaryStage.show();
        }

        private void getEditCurrentCalories(Stage s) {
            EditCaloriesGuiSetup editCaloriesGuiSetup = new EditCaloriesGuiSetup().invoke();
            GridPane grid = editCaloriesGuiSetup.getGrid();
            HBox hb = editCaloriesGuiSetup.getHb();

            Label label = new Label("Your Current Calories Consumed: "
                    + menu.getCurrentCalories());
            btnReturn = new Button("Return");
            btnReturn.setOnAction(b -> afterProfLoad(s));
            btnReturn.setStyle(buttonStyle);
            Button btnReset = new Button("Reset");
            btnReset.setOnAction(b -> resetMessage());
            btnReset.setStyle(buttonStyle);
            hb.getChildren().addAll(btnReset, btnReturn);

            grid.add(label, 0,0);
            grid.add(hb, 0, 2, 2, 1);
            Scene sc = new Scene(grid, 480, 720);
            s.setScene(sc);
            s.show();
        }

        private void viewAllItems(Stage primaryStage) {
            ViewAllGuiSetup viewAllGuiSetup = new ViewAllGuiSetup().invoke();
            GridPane ecq = viewAllGuiSetup.getEcq();
            HBox hb = viewAllGuiSetup.getHb();
            Label foodEaten = viewAllGuiSetup.getFoodEaten();

            new ViewAllInteractions(primaryStage).invoke();

            hb.getChildren().addAll(btnReturn, btnExit);
            ecq.add(foodEaten, 0, 0);
            ecq.add(listCons, 0, 1);
            ecq.add(hb, 0, 2);
            Scene s = new Scene(ecq, 480, 720);
            primaryStage.setScene(s);
            primaryStage.show();
        }

        private class EditCaloriesGuiSetup {
            private GridPane grid;
            private HBox hb;

            public GridPane getGrid() {
                return grid;
            }

            public HBox getHb() {
                return hb;
            }

            public EditCaloriesGuiSetup invoke() {
                grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(12);
                hb = new HBox();
                hb.setSpacing(10);

                ColumnConstraints column1 = new ColumnConstraints();
                column1.setHalignment(HPos.RIGHT);
                grid.getColumnConstraints().add(column1);

                ColumnConstraints column2 = new ColumnConstraints();
                column2.setHalignment(HPos.LEFT);
                grid.getColumnConstraints().add(column2);
                return this;
            }
        }

        private class ViewAllGuiSetup {
            private GridPane ecq;
            private HBox hb;
            private Label foodEaten;

            public GridPane getEcq() {
                return ecq;
            }

            public HBox getHb() {
                return hb;
            }

            public Label getFoodEaten() {
                return foodEaten;
            }

            public ViewAllGuiSetup invoke() {
                ecq = new GridPane();
                hb = new HBox();
                foodEaten = new Label("Food Items Consumed + Caloric Fulfillment:");

                ecq.setAlignment(Pos.CENTER);
                ecq.setHgap(10);
                ecq.setVgap(12);
                hb.setSpacing(10.0);

                ColumnConstraints column1 = new ColumnConstraints();
                column1.setHalignment(HPos.RIGHT);
                ecq.getColumnConstraints().add(column1);

                ColumnConstraints column2 = new ColumnConstraints();
                column2.setHalignment(HPos.LEFT);
                ecq.getColumnConstraints().add(column2);
                return this;
            }
        }

        private class ViewAllInteractions {
            private Stage primaryStage;

            public ViewAllInteractions(Stage primaryStage) {
                this.primaryStage = primaryStage;
            }

            public void invoke() {
                listCons.getItems().clear();
                for (Consumable f : menu.getHistory()) {
                    listCons.getItems().add(f.getName() + " - " + f.getCalories() + " calorie(s)");
                }

                btnReturn = new Button("Return");
                btnReturn.setOnAction(b -> afterProfLoad(primaryStage));
                btnExit = new Button("Exit");
                btnExit.setOnAction(b -> LoadSaveProfile.savingProfile());
                btnReturn.setStyle(buttonStyle);
                btnExit.setStyle(buttonStyle);
            }
        }

        private class ToMakeGuiSetup {
            private GridPane grid;
            private VBox vb;
            private HBox hb;

            public GridPane getGrid() {
                return grid;
            }

            public VBox getVb() {
                return vb;
            }

            public HBox getHb() {
                return hb;
            }

            public ToMakeGuiSetup invoke() {
                grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setHgap(10);
                grid.setVgap(12);
                vb = new VBox();
                vb.setSpacing(20);
                hb = new HBox();
                hb.setSpacing(10);

                ColumnConstraints column1 = new ColumnConstraints();
                column1.setHalignment(HPos.RIGHT);
                grid.getColumnConstraints().add(column1);

                ColumnConstraints column2 = new ColumnConstraints();
                column2.setHalignment(HPos.LEFT);
                grid.getColumnConstraints().add(column2);
                return this;
            }
        }

        private class WhatToButtons {
            private Stage stage;

            public WhatToButtons(Stage s) {
                this.stage = s;
            }

            public Label invoke() {
                Label choice = new Label("Please Select Consumable Type:");
                ToggleGroup tg = new ToggleGroup();
                food = new RadioButton("Food");
                supplement = new RadioButton("Supplement");
                food.setToggleGroup(tg);
                supplement.setToggleGroup(tg);
                btnReturn = new Button("Return");
                btnReturn.setOnAction(b -> afterProfLoad(stage));
                btnReturn.setStyle(buttonStyle);
                btnSubmit = new Button("Submit");
                btnSubmit.setOnAction(b -> whichConsum(tg, stage));
                btnSubmit.setStyle(buttonStyle);
                return choice;
            }

            private void whichConsum(ToggleGroup tg, Stage s) {
                try {
                    if (tg.getSelectedToggle().equals(food)) {
                        makeFood(s);
                    }
                    if (tg.getSelectedToggle().equals(supplement)) {
                        makeSupplement(s);
                    }
                } catch (Exception exp) {
                    Alert conf = new Alert(Alert.AlertType.WARNING);
                    conf.setTitle("Invalid Selection");
                    conf.setContentText("Please Select A Valid Option");
                    conf.showAndWait();
                }
            }
        }
    }

    private class MakingFoodButtons {
        private Stage primaryStage;
        private TextField foodName;
        private TextField foodCalories;

        public MakingFoodButtons(Stage primaryStage, TextField foodName, TextField foodCalories) {
            this.primaryStage = primaryStage;
            this.foodName = foodName;
            this.foodCalories = foodCalories;
        }

        public void invoke() {
            btnSubmit = new Button("Submit");
            btnSubmit.setOnAction(b -> foodConfirmation(foodName, foodCalories));
            btnClear = new Button("Clear");
            btnClear.setOnAction(b -> clearFields(foodName, foodCalories));
            btnReturn = new Button("Return");
            btnReturn.setOnAction(b -> afterProfLoad(primaryStage));
            btnExit = new Button("Exit");
            btnExit.setOnAction(b -> LoadSaveProfile.savingProfile());
            btnReturn.setStyle(buttonStyle);
            btnExit.setStyle(buttonStyle);
            btnClear.setStyle(buttonStyle);
            btnSubmit.setStyle(buttonStyle);
        }

        private void foodConfirmation(TextField foodName, TextField foodCalories) {
            menu.addFood(foodName.getText(),
                    Integer.parseInt(foodCalories.getText()));
            quota = menu.getCalQuota();
            currentCal = menu.getCurrentCalories();
            if (currentCal > quota) {
                difference = currentCal - quota;
                Alert ohno = new Alert(Alert.AlertType.WARNING);
                ohno.setTitle("Consumption Over Caloric Quota");
                ohno.setContentText("You Have Exceeded Your Caloric Quota By: " + difference
                        + " Calories");
                ohno.showAndWait();
            }
            Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
            conf.setTitle("Food Confirmation");
            conf.setContentText("You Have Entered: " + "\n Item: " + foodName.getText()
                    + "\n Calories: " + foodCalories.getText());
            conf.showAndWait();
        }

        private void clearFields(TextField foodName, TextField foodCalories) {
            foodName.clear();
            foodCalories.clear();
        }
    }

    private class MakingSupplementButtons {
        private Stage primaryStage;
        private TextField supplementName;

        public MakingSupplementButtons(Stage primaryStage, TextField supplementName) {
            this.primaryStage = primaryStage;
            this.supplementName = supplementName;
        }

        public void invoke() {
            btnSubmit = new Button("Submit");
            btnSubmit.setOnAction(b -> supplementConfirmation(supplementName));
            btnClear = new Button("Clear");
            btnClear.setOnAction(b -> clearFields(supplementName));
            btnReturn = new Button("Return");
            btnReturn.setOnAction(b -> afterProfLoad(primaryStage));
            btnExit = new Button("Exit");
            btnExit.setOnAction(b -> LoadSaveProfile.savingProfile());
            btnReturn.setStyle(buttonStyle);
            btnExit.setStyle(buttonStyle);
            btnClear.setStyle(buttonStyle);
            btnSubmit.setStyle(buttonStyle);
        }

        private void supplementConfirmation(TextField supplementName) {
            menu.addSupplement(supplementName.getText());
            quota = menu.getCalQuota();
            currentCal = menu.getCurrentCalories();
            if (currentCal > quota) {
                difference = currentCal - quota;
                Alert ohno = new Alert(Alert.AlertType.WARNING);
                ohno.setTitle("Consumption Over Caloric Quota");
                ohno.setContentText("You Have Exceeded Your Caloric Quota By: " + difference
                        + " Calories");
                ohno.showAndWait();
            }
            Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
            conf.setTitle("Supplement Confirmation");
            conf.setContentText("You Have Entered: " + "\n Item: " + supplementName.getText());
            conf.showAndWait();
        }

        private void clearFields(TextField supplementName) {
            supplementName.clear();
        }
    }

}