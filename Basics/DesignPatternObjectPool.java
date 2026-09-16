import java.util.ArrayList;
import java.util.List;

class PooledConnection {

    private int connectionId;

    public PooledConnection(int connectionId) {
        this.connectionId = connectionId;
        System.out.println("Creating Connection " + connectionId);
    }

    public void use() {
        System.out.println("Using Connection " + connectionId);
    }

    public int getConnectionId() {
        return connectionId;
    }
}

class ConnectionPool {

    private List<PooledConnection> availableConnections;
    private List<PooledConnection> usedConnections;

    public ConnectionPool(int poolSize) {

        availableConnections = new ArrayList<>();
        usedConnections = new ArrayList<>();

        for (int i = 1; i <= poolSize; i++) {
            availableConnections.add(new PooledConnection(i));
        }
    }

    public PooledConnection getConnection() {

        if (availableConnections.isEmpty()) {
            System.out.println("No connection available.");
            return null;
        }

        PooledConnection connection =
                availableConnections.remove(0);

        usedConnections.add(connection);

        return connection;
    }

    public void releaseConnection(PooledConnection connection) {

        if (connection == null) {
            return;
        }

        usedConnections.remove(connection);
        availableConnections.add(connection);

        System.out.println(
                "Connection " + connection.getConnectionId()
                        + " returned to pool."
        );
    }
}

public class DesignPatternObjectPool {

    public static void main(String[] args) {

        ConnectionPool pool = new ConnectionPool(2);

        PooledConnection connection1 =
                pool.getConnection();

        connection1.use();

        PooledConnection connection2 =
                pool.getConnection();

        connection2.use();

        PooledConnection connection3 =
                pool.getConnection();

        if (connection3 == null) {
            System.out.println("Please wait for a connection.");
        }

        pool.releaseConnection(connection1);

        PooledConnection connection4 =
                pool.getConnection();

        connection4.use();
    }
}