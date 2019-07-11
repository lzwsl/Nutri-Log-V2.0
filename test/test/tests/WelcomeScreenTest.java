//package tests;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ui.EatMore;
//import ui.WelcomeScreen;
//import user.CalCalc;
//import user.CalTotal;
//import user.SetCalQuota;
//
//import java.util.ArrayList;
//
//public class WelcomeScreenTest {
//
//    private WelcomeScreen ws;
//    private CalCalc cc;
//    private CalTotal ct;
//    private EatMore em;
//    private SetCalQuota scq;
//
//    public ArrayList<Integer> list(){
//       ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(200);
//        list.add(300);
//        list.add(500);
//        return list;
//    }
//
//    @BeforeEach
//    public void beforeEachTest() {
//        ws = new WelcomeScreen();
//        cc = new CalCalc();
//        ct = new CalTotal();
//        em = new EatMore();
//        scq = new SetCalQuota();
//
//    }
//
//    @Test
//    public void totalCalorieslessthanQuota() {
//        Integer calTotal = ct.totalCalories(200, list());
//        Integer calquote = 1000;
//        Integer calQuota = scq.getCalorieQuota();
//        cc.ableToEat(calTotal, null, null, null);
//
//
//
//
//
//
//
//    }
//
//}
