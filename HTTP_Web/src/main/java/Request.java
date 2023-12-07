import java.util.List;
import java.util.Map;

public class Request {
    String method;
    Map<String, String> headers;
    String body;

    public Request(String method, Map<String, String> headers, String body) {
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    public Map<String, String> getHeaders(){
        return headers;
    }

    public String getBody(){
        return body;
    }

}
