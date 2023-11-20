package Client;

import Logger.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private final String SETTINGS_PATH = "./src/Settings.txt";
    private final Logger logger;
    private String host;
    private int port;
    private Scanner scanner;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;

    public Client() {

        this.logger = new Logger();

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(SETTINGS_PATH));
            host = properties.getProperty("host");
            port = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.log("Ошика при чтении настроек из файла " + SETTINGS_PATH);
        }

    }

    public Client(String name) {
        this.logger = new Logger();
        this.name = name;

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(SETTINGS_PATH));
            host = properties.getProperty("host");
            port = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.log("Ошика при чтении настроек из файла " + SETTINGS_PATH);
        }
    }

    public void start() {
        try {
            socket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            scanner = new Scanner(System.in);

            logger.log("Клиент запущен");

            String userName = "";
            if (!(name == null)) {
                userName = name;
            } else {
                System.out.println("Введите свое имя!");
                userName = scanner.nextLine();
            }

            out.println(userName);
            logger.log(userName + "вошёл в чат");

            MessageDownloader мessageDownloader = new MessageDownloader(in, logger);
            мessageDownloader.start();

            String message = "";
            while (!message.equals("exit")) {
                message = scanner.nextLine();
                out.println(message);
                logger.log(message);
            }
            мessageDownloader.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
            logger.log("Ошика при старте клиента");
        } finally {
            closeConnetion();
        }
    }

    private void closeConnetion() {
        try {
            scanner.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.log("Ошика при закрытии соединения");
        }
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

}




