import java.util.List;

public class Catalogue {
    private String name;
    private List<LibraryItem> items;
    private CatalogueService catalogueService;


    void getItem() {
        catalogueService.getItem();
    }

    void addItem() {
        catalogueService.addItem();
    }

    void deleteItem() {
        catalogueService.deleteItem();
    }

    void searchItem() {
        catalogueService.searchItem();
    }

    void displayAllItems() {
        catalogueService.displayAllItems();
    }

}


