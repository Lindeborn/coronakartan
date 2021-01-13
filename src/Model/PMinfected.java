package model;

public class PMinfected {
    private int infected;
    /**
     * Represents the message sent (in JSON) from client
     * to the endpoint.
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
