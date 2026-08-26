import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementPractice {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_practice";
        String username = "root";
        String password = "your_password";

        try {
            // 1. Create connection
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database connected!");

            // 2. Insert data using PreparedStatement
            String insertQuery =
                    "INSERT INTO students (name, marks) VALUES (?, ?)";

            PreparedStatement insertStatement =
                    connection.prepareStatement(insertQuery);

            insertStatement.setString(1, "Rahul");
            insertStatement.setInt(2, 78);

            insertStatement.executeUpdate();

            System.out.println("Student inserted!");

            // 3. Read students with marks greater than given value
            String selectQuery =
                    "SELECT * FROM students WHERE marks > ?";

            PreparedStatement selectStatement =
                    connection.prepareStatement(selectQuery);

            selectStatement.setInt(1, 80);

            ResultSet resultSet =
                    selectStatement.executeQuery();

            System.out.println("\nStudents with marks > 80:");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int marks = resultSet.getInt("marks");

                System.out.println(
                        id + " | " + name + " | " + marks
                );
            }

            // 4. Update student
            String updateQuery =
                    "UPDATE students SET marks = ? WHERE name = ?";

            PreparedStatement updateStatement =
                    connection.prepareStatement(updateQuery);

            updateStatement.setInt(1, 90);
            updateStatement.setString(2, "Rahul");

            updateStatement.executeUpdate();

            System.out.println("\nStudent marks updated!");

            // 5. Close resources
            resultSet.close();
            selectStatement.close();
            insertStatement.close();
            updateStatement.close();
            connection.close();

            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}