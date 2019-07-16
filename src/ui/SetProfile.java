package ui;

public interface SetProfile {
    //MODIFIES: this
    //EFFECTS: reads user inputted name and returns input name
    String SetProfile();

    //EFFECTS: returns profile name
    String getProfile();
}
