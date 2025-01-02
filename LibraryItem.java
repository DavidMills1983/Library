public abstract class LibraryItem {

    private String title;
    private String id;
    private boolean available;

    abstract void makeAvailable();

    abstract void checkIfAvailable();

    abstract void getName();

    abstract void getID();

    abstract void displayDetails();


}
