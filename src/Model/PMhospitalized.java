package model;

public class PMhospitalized {
    private int hospitalized;
    /**
     * Represents the message sent (in JSON) from client
     * to the endpoint.
     */
    public PMhospitalized(int hospitalized) {
        this.hospitalized = hospitalized;
    }

    public int getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(int hospitalized) {
        this.hospitalized = hospitalized;
    }
}
