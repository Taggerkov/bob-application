package Model;

import java.io.Serializable;

/**
 * class for MyDate
 *
 * @author Bibek
 * @version 2.0
 */
public class MyDate implements Serializable {

    private int day;
    private int month;
    private int year;

    /**
     * String to MyString converter.
     *
     * @param date a string which contains the date in the LocalDate format.
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
     * @param month the desired month to be changed with.
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
     * @param year the desired year to be changed with.
     */

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Calculates the EndDate based on desired months.
     *
     * @param months the 'months' expected.
     * @return a MyDate stating the 'EndDate'.
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
     * @param date the desired date to be compared with.
     * @return true if its before or exact same date and false if its after
     * @author Salomeea Tricolici
     */
    public boolean isBefore(MyDate date) {
        return this.year < date.year || (this.year == date.year && this.month < date.month) || (this.year == date.year && this.month == date.month && this.day <= date.day);
    }

    /**
     * Gets the MyDate as a String.
     *
     * @return a String stating the 'date'
     * @author Sergiu Chirap
     */
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Gets the MyDate as a String with the LocalDate format.
     *
     * @return a String stating the 'date' with LocalDate format.
     * @author Sergiu Chirap
     */
    public String toStringDate() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    /**
     * Checks if two dates are the same.
     *
     * @param date the date wanted to be checked with.
     * @return true or false depending on the result.
     * @author Sergiu Chirap
     */
    public boolean equals(MyDate date) {
        return this.day == date.getDay() && this.month == date.month && this.year == date.getYear();
    }
}