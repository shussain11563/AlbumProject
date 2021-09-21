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

    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {
        StringTokenizer stringTokenizer = new StringTokenizer(date, "/");
        this.month = Integer.parseInt(stringTokenizer.nextToken());
        this.day = Integer.parseInt(stringTokenizer.nextToken());
        this.year = Integer.parseInt(stringTokenizer.nextToken());
    }

    //create an object with today’s date (see Calendar class)
    public Date()
    {
        Calendar currentDate = Calendar.getInstance();
        this.month = currentDate.get(Calendar.MONTH) + 1;
        this.day = currentDate.get(Calendar.DATE);
        this.year = currentDate.get(Calendar.YEAR);
    }


    /*
        ?) Check if the date is beyond the current Date
        1) Check if Month is between 1 and 12
        2) Check if the Date matches the month
            * if month % 2 == 1 then its 31 days
            * if month % 2 == 0 && month == 2 then its 28/29 days
                * check if leap year
            * if month % 2 == 0 then its 30 days

        3) Check if the date is >= 1980
    */
    public boolean isValid() {
        /*

        System.out.println("Month: " + this.month);
        System.out.println("Day: " + this.day);
        System.out.println("Year: " + this.year);

        */

        Calendar currentDate = Calendar.getInstance();
        if(this.year < THE_EIGHTYS) {
            return false;
        }
        else if(this.month >= 1 && this.month <= 12) {
            if(this.month % 2 == 1) {
                return (this.day >= 1 && this.day <= 31);
            }
            else if(this.month % 2 == 0 && this.month == 2) {
                if(this.year % QUADRENNIAL == 0) {
                    if(this.year % CENTENNIAL == 0) {
                        if(this.year % QUATERCENTENNIAL == 0) {
                            return (this.day >= 1 && this.day <= 29);
                        }
                        else {
                            return (this.day >= 1 && this.day <= 28);
                        }
                    }
                    else {
                        return (this.day >= 1 && this.day <= 29);
                    }

                }
                else {
                    return (this.day >= 1 && this.day <= 28);
                }
            }
            else {
                return (this.day >= 1 && this.day <= 30);
            }
        }
        else {
            return false;
        }
    }

    /*

    Returns -1 if Date1 < Date2
    Returns 0 if Date1 == Date2
    Return 1 if Date1 > Date2

    */
    @Override
    public int compareTo(Date date) {
        if(this.year < date.year) {
            return -1;
        }
        else if(this.year == date.year) {

            if(this.month < date.month) {
                return -1;
            }
            else if(this.month == date.month) {
                if(this.day < this.day) {
                    return -1;
                }
                else if(this.day == this.day) {
                    return 0;
                }
            }
        }
        else {
            return 1;
        }

        return 10;
    }

    //are we allowed to even have a toString method
    @Override
    public String toString()
    {
        return String.format("%d/%d/%d", this.month, this.day, this.year);
    }


}