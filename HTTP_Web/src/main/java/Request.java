import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Request {
    String method;
    Map<String, String> headers;
    String body;
    List<NameValuePair> params;

    public Request(String method, Map<String, String> headers, String body, List<NameValuePair> params) {
        this.method = method;
        this.headers = headers;
        this.body = body;
        this.params = params;
    }
    public Map<String, String> getHeaders(){
        return headers;
    }
    public String getBody(){
        return body;
    }
    public Optional<NameValuePair> getParam(String name){

        return params.stream()
                .filter(param->param.getName().equals(name))
                .findFirst();
    }
    public List<NameValuePair> getParams(){
        return params;
    }

}
