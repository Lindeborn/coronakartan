package controller;

public class ConfirmedController {

    private model.GetStatus status = new model.GetStatus();
    private ReadAPI readAPI = new ReadAPI();

    public ConfirmedController()
    {
        readAPI.readFromURL("https://api.covid19api.com/total/dayone/country/sweden/status/confirmed");
    }

}

