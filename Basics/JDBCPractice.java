import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCPractice {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_practice";
        String username = "root";
        String password = "your_password";

        try {
            // 1. Establish connection
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");

            // 2. Create statement
            Statement statement = connection.createStatement();

            // 3. Create table
            String createTable =
                    "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "marks INT)";

            statement.executeUpdate(createTable);

            System.out.println("Table ready!");

            // 4. Insert data
            String insertData =
                    "INSERT INTO students (name, marks) " +
                    "VALUES ('Anjali', 85)";

            statement.executeUpdate(insertData);

            System.out.println("Data inserted!");

            // 5. Read data
            String query = "SELECT * FROM students";

            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("\nStudents:");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int marks = resultSet.getInt("marks");

                System.out.println(
                        id + " | " + name + " | " + marks
                );
            }

            // 6. Close connection
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("\nConnection closed.");

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}