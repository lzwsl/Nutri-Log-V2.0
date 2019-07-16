package model;

import java.io.Serializable;

public class Food implements Serializable, Item, Calories {

    private String name;
    private Integer calories;

    //MODIFIES: this
    //EFFECTS: creates new food with name and calories
    public Food(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    //MODIFIES: this
    //EFFECTS: sets the name of the food item
    @Override
    public void setName(String s) {
        this.name = s;
    }

    //EFFECTS: gets the name of the food item
    @Override
    public String getName() {
        return this.name;
    }

    //MODIFIES: this
    //EFFECTS: sets the calories of the food item
    @Override
    public void setCalories(Integer i) {
        this.calories = i;
    }

    //EFFECTS: gets the calories of the food item
    @Override
    public Integer getCalories() {
        return this.calories;
    }
}
