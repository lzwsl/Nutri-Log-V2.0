package tests;

import model.Food;
import model.FoodItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.EatMore;
import ui.WelcomeScreen;
import user.CalCalc;
import user.CalTotal;
import user.SetCalQuota;

import java.io.Serializable;
import java.util.ArrayList;

public class WelcomeScreenTest implements Serializable {

    private WelcomeScreen ws;
    private CalCalc cc;
    private CalTotal ct;
    private EatMore em;
    private SetCalQuota scq;

    private ArrayList<Food> list;

    @BeforeEach
    public void beforeEachTest() {
        ws = new WelcomeScreen();
        cc = new CalCalc();
        ct = new CalTotal();
        em = new EatMore();
        scq = new SetCalQuota();
        list = new ArrayList<Food>();
    }

    @Test
    public void itemsAddingToListTest() {
        Food a = new FoodItem("a", 450);
        Food b = new FoodItem("b", 90);
        Food c = new FoodItem("c", 200);
        Food d = new FoodItem("add", 200);
        ct.totalCalories(d, list);
        list.add(a);
        list.add(b);
        list.add(c);
        for (int i = 0; i <= 3; i++){
            Food e = list.get(i);
            System.out.println(e);
        }
    }

    @Test
    public void sumOfListTest() {
        Food a = new FoodItem("a", 200);
        Food b = new FoodItem("b", 300);
        Food c = new FoodItem("c", 500);
        Food d = new FoodItem("d", 320);
        Food e = new FoodItem("add",200);
        ct.totalCalories(e, list);
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        System.out.println((1520 == ct.getCurrentCalories()));
    }

    @Test
    public void itemsAddNegToListTest() {
        Food a = new FoodItem("a", 100);
        Food b = new FoodItem("b", 20);
        Food c = new FoodItem("c", 450);
        Food d = new FoodItem("minus",-200);
        list.add(a);
        list.add(b);
        list.add(c);
        ct.totalCalories(d, list);
        System.out.println((330 == ct.getCurrentCalories()));
    }
}
