import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {

    public static void main(String [ ] args) throws IOException {

        String host = "127.0.0.1";

        int port = 8086;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("GET / HTTP/1.1\n" + "Host: " + host + "\n\n\n");
            String resp = in.readLine();

            System.out.println(resp);

        }
    }
}
