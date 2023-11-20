package Server;

public class ServerTest extends Thread{
    public Server server;
    @Override
    public void run() {
        server = new Server();
        server.start();
    }
}
