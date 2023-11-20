package Server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServerTest {

    @org.junit.jupiter.api.Test
    public void steamTest() throws InterruptedException {

        int expected = 1;
        ServerTest ServerTest = new ServerTest();
        ServerTest.start();

        Thread.sleep(5000);

        ClientTest clientTest = new ClientTest();
        clientTest.start();

        Thread.sleep(5000);

        int result = ServerTest.server.collectionsCounte();

        assertThat(expected, comparesEqualTo(result));

    }

    @org.junit.jupiter.api.Test
    public void settingTest() throws InterruptedException, IOException {

        ServerTest ServerTest = new ServerTest();
        ServerTest.start();

        Thread.sleep(5000);

        ClientTest clientTest = new ClientTest();
        clientTest.start();

        Thread.sleep(5000);

        Properties properties = new Properties();
        properties.load(new FileReader("./src/Settings.txt"));

        String expectedHost = properties.getProperty("host");
        int expectedPort = Integer.parseInt(properties.getProperty("port"));

        String resultHost = clientTest.client.getHost();
        int resultPort = clientTest.client.getPort();

        assertEquals(expectedHost, resultHost);
        assertEquals(expectedPort, resultPort);
    }
}



