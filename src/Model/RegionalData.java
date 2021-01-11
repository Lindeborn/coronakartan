package Model;

import org.json.simple.JSONObject;
import com.google.gson.*;

/**
 * Class is model which holds data on number of confirmed cases of Coronavirus-19, number of diseased and number of hospitalized.
 * When user selects a region on the map this information is displayed.
 * Data is taken from coronavirus-19 API as a JSON, which in turn is added here as Java code.
 * A toString() returns the String representation of this data.
 */
public class RegionalData {

    private String countryName;
    private String regionalData;
    private int numOfConfirmedCases;
    private int numOfDiseased;
    private int numOfRecovered;

    private JSONObject object;

    //TODO fixa get from JSON

    public RegionalData(JSONObject object){
        this.object = object;
        this.countryName = object.get("Country").toString();         //oklart om det är så det ska göras- förmoldigen ej
       // this.numOfRecovered = object.get();
        this.numOfDiseased = numOfDiseased;
        this.numOfConfirmedCases = numOfConfirmedCases;
    }

    /**
     * default constructor
     */
    public RegionalData(){}

    @Override
    public String toString() {
        return "RegionalData{" +
                "countryName='" + countryName + '\'' +
                ", numOfConfirmedCases=" + numOfConfirmedCases +
                ", numOfDiseased=" + numOfDiseased +
                ", numOfRecovered=" + numOfRecovered +
                ", object=" + object +
                '}';
    }

    //jsonobject.get("Sweden")
    public String getCountryName() {
        return countryName;
    }

    public String getRegionalData() {
        return regionalData;
    }

    public int getNumOfConfirmedCases() {
        return numOfConfirmedCases;
    }

    public int getNumOfDiseased() {
        return numOfDiseased;
    }

    public int getNumOfRecovered() {
        return numOfRecovered;
    }

    public JSONObject getObject() {
        return object;
    }
}
