package model;

public interface Food {
    //MODIFIES: this
    //EFFECTS: sets the name of the food item
    void setFoodName(String s);

    //EFFECTS: gets the name of the food item
    String getFoodName();

    //MODIFIES: this
    //EFFECTS: sets the calories of the food item
    void setFoodCalories(Integer i);

    //EFFECTS: gets the calories of the food item
    Integer getFoodCalories();
}
