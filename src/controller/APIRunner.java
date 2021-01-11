package controller;

import org.json.simple.JSONObject;
import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import java.util.List;


public class APIRunner {

    

    public String getAPIInfo(String body)
    {
        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient();
        JSONObject jObject = new JSONObject();
        try
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.covid19api.com/dayone/country/south-africa/status/confirmed/live" + body))
                    .build();

            HttpResponse<String> reply = client.send(request, HttpResponse.BodyHandlers.ofString());

            String replyContent = reply.body();

            JSONParser parser = new JSONParser();

            jObject = (JSONObject) parser.parse(replyContent);

        } catch (InterruptedException | ParseException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


}
