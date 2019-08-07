package model;

public class Food extends Consumable {

    public Food(String name, Integer calories) {
        super(name, calories);
    }

    //MODIFIES: this
    //EFFECTS: sets the calories of the food item
    public void setCalories(Integer i) {
        this.calories = i;
    }

}
