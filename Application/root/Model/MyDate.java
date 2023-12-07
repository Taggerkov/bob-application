package Model;

public class MyDate {
    /**
     * class for MyDate
     * @author Sergiu Chirap
     * @version 1.0
     */
    private int day;
    private int month;
    private int year;

    /**
     * Full constructor for MyDate class
     * @param day
     * @param month
     * @param year
     */

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**constructor for MyDate class, default values
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
     * @return day
     */

    public int getDay() {
        return day;
    }

    /**
     *sets the start or end day of a project
     * @param day
     */

    public void setDay(int day) {
        this.day = day;
    }

    /**
     * gets the start on end month of a project
     * @return month
     */

    public int getMonth() {
        return month;
    }

    /**
     * sets the start or end month of a project
     * @param month
     */

    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * gets the start or end year of a project
     * @return year
     */

    public int getYear() {
        return year;
    }

    /**
     * sets the start or end year of a project
     * @param year
     */

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * calculates the end date by adding the expected amount of time needed to finalize the project
     * @param months
     * @return end date
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
     * Checks if the given date is the same as the MyDate date
     * @param obj
     * @return true if the given date is the same as the MyDate date and false if they are different
     */
    public boolean equals(Object obj)
    {
        if (obj== null || obj.getClass()!=this.getClass())
            return false;
        MyDate other=(MyDate) obj;
        return day==other.day && month==other.month && year== other.year;
    }

    /**
     * Checks if the given date is before or same as the MyDate date
     * @param date
     * @return true if its before or exact same date and false if its after
     */
    public boolean isBefore(MyDate date){
        return this.year < date.year || (this.year == date.year && this.month < date.month )|| (this.year == date.year && this.month == date.month && this.day <= date.day);
    }
}
