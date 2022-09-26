import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(4000)) {

            while (true) {

                new Echoer(serverSocket.accept()).start();
                System.out.println("Client Connected");
            }
        }catch (IOException e)  {
            System.out.println("Server Exception: " + e.getMessage());
        }
    }
}
