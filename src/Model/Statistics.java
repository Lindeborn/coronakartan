package Model;

public abstract class Statistics
{
    private int numOfConfirmedCases;
    private int numOfDiseased;
    private int numOfHospitalized;

    public Statistics(int numOfConfirmedCases, int numOfDiseased, int numOfHospitalized)
    {
        this.numOfConfirmedCases = numOfConfirmedCases;
        this.numOfDiseased = numOfDiseased;
        this.numOfHospitalized = numOfHospitalized;
    }

    public int getNumOfConfirmedCases() {
        return numOfConfirmedCases;
    }

    public void setNumOfConfirmedCases(int numOfConfirmedCases) {
        this.numOfConfirmedCases = numOfConfirmedCases;
    }

    public int getNumOfDiseased() {
        return numOfDiseased;
    }

    public void setNumOfDiseased(int numOfDiseased) {
        this.numOfDiseased = numOfDiseased;
    }

    public int getNumOfHospitalized() {
        return numOfHospitalized;
    }

    public void setNumOfHospitalized(int numOfHospitalized) {
        this.numOfHospitalized = numOfHospitalized;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "numOfConfirmedCases=" + numOfConfirmedCases +
                ", numOfDiseased=" + numOfDiseased +
                ", numOfHospitalized=" + numOfHospitalized +
                '}';
    }
}
