package Server;

import Client.Client;

class ClientTest extends Thread{
    public Client client;
    @Override
    public void run() {
        client = new Client("Заур");
        client.start();
    }
}
