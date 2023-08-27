import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int port = 8086;

        while (true) {

            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("New connection accepted.");

                out.println("1. Write your name.");

                String name = in.readLine();
                System.out.println(name);

                out.printf("2. Hi %s, your port is %d. \nAre you child? (yes/no)\n", name, clientSocket.getPort());

                String answer = in.readLine();
                System.out.println(answer);

                if (answer.equals("yes")) {
                    out.println("3. Welcome to the kids area, " + name + "! Let's play!");
                } else {
                    out.println("3. Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                }

                String answer2 = in.readLine();
                System.out.println(answer2);

                out.println("4. Where are you from?");

                String city = in.readLine();
                System.out.println(city);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
