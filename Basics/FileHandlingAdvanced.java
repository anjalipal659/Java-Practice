import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandlingAdvanced {

    public static void main(String[] args) {

        String fileName = "practice.txt";

        // 1. Create file
        try {
            File file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("Error creating file: "
                    + e.getMessage());
        }


        // 2. Write into file
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("Java File Handling Practice\n");
            writer.write("Learning Advanced Java\n");
            writer.write("File handling is important.");

            writer.close();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: "
                    + e.getMessage());
        }


        // 3. Read file
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader =
                    new BufferedReader(reader);

            String line;

            System.out.println("\nFile Content:");

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: "
                    + e.getMessage());
        }


        // 4. Append data
        try {
            FileWriter writer =
                    new FileWriter(fileName, true);

            writer.write("\nThis line is appended.");

            writer.close();

            System.out.println("\nData appended successfully!");

        } catch (IOException e) {
            System.out.println("Error appending data: "
                    + e.getMessage());
        }


        // 5. File information
        File file = new File(fileName);

        System.out.println("\nFile Information:");
        System.out.println("Name: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("Exists: " + file.exists());


        // 6. Delete file
        // Uncomment when you want to delete it.

        /*
        if (file.delete()) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("File could not be deleted.");
        }
        */
    }
}