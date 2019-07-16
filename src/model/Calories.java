package model;

public interface Calories {
    //MODIFIES: this
    //EFFECTS: sets the calories of the food item
    void setFoodCalories(Integer i);

    //EFFECTS: gets the calories of the food item
    Integer getFoodCalories();
}
