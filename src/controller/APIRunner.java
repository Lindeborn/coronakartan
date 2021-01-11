package controller;

import org.json.simple.JSONObject;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.List;


public class APIRunner {

    public static void main(String[] args) throws Exception {
        port(5000);

        Storage storage = new Storage();
        storage.setup();

        // A demonstration of how to use code within an endpoint
        get("/", (req, res) -> {
            return "Hello world";
        });


    }


}
