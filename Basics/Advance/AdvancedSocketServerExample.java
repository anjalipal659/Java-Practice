
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdvancedSocketServerExample {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(5000)) {

            System.out.println("Server waiting for client...");

            try (Socket socket = server.accept();
                 BufferedReader input = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(
                         socket.getOutputStream(), true)) {

                System.out.println("Client connected.");

                String message = input.readLine();

                System.out.println("Client says: " + message);

                output.println("Hello from Java Server!");

            }

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
