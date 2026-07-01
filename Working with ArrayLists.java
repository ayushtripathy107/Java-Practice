import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        
        // Add items
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        // Loop through the ArrayList
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
