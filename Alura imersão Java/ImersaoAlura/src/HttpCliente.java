import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpCliente {

    public String BuscarDados(String Url){
        String body = "";
        try {
            URI xURI = URI.create(Url);
            HttpClient xClient = HttpClient.newHttpClient();
            HttpRequest xRequest = HttpRequest.newBuilder(xURI).GET().build();
            HttpResponse<String> xResponse;
            xResponse = xClient.send(xRequest, BodyHandlers.ofString());
            body = xResponse.body();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return body;
    }
}
