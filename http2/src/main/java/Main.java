import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static final String REMOTE_SERVICE_URI = "https://api.nasa.gov/planetary/apod?api_key=NpcrCaMFvDZJa4znLeyjKsgxpEikSZ4dUO3R5PCw";
    public static ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);

        CloseableHttpResponse response = httpClient.execute(request);

        DateNasa dateNasa = mapper.readValue(response.getEntity().getContent(), DateNasa.class);

        HttpGet imageRequest = new HttpGet(dateNasa.getUrl());

        CloseableHttpResponse imageResponse = httpClient.execute(imageRequest);

        byte[] buffer = imageResponse.getEntity().getContent().readAllBytes();

        try (FileOutputStream out = new FileOutputStream("ImageNasa.jpg");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {

            bos.write(buffer, 0, buffer.length);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
