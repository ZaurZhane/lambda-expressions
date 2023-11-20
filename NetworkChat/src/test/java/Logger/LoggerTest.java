package Logger;

import Server.ServerTest;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class LoggerTest {

    @org.junit.jupiter.api.Test
    public void loggerTest() throws InterruptedException {

        File expected = new Logger().getLog();

        ServerTest serverTest = new ServerTest();
        serverTest.start();

        Thread.sleep(5000);

        File result = serverTest.server.getLogger().getLog();

        assertThat(expected, comparesEqualTo(result));

    }

}
