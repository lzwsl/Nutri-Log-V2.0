package model;

import java.io.Serializable;

public class Food implements Serializable {

    private String name;
    private Integer calories;

    public Food(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public void setFoodName(String s) {
        this.name = s;
    }

    public String getFoodName() {
        return this.name;
    }

    public void setFoodCalories(Integer i) {
        this.calories = i;
    }

    public Integer getFoodCalories() {
        return this.calories;
    }
}
