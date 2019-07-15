package tests;

import model.Food;
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
    public void itemsAddingtoListtest() {
        Food a = new Food("a", 450);
        Food b = new Food("b", 90);
        Food c = new Food("c", 200);
        Food d = new Food("add", 200);
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
    public void sumOfListtest() {
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
    public void itemsAddNegtoListtest() {
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

//    @Test
//    public void itemsAddEmptyListtest() {
//        list.add(350);
//        System.out.println((350 == ct.getCurrentCalories()));
//    }
//
//    @Test
//    public void sumOfEmptytest() {
//        System.out.println((0 == ct.getCurrentCalories()));
//    }

}
