package model;

public class PMdeceased {
    private int deceased;
    /**
     * Represents the message sent (in JSON) from client
     * to the endpoint. Contains channelID for requested channel
     */
        public PMdeceased(int deceased) {
            this.deceased = deceased;
        }

        public int getdeceased() {
            return deceased;
        }

        public void setDeceased(int deceased) {
            this.deceased = deceased;
    }
}
