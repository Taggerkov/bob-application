package Model;

import java.io.Serializable;

/**
 * class for MyDate
 *
 * @author Bibek
 * @version 1.0
 */
public class MyDate implements Serializable {

    private int day;
    private int month;
    private int year;

    /**
     * Full constructor for MyDate class
     *
     * @param day
     * @param month
     * @param year
     */

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * constructor for MyDate class, default values
     *
     * @param date
     */

    public MyDate(String date) {
        String[] temp = date.split("-");
        this.year = Integer.parseInt(temp[0]);
        this.month = Integer.parseInt(temp[1]);
        this.day = Integer.parseInt(temp[2]);
    }

    /**
     * gets the day of the start of end day of the project
     *
     * @return day
     */

    public int getDay() {
        return day;
    }

    /**
     * sets the start or end day of a project
     *
     * @param day
     */

    public void setDay(int day) {
        this.day = day;
    }

    /**
     * gets the start on end month of a project
     *
     * @return month
     */

    public int getMonth() {
        return month;
    }

    /**
     * sets the start or end month of a project
     *
     * @param month
     */

    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * gets the start or end year of a project
     *
     * @return year
     */

    public int getYear() {
        return year;
    }

    /**
     * sets the start or end year of a project
     *
     * @param year
     */

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Calculates the EndDate
     *
     * @param months the 'months' expected
     * @return a MyDate stating the 'EndDate'
     * @author Sergiu Chirap
     */
    public MyDate endDate(int months) {
        MyDate temp = this;
        int month = temp.getMonth();
        int year = temp.getYear();
        month += months;
        if (month > 12) {
            int residues = month / 12;
            year += residues;
            month -= 12 * residues;
            temp.setMonth(month);
            temp.setYear(year);
        }
        return temp;
    }

    /**
     * Checks if the given date is before or same as the MyDate date
     *
     * @param date
     * @return true if its before or exact same date and false if its after
     * @author Salomeea Tricolici
     */
    public boolean isBefore(MyDate date) {
        return this.year < date.year || (this.year == date.year && this.month < date.month) || (this.year == date.year && this.month == date.month && this.day <= date.day);
    }

    /**
     * Returns MyDate as a String.
     *
     * @return a String stating the 'date'
     * @author Sergiu Chirap
     */
    public String toString() {
        return month + "/" + day + "/" + year;
    }
    /**
     * Returns a String of MyDate with LocalDate's style.
     *
     * @return another String stating the 'date'
     * @author Sergiu Chirap
     */
    public String toStringDate() {
        return String.format("%d-%02d-%02d",year,month,day);
    }
}
