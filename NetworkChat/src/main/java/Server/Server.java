package Server;

import Logger.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;


public class Server {
    private final String SETTINGS_PATH = "./src/Settings.txt";
    private Logger logger = new Logger();
    private List<Connection> connections = Collections.synchronizedList(new ArrayList<>());

    public void start() {

        int port = 0;

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(SETTINGS_PATH));

            port = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!(port == 0)) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                logger.log("Запуск сервера");
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    Connection connection = new Connection(clientSocket);
                    connections.add(connection);
                    connection.start();
                }
            } catch (IOException e) {
                logger.log("Ошибка при запуске сервера");
                e.printStackTrace();
            }
        }
    }

    public class Connection extends Thread {
        private PrintWriter out;
        private BufferedReader in;

        public Connection(Socket clientSocket) {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String userName = in.readLine();
                sendMessage(userName + " вошел в чат");

                String message;
                while (!Thread.currentThread().isInterrupted()) {
                    message = in.readLine();
                    if (message.equals("exit")) {
                        break;
                    }
                    sendMessage(userName + ": " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out.close();
            }
        }
        private void sendMessage(String message) {
            String Date = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss ").format(Calendar.getInstance().getTime());
            synchronized (connections) {
                for (Connection connection: connections) {
                    connection.out.println(Date + " " + message);
                    logger.log(Date + " " + message);
                }
            }
        }
    }
    public int collectionsCounte() {
        return connections.size();
    }
    public Logger getLogger(){
        return logger;
    }
}


