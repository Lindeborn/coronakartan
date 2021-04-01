package controller;

import Model.ConfirmedData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class ConfirmedController {

    private ConfirmedData confirmedData;
    private int cases= 0;
    private String date = "";


    public ConfirmedController()
    {
        confirmedData = new ConfirmedData();

        readFromURL("https://api.covid19api.com/total/dayone/country/sweden/status/confirmed");
    }

    /**
     * Read API content from URL by sending a HTTP client request and reading the response.
     *
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
        String currentCountry = "";

        JSONArray countries = new JSONArray(response.toString());
        for (int i = 0; i < countries.length(); i++)
        {
            JSONObject country = countries.getJSONObject(i);

            currentCountry = country.getString("Country");
            cases = country.getInt("Cases");
            date = country.getString("Date");

            ArrayList<Integer> list3 = new ArrayList<>();
            list3.add(cases);

            confirmedData.setListOfConfirmed(list3);
            confirmedData.printList();
        }

        return cases;
    }

}

