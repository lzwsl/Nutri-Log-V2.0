package tests;

import model.Consumable;
import model.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.CalTotal;

import java.io.Serializable;
import java.util.ArrayList;

public class CalorieCalculationTest implements Serializable {

    private CalTotal ct;
    private ArrayList<Consumable> list;

    @BeforeEach
    public void beforeEachTest() {
        ct = new CalTotal();
        list = new ArrayList<>();
    }

    @Test
    public void itemsAddingToListTest() {
        Food a = new Food("a", 450);
        Food b = new Food("b", 90);
        Food c = new Food("c", 200);
        Food d = new Food("add", 200);
        ct.totalCalories(d, list);
        list.add(a);
        list.add(b);
        list.add(c);
        for (int i = 0; i <= 3; i++){
            Consumable e = list.get(i);
            System.out.println(e);
        }
    }

    @Test
    public void sumOfListTest() {
        Food a = new Food("a", 200);
        Food b = new Food("b", 300);
        Food c = new Food("c", 500);
        Food d = new Food("d", 320);
        Food e = new Food("add",200);
        ct.totalCalories(e, list);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        System.out.println((1520 == ct.getCurrentCalories()));
    }

    @Test
    public void itemsAddNegToListTest() {
        Food a = new Food("a", 100);
        Food b = new Food("b", 20);
        Food c = new Food("c", 450);
        Food d = new Food("minus",-200);
        list.add(a);
        list.add(b);
        list.add(c);
        ct.totalCalories(d, list);
        System.out.println((330 == ct.getCurrentCalories()));
    }

    
}
