package tests;

import model.Consumable;
import model.Supplements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SupplementsCreationTest {

    @Test
    public void createNewSupplementFromConsumable() {
        Consumable test = new Supplements("omega3", 0);
        assertTrue(test.getCalories().equals(0));
        assertFalse(test.getCalories().equals(123));
        assertTrue(test.getName().equals("omega3"));
    }

    @Test
    public void createNewSupplementOfSupplement() {
        Supplements test1 = new Supplements("vitaminC", 0);
        assertTrue(test1.getName().equals("vitaminC"));
        assertEquals(test1.getCalories(),0);
    }

    @Test
    public void editCaloriesSupplementOfSupplement() {
        Supplements test1 = new Supplements("vitaminC", 0);
        assertTrue(test1.getName().equals("vitaminC"));
        assertEquals(test1.getCalories(),0);
        test1.setCalories(123);
        assertFalse(test1.getCalories().equals(123));
        assertEquals(test1.getCalories(),0);
    }

    @Test
    public void editNameSupplementOfSupplement() {
        Supplements test1 = new Supplements("vitaminC", 0);
        assertTrue(test1.getName().equals("vitaminC"));
        assertEquals(test1.getCalories(),0);
        test1.setName("vitaminD");
        assertEquals(test1.getName(), "vitaminD [supplement]");
    }


}
