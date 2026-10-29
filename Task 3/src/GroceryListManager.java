import java.util.ArrayList;

public class GroceryListManager {

    private ArrayList<String> groceryList = new ArrayList<>();
    private ArrayList<Double> itemCosts = new ArrayList<>();
    private ArrayList<String> itemCategories = new ArrayList<>();

    public void addItem(String item, double cost, String category) {
        groceryList.add(item);
        itemCosts.add(cost);
        itemCategories.add(category);
    }

    public void removeItem(String item) {
        int itemIndex = groceryList.indexOf(item);

        if (itemIndex >= 0) {
            groceryList.remove(itemIndex);
            itemCosts.remove(itemIndex);
            itemCategories.remove(itemIndex);
        }
    }

    public void displayList() {
        int itemNumber = 1;

        for (String item : groceryList) {
            System.out.println(itemNumber + ". " + item);
            itemNumber++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0;

        for (double cost : itemCosts) {
            totalCost = totalCost + cost;
        }

        return totalCost;
    }

    public void displayByCategory(String category) {
        System.out.println(category + ":");

        for (int i = 0; i < groceryList.size(); i++) {
            if (itemCategories.get(i).equals(category)) {
                System.out.println(groceryList.get(i));
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
