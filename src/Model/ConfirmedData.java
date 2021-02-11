package Model;

import controller.ConfirmedController;

import java.util.ArrayList;

//TODO 1. Date and time 2. number of confirmed cases -> store this as Confirmed Data object
// by adding String date and arrayList of date

public class ConfirmedData
{
  private ArrayList<Integer> confirmedList;
  private ArrayList<String> dateList;

    /**
     * Constructor, initializes lists
     */
    public ConfirmedData() {
        confirmedList = new ArrayList<>();
        dateList = new ArrayList<>();
    }

    /**
     *
     * @return list of dates with confirmed cases since day one
     */
    public ArrayList<String> getDateList() {
        return dateList;
    }

    /**
     * sets the date arraylist with dates
     * @param dates the dates since day one of confirmed cases from ConfirmedController.java
     */
    public void setDateList(String dates) {
        this.dateList = dateList;

        dateList.add(dates);
        for (String date: dateList)
        {
            System.out.print("Datum : " + date + " ");
        }
    }

    /**
     *
     * @return list of total confirmed cases since day one
     */
    public ArrayList<Integer> getConfirmedList() {
        return confirmedList;
    }


    public void setListOfConfirmed(ArrayList <Integer> list)
    {
        this.confirmedList = list;

    }

    public void printList()
    {
        for (Integer conf : confirmedList)
        {
            System.out.println("Bekräftade fall: " + conf);
        }
    }

    /**
     *
     * @return  RETURNERAR EMPTY
     */
    @Override
    public String toString() {

        return "ConfirmedData{" +
                "confirmedList=" + confirmedList +
                ", dateList=" + dateList +
                '}';
    }
}
