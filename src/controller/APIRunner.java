package controller;


import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.json.*;


public class APIRunner {

    /**
     * Read API content from URL by sending a HTTP client request and reading the response.
     * Non-UI-blocking operation.
     */
    public void readFromURL() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create("https://api.covid19api.com/total/dayone/country/sweden/status/confirmed"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)  //recieve respons and apply this to previous result. Body from Httpresponse class
                .thenApply(this::parseJSONData).
                join();


    }

    public String parseJSONData(String response)
    {
        JSONArray countries = new JSONArray(response);
        for (int i = 0; i < countries.length(); i++)
        {
            JSONObject country = countries.getJSONObject(i);
            String currentCountry = country.getString("Country");
            int cases = country.getInt("Cases");

            System.out.println(currentCountry + "   " + cases + "   ");

            //TODO: String status = countries.getString(Integer.parseInt("Status")); //vill ha index
        }
        return null;
    }

    public static void main (String [] args)
    {
        APIRunner runner = new APIRunner();
        runner.readFromURL();
    }

}
