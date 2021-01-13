package model;


public class GetRegional {
    private String regionName;

    public GetRegional(String regionName){
        this.regionName = regionName;
    }

    /**
     * default constructor
     */
    public GetRegional(){}

    public String getRegionName() {
        return regionName;
    }
}
