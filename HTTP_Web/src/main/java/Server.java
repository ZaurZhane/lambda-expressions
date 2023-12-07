import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    final List<String> validPaths = List.of("/index.html", "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");
    int numberOfThreads;

    Map<String, Map<String, Handler>> handlers = new HashMap<>();
    public Server(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public void listen(int port) {

        ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);

        try (final var serverSocket = new ServerSocket(port)) {

            while (true) {

                final var socket = serverSocket.accept();

                threadPool.execute(()->connection(socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connection(Socket socket) {
        try (
                final var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final var out = new BufferedOutputStream(socket.getOutputStream());
        ) {


            // read only request line for simplicity
            // must be in form GET /path HTTP/1.1
            final var requestLine = in.readLine();
            final var parts = requestLine.split(" ");

            if (parts.length != 3) {
                // just close socket
                socket.close();
                return;
            }

            final var path = parts[1];

            if (!validPaths.contains(path)) {
                out.write((
                        "HTTP/1.1 404 Not Found\r\n" +
                                "Content-Length: 0\r\n" +
                                "Connection: close\r\n" +
                                "\r\n"
                ).getBytes());
                out.flush();
                return;
            }

            final var filePath = Path.of(".", "public", path);
            final var mimeType = Files.probeContentType(filePath);

            String content = "";

            // special case for classic
            if (path.equals("/classic.html")) {
                final var template = Files.readString(filePath);
                content = template.replace(
                        "{time}",
                        LocalDateTime.now().toString());
            }

            int length = (int)Files.size(filePath);

            String method = parts[0];

            Map<String, String> headers = new HashMap<>();
            headers.put("mimeType", mimeType);
            headers.put("length", Integer.toString(length));

            Request request = new Request(method, headers, content);

            Handler handler = handlers.get(method).get(path);
            handler.handle(request, out);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addHandler(String method, String path, Handler handler) {

        if(handlers.containsKey(method)) {
            handlers.put(method, new HashMap<>());
        }
        handlers.get(method).put(path, handler);

    }

    public void handlerGet(Request request, BufferedOutputStream out) throws IOException {

        Map<String, String> headers = request.getHeaders();

        var mimeType = headers.get("mimeType");
        int length = Integer.parseInt(headers.get("length"));
        String body = request.getBody();

        out.write((
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: " + mimeType + "\r\n" +
                            "Content-Length: " + length + "\r\n" +
                            "Connection: close\r\n" +
                            "\r\n"
        ).getBytes());

        if (!body.isEmpty()) {
            out.write(body.getBytes());
        }
        out.flush();

    }

    public void handlerPost(Request request, BufferedOutputStream out) throws IOException {

        Map<String, String> headers = request.getHeaders();

        var mimeType = headers.get("mimeType");
        int length = Integer.parseInt(headers.get("length"));

        out.write((
                "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: " + mimeType + "\r\n" +
                        "Content-Length: " + length + "\r\n" +
                        "Connection: close\r\n" +
                        "\r\n"
        ).getBytes());
        out.flush();
    }

}


