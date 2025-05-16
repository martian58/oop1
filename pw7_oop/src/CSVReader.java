import java.io.*;
import java.util.ArrayList;

public class CSVReader implements Serializable {
    private String filename;
    private ArrayList<ArrayList<String>> entries;

    // Constructor takes the file name and initializes the entries list
    public CSVReader(String filename) {
        this.filename = filename;
        this.entries = new ArrayList<>();
    }

    // Method to import data from the CSV file
    public void importData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean skipHeader = true;

            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false; // Skip the first header line
                    continue;
                }

                // Split line using regex to handle quoted strings with commas
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // Create a list for this entry and add cleaned values
                ArrayList<String> entry = new ArrayList<>();
                for (String value : values) {
                    entry.add(value.replace("\"", "").trim()); // remove quotes and whitespace
                }

                // Add the entry to the main list
                entries.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Returns the number of entries (rows) imported
    public int getNumberOfEntries() {
        return entries.size();
    }

    // Returns the entry (row) at the given index
    public ArrayList<String> getEntry(int i) {
        if (i >= 0 && i < entries.size()) {
            return entries.get(i);
        } else {
            throw new IndexOutOfBoundsException("Invalid entry index: " + i);
        }
    }

    // Example main method for testing
    public static void main(String[] args) {
        // Create reader and import data
        CSVReader reader = new CSVReader("iris.csv");
        reader.importData();

        // Print number of entries
        System.out.println("Number of entries: " + reader.getNumberOfEntries());

        // Print first entry
        System.out.println("First entry: " + reader.getEntry(0));
    }
}
