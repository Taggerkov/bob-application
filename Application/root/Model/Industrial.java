package Model;

import java.time.LocalDate;

/**
 * Class for Industrial, extension of the class "Project"
 *
 * @author Bibek, Sergiu Chirap
 * @version 1.0
 */
public class Industrial extends Project {
    private String typeOfFacility;

    /**
     * Full constructor for Industrial class
     *
     * @param budget
     * @param start
     * @param end
     * @param title
     * @param customer
     * @param size
     * @param typeOfFacility
     */

    public Industrial(double budget, String start, String end, String title, String customer, double size, boolean isRenovation, String typeOfFacility) {
        super("Industrial", budget, start, end, title, customer, size, isRenovation);
        this.typeOfFacility = typeOfFacility;
    }

    /**
     * constructor for Industrial class, default values
     *
     * @param title    title of the project
     * @param customer name of the customer attached to the project
     */
    public Industrial(String title, String customer) {
        super("Industrial", 2000000, String.valueOf(LocalDate.now()), new MyDate(new MyDate(String.valueOf(LocalDate.now())).endDate(30).toStringDate()).toStringDate(), title, customer, -1, false);
        super.setEndDate(super.getStartDate().endDate(30));
        typeOfFacility = "Unspecified";
    }

    public String getTypeOfFacility() {
        return typeOfFacility;
    }

    /**
     * sets the type of facility
     *
     * @param typeOfFacility
     */

    public void setTypeOfFacility(String typeOfFacility) {
        this.typeOfFacility = typeOfFacility;
    }

    /**
     * Checks if the given object is the same as the Industrial one
     *
     * @param obj
     * @return true if the given object is the same as the Industrial object and false if it is not
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Industrial other = (Industrial) obj;
        return super.equals(other) && typeOfFacility.equals(other.typeOfFacility);
    }
}
