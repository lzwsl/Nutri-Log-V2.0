package ui;

import java.util.Observable;
import java.util.Observer;

public class ListAdder implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Item Added to History: " + arg);
    }
}
