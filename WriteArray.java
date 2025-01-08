import java.io.*;
import java.util.List;

public class WriteArray {

    public static void writeArrayToFile(String fileName, List<LibraryItem> books) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (LibraryItem element : books) {
                pw.println(element);
            }

            pw.close();

        }
        catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();

        }


    }
}
