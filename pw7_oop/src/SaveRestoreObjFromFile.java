import java.io.*;

public class SaveRestoreObjFromFile {

    // Saves any Serializable object to a file
    public static void saveToFile(String outputFile, Object object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(object); // Serialize the object
            System.out.println("Object saved to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error during saving: " + e.getMessage());
        }
    }

    // Restores a Serializable object from a file
    public static Object restoreFromFile(String inputFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile))) {
            Object obj = ois.readObject(); // Deserialize the object
            System.out.println("Object restored from " + inputFile);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during restoring: " + e.getMessage());
            return null;
        }
    }
}
