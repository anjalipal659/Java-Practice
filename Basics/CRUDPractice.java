import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUDPractice {

    static String url = "jdbc:mysql://localhost:3306/java_practice";
    static String username = "root";
    static String password = "your_password";

    public static void main(String[] args) {

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database connected!");

            // CREATE
            String insertQuery =
                    "INSERT INTO students (name, marks) VALUES (?, ?)";

            PreparedStatement insert =
                    connection.prepareStatement(insertQuery);

            insert.setString(1, "Priya");
            insert.setInt(2, 88);

            insert.executeUpdate();

            System.out.println("Student added successfully.");


            // READ
            String selectQuery =
                    "SELECT * FROM students";

            PreparedStatement select =
                    connection.prepareStatement(selectQuery);

            ResultSet result = select.executeQuery();

            System.out.println("\n--- Students ---");

            while (result.next()) {

                int id = result.getInt("id");
                String name = result.getString("name");
                int marks = result.getInt("marks");

                System.out.println(
                        id + " | " + name + " | " + marks
                );
            }


            // UPDATE
            String updateQuery =
                    "UPDATE students SET marks = ? WHERE name = ?";

            PreparedStatement update =
                    connection.prepareStatement(updateQuery);

            update.setInt(1, 95);
            update.setString(2, "Priya");

            update.executeUpdate();

            System.out.println("\nStudent updated successfully.");


            // DELETE
            String deleteQuery =
                    "DELETE FROM students WHERE name = ?";

            PreparedStatement delete =
                    connection.prepareStatement(deleteQuery);

            delete.setString(1, "Priya");

            delete.executeUpdate();

            System.out.println("Student deleted successfully.");


            // Close resources
            result.close();
            insert.close();
            select.close();
            update.close();
            delete.close();
            connection.close();

            System.out.println("\nConnection closed.");

        } catch (Exception e) {

            System.out.println(
                    "Database Error: " + e.getMessage()
            );
        }
    }
}