package Controller;

import com.google.gson.Gson;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class APIRunner {


    public static void main(String[] args) throws Exception {
        try{
        String url = "http://openexchangerates.org/api/latest.json?app_id=db98850be67e4d3d9a3ac0cf26ea2e40";
        String json = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        JsonParser jsonParser = new JsonParser();
        System.out.println(jsonParser.parse(json));
        }catch(Exception e) {
            System.out.println("hej");
    }

    }
}
