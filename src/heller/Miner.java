package heller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Miner {

    public void connect(int port, String name)   {

        try(Socket socket = new Socket("localhost", port))  {

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println(name);
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
