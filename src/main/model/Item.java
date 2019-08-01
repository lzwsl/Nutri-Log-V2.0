package model;

public interface Item {

    //MODIFIES: this
    //EFFECTS: sets the name of the item
    void setName(String s);

    //EFFECTS: gets the name of the item
    String getName();
}
