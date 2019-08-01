package tests;

import model.Consumable;
import model.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FoodCreationTest {


    @Test
    public void declareConsumableActualFoodCreate() {
        Consumable test = new Food("apple", 123);
        assertFalse(test.getName().equals("pear"));
        assertTrue(test.getName().equals("apple"));
        assertTrue(test.getCalories().equals(123));
    }

    @Test
    public void editDeclareConsumableActualFoodCreateName() {
        Consumable test = new Food("apple", 123);
        assertFalse(test.getName().equals("pear"));
        assertTrue(test.getName().equals("apple"));
        test.setName("pear");
        assertTrue(test.getName().equals("pear"));
        assertTrue(test.getCalories().equals(123));
    }

    @Test
    public void declareFoodActualFoodCreate() {
        Food test1 = new Food("pear", 321);
        assertTrue(test1.getName().equals("pear"));
        assertTrue(test1.getCalories().equals(321));
    }

    @Test
    public void editCaloriesDeclareFoodActualFoodCreate() {
        Food test1 = new Food("pear", 321);
        assertTrue(test1.getName().equals("pear"));
        assertTrue(test1.getCalories().equals(321));
        test1.setCalories(123);
        assertTrue(test1.getCalories().equals(123));
    }


}
