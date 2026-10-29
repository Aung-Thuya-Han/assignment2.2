import java.util.ArrayList;

public class GroceryListManager {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        groceryList.add(item);
    }

    public void removeItem(String item) {
        groceryList.remove(item);
    }

    public void displayList() {
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");

        System.out.println("Grocery List:");
        manager.displayList();

        System.out.println();
        System.out.println("Is \"Milk\" in the grocery list? " + manager.checkItem("Milk"));

        System.out.println();
        System.out.println("Removing \"Milk\" from the list...");
        manager.removeItem("Milk");

        System.out.println();
        System.out.println("Updated Grocery List:");
        manager.displayList();
    }
}
