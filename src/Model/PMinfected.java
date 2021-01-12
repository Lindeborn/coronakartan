package model;

public class PMinfected {
    private int infected;
    /**
     * Represents the message sent (in JSON) from client
     * to the endpoint. Contains channelID for requested channel
     */
    public PMinfected(int infected) {
        this.infected = infected;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }
}
