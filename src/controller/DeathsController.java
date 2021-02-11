package controller;

public class DeathsController {

    private Model.GetStatus status = new Model.GetStatus();
    private ReadAPI readAPI = new ReadAPI();

    public DeathsController()
    {
        //set header in html to "dead"
        //then call read API to display cases on area

        readAPI.readFromURL("https://api.covid19api.com/total/dayone/country/sweden/status/deaths");
    }

}
