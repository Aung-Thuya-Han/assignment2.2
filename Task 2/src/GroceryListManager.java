import java.util.ArrayList;

public class GroceryListManager {

    private ArrayList<String> groceryList = new ArrayList<>();
    private ArrayList<Double> itemCosts = new ArrayList<>();

    public void addItem(String item, double cost) {
        groceryList.add(item);
        itemCosts.add(cost);
    }

    public void removeItem(String item) {
        int itemIndex = groceryList.indexOf(item);

        if (itemIndex >= 0) {
            groceryList.remove(itemIndex);
            itemCosts.remove(itemIndex);
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
