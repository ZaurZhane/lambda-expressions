import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Request {
    String method;
    List<String> headers;
    String body;
    List<NameValuePair> params;
    List<NameValuePair> postParams;

    public Request(String method,  List<String> headers, String body, List<NameValuePair> params, List<NameValuePair> postParams) {
        this.method = method;
        this.headers = headers;
        this.body = body;
        this.params = params;
        this.postParams = postParams;
    }

    public  List<String> getHeaders(){
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

    public Optional<NameValuePair> getPostParam(String name){

        return postParams.stream()
                .filter(param->param.getName().equals(name))
                .findFirst();
    }

    public List<NameValuePair> getPostParams(){
        return postParams;
    }

}
