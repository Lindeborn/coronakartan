package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ReadAPI {

    /**
     * Read API content from URL by sending a HTTP client request and reading the response.
     * Non-UI-blocking operation.
     */

    public void readFromURL(String URL) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(URL))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(this::parseJSONData).
                join();
    }

    public int parseJSONData(String response)
    {
        int cases= 0;
        String date = "";
        String currentCountry = "";

        JSONArray countries = new JSONArray(response.toString());
        for (int i = 0; i < countries.length(); i++)
        {
            JSONObject country = countries.getJSONObject(i);

            currentCountry = country.getString("Country");
            cases = country.getInt("Cases");
            date = country.getString("Date");

            //System.out.println(currentCountry + "   " + "date " + date + "  " + cases + "   " );

            //showNumOfCases(cases);

            //store cases in arraylist in each model class OR

            //call method showOnTextArea(cases) here. It will change status depending on which class performs the call

            //status.setNumberofInfected(cases); //stores in model variable numberOfInfected

        }
        return cases;
    }
}
