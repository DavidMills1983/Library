import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogueService {
    private final Catalogue catalogue;

    public CatalogueService(Catalogue catalogue) {
        this.catalogue = catalogue;

    }

    public void getItem(LibraryItem item) {
        item.displayDetails();
    }

    public void addItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of item: ");
        String newTitle = input.next();
        System.out.println("Enter the name of the author: ");
        String newAuthor = input.next();
        String itemID = Integer.toString(getNumberOfItems() + 1) ;
        LibraryItem newLibraryItem = new Book(newAuthor, newTitle, itemID);



    }

    public void deleteItem(String id) {
        List<LibraryItem> items = catalogue.getItems();
        items.removeIf(item -> item.getID().equals(id));
        System.out.println("Item with ID: " + id + " removed.");
    }

    public LibraryItem searchItem(String title) {
        for (LibraryItem item : catalogue.getItems()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Title found: " + item.getTitle());
                item.displayDetails();
                return item;
            }

        }
        System.out.println("Title not found.");
        return null;
    }

    public void displayAllItems() {
        for (LibraryItem item : catalogue.getItems()){
            System.out.println(item);
        }

    }

    int getNumberOfItems() {
        return catalogue.getItems().size();
    }

    private ArrayList<LibraryItem> getAllItems() {
        return new ArrayList<>(catalogue.getItems());
    }

}
