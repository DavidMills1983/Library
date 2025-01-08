public abstract class LibraryItem {

    private final String title;
    private final String id;
    private boolean available;

    public LibraryItem(String title, String id) {
        this.title = title;
        this.id = id;
        this.available = true;
    }

    void makeAvailable(){
        this.available = true;
    }

    String checkIfAvailable() {
        if (available) return "Available";
        else return "Not available";
    }


    String getID() {
        return id;
    }

    String getTitle() {
        return title;
    }

    void displayDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String available = checkIfAvailable();
        return ("Title: " + title + ", id: " + id + ", " + available);
    }
}
