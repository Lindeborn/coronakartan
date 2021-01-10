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
    private int numOfHospitalized;

    /**
     *
     * @param regionName name of region selected
     * @param numOfHospitalized number of hospitalized in the selected region
     * @param numOfDiseased number of diseased in the selected region
     * @param numOfConfirmedCases number of confirmed cases in the selected region
     */
    public RegionalData(String regionName, int numOfHospitalized, int numOfDiseased, int numOfConfirmedCases){
        this.regionName = regionName;
        this.numOfHospitalized = numOfHospitalized;
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
                "regionName='" + regionName + '\'' +
                ", numOfConfirmedCases=" + numOfConfirmedCases +
                ", numOfDiseased=" + numOfDiseased +
                ", numOfHospitalized=" + numOfHospitalized +
                '}';
    }
}
