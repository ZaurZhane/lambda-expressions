package Client;

import Logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class MessageDownloader extends Thread {
    private final BufferedReader in;
    private Logger logger;
    public MessageDownloader(BufferedReader in, Logger logger) {
        this.in = in;
        this.logger = logger;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.log("Ошика при загрузке сообщения");
        }
    }
}
