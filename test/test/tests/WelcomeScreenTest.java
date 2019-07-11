package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.EatMore;
import ui.WelcomeScreen;
import user.CalCalc;
import user.CalTotal;
import user.SetCalQuota;

import java.util.ArrayList;

public class WelcomeScreenTest {

    private WelcomeScreen ws;
    private CalCalc cc;
    private CalTotal ct;
    private EatMore em;
    private SetCalQuota scq;

    private ArrayList<Integer> list;

    @BeforeEach
    public void beforeEachTest() {
        ws = new WelcomeScreen();
        cc = new CalCalc();
        ct = new CalTotal();
        em = new EatMore();
        scq = new SetCalQuota();
        list = new ArrayList<Integer>();
    }

    @Test
    public void itemsAddingtoListtest() {
        ct.totalCalories(200, list);
        list.add(450);
        list.add(90);
        list.add(200);
        for (int i = 0; i <= 3; i++){
            Integer a = list.get(i);
            System.out.println(a);
        }
    }

    @Test
    public void sumOfListtest() {
        ct.totalCalories(200, list);
        list.add(200);
        list.add(300);
        list.add(500);
        list.add(320);
        System.out.println((1520 == ct.getCurrentCalories()));
    }

    @Test
    public void itemsAddNegtoListtest() {
        list.add(100);
        list.add(20);
        list.add(450);
        ct.totalCalories(-200, list);
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
