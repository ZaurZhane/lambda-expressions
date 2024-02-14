package ru.netology;

import org.apache.catalina.LifecycleException;
import java.io.IOException;
import org.apache.catalina.startup.Tomcat;
import java.nio.file.Files;
import org.apache.catalina.connector.Connector;

public class Main {
    public static void main(String[] args) throws LifecycleException, IOException {
        final var tomcat = new Tomcat();
        final var baseDir = Files.createTempDirectory("tomcat");
        baseDir.toFile().deleteOnExit();
        tomcat.setBaseDir(baseDir.toAbsolutePath().toString());

        final var connector = new Connector();
        connector.setPort(9999);
        tomcat.setConnector(connector);

        tomcat.getHost().setAppBase(".");
        tomcat.addWebapp("", ".");

        tomcat.start();
        tomcat.getServer().await();
    }
}
