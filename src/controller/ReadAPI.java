package controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import Model.RegionalData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Enum.Regions;

public class ReadAPI {

    public JSONObject readBodyFromAPI(String body)
    {
        HttpClient httpClient = HttpClient.newHttpClient();
        JSONObject object = new JSONObject();
        try
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.covid19api.com/dayone/country/sweden/status/confirmed/live\n" + body))
                    .build();

            HttpResponse<String> reply = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            String replyContent = reply.body();

            JSONParser parser = new JSONParser();

            object = (JSONObject) parser.parse(replyContent);

        }
        catch (Exception e)
        {
            System.out.println("ReadBodyFromAPI " + e.getMessage());
        }

        return object;
    }

    public static void main (String[] args)
    {
        ReadAPI api = new ReadAPI();

        ArrayList<RegionalData> regionalDataList = new ArrayList<>();

        for (Regions regions: Regions.values())
        {
            regionalDataList.add(new RegionalData(api.readBodyFromAPI(regions.toString())));
        }

    }
}
