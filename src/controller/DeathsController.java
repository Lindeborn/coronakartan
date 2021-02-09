package controller;

public class DeathsController {

    private model.GetStatus status = new model.GetStatus();
    private ReadAPI readAPI = new ReadAPI();

    public DeathsController()
    {
        readAPI.readFromURL("https://api.covid19api.com/total/dayone/country/sweden/status/deaths");
    }

}
