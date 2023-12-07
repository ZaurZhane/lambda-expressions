import java.io.BufferedOutputStream;

public class Main {

    public static void main(String[] args) {

        final var server = new Server(64);

        server.addHandler("GET", "/messages", (request, responseStream) -> {
            server.handlerGet(request, responseStream);
        });
        server.addHandler("POST", "/messages", (request, responseStream) -> {
            server.handlerPost(request, responseStream);
        });

        server.listen(9999);

    }
}
