package model;

public class GetStatus {
    private int numberofInfected;
    private int numberofDeceased;
    private int numberofHospitalized;

    public int getNumberofInfected() {
        return numberofInfected;
    }

    public void setNumberofInfected(int numberofInfected) {
        this.numberofInfected = numberofInfected;
    }

    public int getNumberofDeceased() {
        return numberofDeceased;
    }

    public void setNumberofDeceased(int numberofDeceased) {
        this.numberofDeceased = numberofDeceased;
    }

    public int getNumberofHospitalized() {
        return numberofHospitalized;
    }

    public void setNumberofHospitalized(int numberofHospitalized) {
        this.numberofHospitalized = numberofHospitalized;
    }
}
