import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        String host = "netology.homework";

        int port = 8086;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("1. Zaur Zhane");

            String resp = in.readLine();
            System.out.println(resp);

            String resp2 = in.readLine();
            System.out.println(resp2);

            out.println("2. No");

            String resp3 = in.readLine();
            System.out.println(resp3);

            out.println("3. Thank you.");

            String resp4 = in.readLine();
            System.out.println(resp4);

            out.println("4. Krasnodar");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
