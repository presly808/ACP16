package nativeServer.httpExample;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpRequstImplementation implements HttpRequestInterface{

    public static final String HTTP_LOCALHOST_8080 = "http://localhost:8080/";
    public static final String USER_AGENT = "Mozilla/5.0";
    private HttpClient httpClient;

    public HttpRequstImplementation() {
        this.httpClient = HttpClients.createDefault();
    }

    @Override
    public ResponseDTO sendGet() throws IOException {
        HttpGet request = new HttpGet(HTTP_LOCALHOST_8080 + "/token");
        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = httpClient.execute(request);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatusCode(response.getStatusLine().getStatusCode());
        responseDTO.setResponseBody(getResponseMessage(response));
        return responseDTO;
    }

    @Override
    public ResponseDTO sendPost() {
        return null;
    }

    @Override
    public ResponseDTO sendDelete() {
        return null;
    }

    private String getResponseMessage(HttpResponse response) throws IOException {
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}
