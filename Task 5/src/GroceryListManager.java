import java.util.ArrayList;

public class GroceryListManager {

    private ArrayList<String> groceryList = new ArrayList<>();
    private ArrayList<Double> itemCosts = new ArrayList<>();
    private ArrayList<String> itemCategories = new ArrayList<>();
    private ArrayList<Integer> itemQuantities = new ArrayList<>();

    public void addItem(String item, double cost, String category, int quantity) {
        groceryList.add(item);
        itemCosts.add(cost);
        itemCategories.add(category);
        itemQuantities.add(quantity);
    }

    public void removeItem(String item) {
        int itemIndex = groceryList.indexOf(item);

        if (itemIndex >= 0) {
            groceryList.remove(itemIndex);
            itemCosts.remove(itemIndex);
            itemCategories.remove(itemIndex);
            itemQuantities.remove(itemIndex);
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

        for (int i = 0; i < itemCosts.size(); i++) {
            totalCost = totalCost + itemCosts.get(i) * itemQuantities.get(i);
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

    public void updateQuantity(String item, int newQuantity) {
        int itemIndex = groceryList.indexOf(item);

        if (itemIndex >= 0) {
            itemQuantities.set(itemIndex, newQuantity);
        }
    }

    public void displayAvailableItems() {
        for (int i = 0; i < groceryList.size(); i++) {
            if (itemQuantities.get(i) > 0) {
                System.out.println(groceryList.get(i) + ": " + itemQuantities.get(i));
            }
        }
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples", 2.50, "Fruits", 2);
        manager.addItem("Milk", 1.50, "Dairy", 1);
        manager.addItem("Bread", 2.00, "Bakery", 3);

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
        manager.addItem("Banana", 3.0, "Fruits", 4);
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

        System.out.println();
        System.out.println("Available items:");
        manager.displayAvailableItems();

        System.out.println();
        manager.updateQuantity("Bread", 0);
        System.out.println("Updated Bread quantity to 0...");

        System.out.println();
        System.out.println("Available items:");
        manager.displayAvailableItems();

        System.out.println();
        System.out.println("Total cost after updating quantity: " + manager.calculateTotalCost());
    }
}
