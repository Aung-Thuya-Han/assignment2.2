import java.util.HashMap;

public class GroceryListManager {

    private HashMap<String, Double> groceryList = new HashMap<>();
    private HashMap<String, String> itemCategories = new HashMap<>();

    public void addItem(String item, double cost, String category) {
        groceryList.put(item, cost);
        itemCategories.put(item, category);
    }

    public void removeItem(String item) {
        groceryList.remove(item);
        itemCategories.remove(item);
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

    public void displayByCategory(String category) {
        System.out.println(category + ":");

        for (String item : itemCategories.keySet()) {
            if (itemCategories.get(item).equals(category)) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 2.50, "Fruits");
        manager.addItem("Milk", 1.50, "Dairy");
        manager.addItem("Bread", 2.00, "Bakery");

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
        manager.addItem("Banana", 3.0, "Fruits");
        System.out.println("Added \"Banana\" to the list...");

        System.out.println();
        System.out.println("Updated Grocery List:");
        manager.displayList();

        System.out.println();
        System.out.println("Total cost: " + manager.calculateTotalCost());

        System.out.println();
        manager.displayByCategory("Fruits");

        System.out.println();
        manager.displayByCategory("Bakery");
    }
}
