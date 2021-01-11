package Model;

/**
 * Class is model which holds data on number of confirmed cases of Coronavirus-19, number of diseased and number of hospitalized.
 * When user selects a region on the map this information is displayed.
 * Data is taken from coronavirus-19 API as a JSON, which in turn is added here as Java code.
 * A toString() returns the String representation of this data.
 */
public class RegionalData {
    private String regionName;
    private int numOfConfirmedCases;
    private int numOfDiseased;
    private int numOfRecovered;

    public RegionalData(String regionName, int numOfConfirmedCases, int numOfDiseased, int numOfRecovered){
        this.numOfRecovered = numOfRecovered;
        this.numOfDiseased = numOfDiseased;
        this.numOfConfirmedCases = numOfConfirmedCases;
    }

    /**
     * default constructor
     */
    public RegionalData(){}

    public String getRegionName() {
        return regionName;
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

}
