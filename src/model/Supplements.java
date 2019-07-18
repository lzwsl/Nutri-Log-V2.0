package model;

public class Supplements extends Consumable {

    public Supplements(String name, Integer calories) {
        super(name, calories);
    }

    //MODIFIES: this
    //EFFECTS: sets the name of the consumable item
    @Override
    public void setName(String s) {
        this.name = s + " [supplement]";
    }

    //MODIFIES: this
    //EFFECTS: sets the calories of the supplemental item
    public void setCalories(Integer i) {
        this.calories = 0;
    }
}
