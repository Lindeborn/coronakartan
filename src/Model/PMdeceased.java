package model;

public class PMdeceased {
    private int deceased;
    /**
     * Represents the message sent (in JSON) from client
     * to the endpoint.
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
