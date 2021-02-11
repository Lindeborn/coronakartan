package controller;

public class RecoveredController {

    private Model.GetStatus status = new Model.GetStatus();
    private ReadAPI readAPI = new ReadAPI();

    public RecoveredController()
    {
        //set header in html to "recovered"
        //then call read API to display cases on area
        readAPI.readFromURL("https://api.covid19api.com/total/dayone/country/sweden/status/recovered");
    }
}
