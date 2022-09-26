import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class User {

    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost", 6000))  {

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            while (true)    {

                System.out.print("Enter message: ");
                String message = sc.nextLine();
                System.out.println();
                output.println(message);
                if (message.equals("exit")) {
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
            }
            sc.close();
        }catch (IOException e)  {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
