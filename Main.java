//Description: Build a system to manage books in a library. Users can add books, issue them, return them, or view available books.
//Key Learning Points:
//OOP concepts: Classes (e.g., Book, Library), inheritance, and encapsulation.
//Use of HashMap or ArrayList to store data.
//Challenge: Add a search functionality to find books by title or author.


import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<LibraryItem> csv = CSVReader.readBooks("books.csv");


        WriteArray.writeArrayToFile("contents.txt", csv);


//
//
//        Catalogue catalogue = new Catalogue("Library catalogue");



    }
}