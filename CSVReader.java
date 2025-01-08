import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {


    public static List<LibraryItem> readBooks(String csvFile) {
        List<LibraryItem> books = new ArrayList<>();
        String delimiter = ",";

        try {
            File file = new File(csvFile);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";
            int id = 0;

            boolean isFirstLine = true; // Skip the header row

            while ((line = br.readLine()) != null) {
                // Skip header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // Split the line into title and author
                String[] fields = parseCSVLine(line);
                if (fields.length == 2) {
                    id++;
                    String bookID = Integer.toString(id);
                    String title = fields[0];
                    String author = fields[1];
                    books.add(new Book(author, title, bookID));
                }

            }
            br.close();
        } catch (IOException ioe) {
            System.out.println("Error reading the file: " + ioe.getMessage());
            ioe.printStackTrace();
        }

        return books;
    }

    private static String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes; // Toggle the inQuotes flag
            } else if (c == ',' && !inQuotes) {
                // If we hit a comma outside quotes, split the field
                result.add(sb.toString().trim());
                sb.setLength(0); // Clear the StringBuilder
            } else {
                sb.append(c); // Append the character to the current field
            }
        }

        // Add the last field
        result.add(sb.toString().trim());

        // Convert the result to an array
        return result.toArray(new String[0]);
    }


    public static List<LibraryItem> getBooks() {
        return readBooks("books.csv");
    }

    // Add a new book to the CSV file
    public static void addBookToCSV(String csvFile, String title, String author) {
        try (FileWriter fw = new FileWriter(csvFile, true); // Open in append mode
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            // Format the title and author correctly, adding quotes if needed
            String formattedTitle = formatCSVField(title);
            String formattedAuthor = formatCSVField(author);

            // Write the new book as a new line
            pw.println(formattedTitle + "," + formattedAuthor);
            System.out.println("Book added successfully: " + title + " by " + author);

        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method to format fields for CSV (add quotes if necessary)
    private static String formatCSVField(String field) {
        // Add quotes if the field contains a comma or quotes
        if (field.contains(",") || field.contains("\"")) {
            field = field.replace("\"", "\"\""); // Escape quotes
            return "\"" + field + "\"";
        }
        return field;
    }

    }


