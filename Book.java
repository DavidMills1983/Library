public class Book extends LibraryItem {

    private String author;
    private String genre;

    public Book(String author, String title, String id) {
        super(title, id);
        this.author = author;
    }

    public Book(String author, String title, String id, String genre) {
        super(title, id);
        this.author = author;
        this.genre = genre;
    }

    String getAuthor(){
        return this.author;
    }

    @Override
    public String toString() {
        String available = checkIfAvailable();
        return ("Title: " + getTitle() + ", Author: " + getAuthor() + ", id: " + getID() + ", " + available);
    }
}


