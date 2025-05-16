public class Main {
    public static void main(String[] args) {
        // 1. Create CSVReader and import data
        CSVReader reader = new CSVReader("iris.csv");
        reader.importData();

        System.out.println("Imported " + reader.getNumberOfEntries() + " entries.");
        System.out.println("Example entry: " + reader.getEntry(0));

        // 2. Serialize the CSVReader object
        String fileName = "iris_data.ser";
        SaveRestoreObjFromFile.saveToFile(fileName, reader);

        // 3. Deserialize the CSVReader object
        CSVReader restoredReader = (CSVReader) SaveRestoreObjFromFile.restoreFromFile(fileName);

        // 4. Check if restoration was successful
        if (restoredReader != null) {
            System.out.println("Restored " + restoredReader.getNumberOfEntries() + " entries.");
            System.out.println("Restored example entry: " + restoredReader.getEntry(0));
        } else {
            System.out.println("Failed to restore CSVReader object.");
        }
    }
}
