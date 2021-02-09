package controller;

public class RecoveredController {

    private model.GetStatus status = new model.GetStatus();
    private ReadAPI readAPI = new ReadAPI();

    public RecoveredController()
    {
        readAPI.readFromURL("https://api.covid19api.com/total/dayone/country/sweden/status/recovered");
    }
}
