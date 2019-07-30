package model;

import ui.CalTotal;

import java.io.Serializable;

public abstract class Consumable implements Serializable, Item, Calories {

    protected String name;
    protected Integer calories;
    private CalTotal calTotals;

    //MODIFIES: this
    //EFFECTS: creates new consumable with name and calories
    public Consumable(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    //MODIFIES: this
    //EFFECTS: sets the name of the consumable item
    public void setName(String s) {
        this.name = s;
    }

    //EFFECTS: gets the name of the consumable item
    public String getName() {
        return this.name;
    }

    //MODIFIES: this
    //EFFECTS: sets the calories of the consumable item
    public abstract void setCalories(Integer i);

    //EFFECTS: gets the calories of the consumable item
    public Integer getCalories() {
        return this.calories;
    }

    public void addToCalTotal(CalTotal c) {
        if (calTotals != c) {
            calTotals = c;
            calTotals.addConsumable(this);
        }
    }
}
