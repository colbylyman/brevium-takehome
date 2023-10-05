package Web;

import org.javatuples.Pair;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Class to make the connection with the API and send requests
public class HttpConnectionClient {
    // Make a request to the API and save the response so the code and body can be used later
    Pair<Integer, String> makePostRequest(String url, String body)  throws IOException, InterruptedException {

        // Create the http client and request objects
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request;

        // If there is a body, set the header to accept the right content type
        if (body.length() > 0) {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .header("Content-Type", "application/json")
                    .build();
        }
        else {
            request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
        }

        // Send request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        Pair<Integer, String> codeBodyPair = new Pair<>(response.statusCode(), response.body());

        return codeBodyPair;
    }

    Pair<Integer, String> makeGetRequest(String url)  throws IOException, InterruptedException {
        // Create the http client and request objects
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request;

        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send request
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        Pair<Integer, String> codeBodyPair = new Pair<>(response.statusCode(), response.body());

        return codeBodyPair;
    }

}
