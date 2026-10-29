import java.util.HashMap;

public class GroceryListManager {

    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        groceryList.put(item, cost);
    }

    public void removeItem(String item) {
        groceryList.remove(item);
    }

    public void displayList() {
        int itemNumber = 1;

        for (String item : groceryList.keySet()) {
            System.out.println(itemNumber + ". " + item);
            itemNumber++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0;

        for (double cost : groceryList.values()) {
            totalCost = totalCost + cost;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 2.50);
        manager.addItem("Milk", 1.50);
        manager.addItem("Bread", 2.00);

        System.out.println("Grocery List:");
        manager.displayList();

        System.out.println();
        System.out.println("Total cost: " + manager.calculateTotalCost());

        System.out.println();
        System.out.println("Is \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        System.out.println();
        System.out.println("Removing \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println();
        manager.addItem("Banana", 3.0);
        System.out.println("Added \"Banana\" to the list...");

        System.out.println();
        System.out.println("Updated Grocery List:");
        manager.displayList();

        System.out.println();
        System.out.println("Total cost: " + manager.calculateTotalCost());
    }
}
