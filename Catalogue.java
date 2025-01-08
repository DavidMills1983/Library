import java.util.List;

public class Catalogue {
    private final String name;
    private final List<LibraryItem> items;
    private final CatalogueService catalogueService;

    public Catalogue(String name) {
        this.name = name;
        this.items = CSVReader.getBooks();
        this.catalogueService = new CatalogueService(this);
    }

    public String getName() {
        return name;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public void addItem() {
        catalogueService.addItem();
    }

    public void deleteItem(String id) {
        catalogueService.deleteItem(id);
    }

    public LibraryItem searchItem(String title) {
        return catalogueService.searchItem(title);
    }

    public void displayAllItems() {
        catalogueService.displayAllItems();
    }

}


