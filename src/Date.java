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
     * @return Returns true if the date is valid and false if the date is not valid
     */
    public boolean isValid() {
        Calendar currentDate = Calendar.getInstance();

        if(this.year < THE_EIGHTYS || this.year > currentDate.get(Calendar.YEAR)) {
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
     *  This method overrides the compareTo method and it compares two date objects and returns based on which dates are the same, before, or after.
     * @param date object being compared to the current date
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

    /**
     * Testbed main for the Date class
     */
    public static void main(String[] args) {
        // test case #1, a date with a year before 1980 should be invalid
        // fail
        Date date = new Date("1/2/1900");
        System.out.println("Test Case #1");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #2, a date with an invalid month
        // fail
        date = new Date("15/2/2000");
        System.out.println("Test Case #2");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #3, a date with an invalid day
        // fail
        date = new Date("5/50/2000");
        System.out.println("Test Case #3");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #4, check for valid leap year
        // pass
        date = new Date("2/29/2016");
        System.out.println("Test Case #4");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #5, check for invalid day for leap year
        // fail
        date = new Date("2/30/2016");
        System.out.println("Test Case #5");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #6, check for invalid day on not a leap year
        // fail
        date = new Date("2/29/2013");
        System.out.println("Test Case #6");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #7, check the max/min for day/month/year
        // fail
        date = new Date("30/27123/2000");
        System.out.println("Test Case #7");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #8, check if the day is valid
        // fail
        date = new Date("301/5/2005");
        System.out.println("Test Case #8");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #9, check if the month is valid
        // fail
        date = new Date("1/50/2021");
        System.out.println("Test Case #9");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");

        // test case #10, check if the month is between 1980 and current year
        // fail
        date = new Date("9/1/2070");
        System.out.println("Test Case #10");
        if(date.isValid())
            System.out.println("Pass.");
        else
            System.out.println("Fail.");
    }
}