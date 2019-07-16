package model;

public interface Item {
    //MODIFIES: this
    //EFFECTS: sets the name of the food item
    void setName(String s);

    //EFFECTS: gets the name of the food item
    String getName();
}
