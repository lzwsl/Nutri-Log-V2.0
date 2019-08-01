package ui;

import model.Consumable;

import java.io.Serializable;
import java.util.*;

public class CalTotal implements Serializable {
    private Integer calorieTotal;
    private transient Scanner scanner = new Scanner(System.in);

    //MODIFIES: this, Arraylist<Integer>
    //EFFECTS: calculates total calories consumed.
    public Integer totalCalories(Consumable f, ArrayList<Consumable> a) {
        a.add(f);
        Integer sum = 0;
        for (Consumable i: a) {
            sum = sum + i.getCalories();
        }
        calorieTotal = sum;
        return sum;
    }

    //EFFECTS: get total calories consumed.
    public Integer getCurrentCalories() {
        return calorieTotal;
    }

    //MODIFIES: this
    //EFFECTS: clears total calorie history if user decides
    public ArrayList<Consumable> clearCurrentCalories(ArrayList<Consumable> a, CalTotal totaCal) {
        System.out.println("Your Current Calories Consumed: " + totaCal.getCurrentCalories());
        System.out.println("Would You Like to Clear Current Calories? (yes/no)");
        if (scanner.nextLine().equals("yes")) {
            a.clear();
            calorieTotal = 0;
            Integer retVal = a.size();
            System.out.println("Calorie History is Cleared, Set To " + retVal + " Calories");
        } else {
            return a;
        }
        return a;
    }

    //EFFECTS: gets consumable foods
    public void getConsumableFoods(AllItems a, ArrayList al) {
        System.out.println("Your Most Recently Consumed Items:");
        a.allItems(al);
    }
}






//    private List<Consumable> consumables = new ArrayList<>();


//ORIGINAL CODE:
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        CalTotal calTotal = (CalTotal) o;
//        return calorieTotal.equals(calTotal.calorieTotal)
//                && scanner.equals(calTotal.scanner)
//                && consumables.equals(calTotal.consumables);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(calorieTotal, scanner, consumables);
//    }
//
//    public void addConsumable(Consumable c) {
//        if (!consumables.contains(c)) {
//            consumables.add(c);
//            c.addToCalTotal(this);
//        }
//    }
////EFFECTS: gets consumable foods
//public void getConsumableFoods(AllItems a, ArrayList al) {
//    System.out.println("Your Most Recently Consumed Food Items:");
//    for (Consumable f: this.consumables) {
//        System.out.println(f.getName());
//    }
//    System.out.println("");
//    System.out.println("Would You Like to Expand Details & Include Supplements? (yes/no)");
//    String choice = scanner.nextLine();
//    System.out.println("");
//    if (choice.equals("yes")) {
//        a.allItems(al);
//    }
//}
