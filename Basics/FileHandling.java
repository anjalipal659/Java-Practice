import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) {

        String fileName = "practice.txt";

        // 1. Create file
        try {
            File file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }

        } catch (IOException e) {
            System.out.println("Error creating file");
        }


        // 2. Write into file
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("Hello, Java!\n");
            writer.write("This is my Java file handling practice.\n");
            writer.write("I am learning Java daily.");

            writer.close();

            System.out.println("Data written successfully");

        } catch (IOException e) {
            System.out.println("Error writing file");
        }


        // 3. Read from file
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            System.out.println("\nFile content:");

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file");
        }


        // 4. Append data
        try {
            FileWriter writer = new FileWriter(fileName, true);

            writer.write("\nNew line added using append.");

            writer.close();

            System.out.println("\nData appended successfully");

        } catch (IOException e) {
            System.out.println("Error appending file");
        }
    }
}