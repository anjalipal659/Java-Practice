class DatabaseConnection {

    // Single object
    private static DatabaseConnection instance;

    // Private constructor
    private DatabaseConnection() {
        System.out.println("Database Connection Created");
    }

    // Get single instance
    public static DatabaseConnection getInstance() {

        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public void connect() {
        System.out.println("Connected to Database");
    }
}


public class DesignPatternSingleton {

    public static void main(String[] args) {

        DatabaseConnection connection1 =
                DatabaseConnection.getInstance();

        DatabaseConnection connection2 =
                DatabaseConnection.getInstance();

        connection1.connect();

        // Check whether both references point
        // to the same object
        System.out.println(
                "Same Object: "
                        + (connection1 == connection2)
        );
    }
}