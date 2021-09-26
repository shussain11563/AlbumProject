/**
 * @author Sharia Hussain, David Lam
 */

import java.util.StringTokenizer;
import java.util.Calendar;

public class Date implements Comparable<Date>
{
    private final int month;
    private final int day;
    private final int year;

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THE_EIGHTYS = 1980;
    public static final int MONTH_MIN = 1;
    public static final int MONTH_MAX = 12;
    public static final int DAY_MIN = 1;
    public static final int DAY_MAX_THIRTHY = 30;
    public static final int DAY_MAX_THIRTHY_ONE = 31;
    public static final int DAY_MAX_LEAPYEAR = 29;
    public static final int DAY_MAX_NOT_LEAPYEAR = 28;

    /**
     * Date constructor that takes in a Date Object
     */
    public Date(String date) {
        StringTokenizer stringTokenizer = new StringTokenizer(date, "/");
        this.month = Integer.parseInt(stringTokenizer.nextToken());
        this.day = Integer.parseInt(stringTokenizer.nextToken());
        this.year = Integer.parseInt(stringTokenizer.nextToken());
    }

    /**
     * Date constructor that initializes the instance variables to the present date
     */
    public Date() {
        Calendar currentDate = Calendar.getInstance();
        this.month = currentDate.get(Calendar.MONTH) + 1;
        this.day = currentDate.get(Calendar.DATE);
        this.year = currentDate.get(Calendar.YEAR);
    }

    /**
     * Method that checks the validity of the date
     *  1) Check if the date is beyond the current Date
     *  2) Check if Month is between 1 and 12
     *  3) Check if the Date matches the month
     *      if month % 2 == 1 then its 31 days
     *      if month % 2 == 0 && month == 2 then its 28/29 days
     *          check if leap year
     *      if month % 2 == 0 then its 30 days
     *  4) Check if the date is >= 1980
     * @return Returns true if the date is valid and false if the date is not valid
     */
    public boolean isValid() {
        if(this.year < THE_EIGHTYS) {
            return false;
        }
        else if(this.month >= MONTH_MIN && this.month <= MONTH_MAX) {
            if(this.month % 2 == 1) {
                return (this.day >= DAY_MIN && this.day <= DAY_MAX_THIRTHY_ONE);
            }
            else if(this.month % 2 == 0 && this.month == 2) {
                if(this.year % QUADRENNIAL == 0) {
                    if(this.year % CENTENNIAL == 0) {
                        if(this.year % QUATERCENTENNIAL == 0) {
                            return (this.day >= DAY_MIN && this.day <= DAY_MAX_LEAPYEAR);
                        }
                        else {
                            return (this.day >= DAY_MIN && this.day <= DAY_MAX_NOT_LEAPYEAR);
                        }
                    }
                    else {
                        return (this.day >= DAY_MIN && this.day <= DAY_MAX_LEAPYEAR);
                    }

                }
                else {
                    return (this.day >= DAY_MIN && this.day <= DAY_MAX_NOT_LEAPYEAR);
                }
            }
            else {
                return (this.day >= DAY_MIN && this.day <= DAY_MAX_THIRTHY);
            }
        }
        else {
            return false;
        }
    }

    /**
     * Method that compares two date objects and returns based on which dates are the same, before, or after.
     * @param date object
     * @return Returns -1 if Date1 < Date2, Returns 0 if Date1 == Date2, and Returns 1 if Date1 > Date2
     */
    @Override
    public int compareTo(Date date)
    {
        /*
        if(date==null)
        {
            return -1;
        }
        */
        if(this.year < date.year) {
            return -1;
        }
        else if(this.year == date.year)
        {
            if(this.month < date.month) {
                return -1;
            }
            else if(this.month == date.month)
            {
                if(this.day < date.day)
                {
                    return -1;
                }
                else if(this.day == date.day) {
                    return 0;
                }
            }
        }
        else {
            return 1;
        }

        return 10;
    }

    /**
     * Method that returns a formatted string of the Date Object
     * @return Returns a formatted string in the format of Month/Day/Year
     */
    @Override
    public String toString()
    {
        return String.format("%d/%d/%d", this.month, this.day, this.year);
    }


}