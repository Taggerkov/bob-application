package Model;

import java.time.LocalDate;

/**
 * Class for Industrial, extension of the class "Project"
 *
 * @author Bibek, Sergiu Chirap
 * @version 2.0
 */
public class Industrial extends Project {
    private final String typeOfFacility;

    /**
     * Full constructor for Industrial class.
     *
     * @param budget         projects budget.
     * @param start          projects start.
     * @param end            projects end date.
     * @param title          projects title.
     * @param customer       projects customer.
     * @param size           projects size.
     * @param typeOfFacility projects type of facility.
     */

    public Industrial(double budget, String start, String end, String title, String customer, double size, boolean isRenovation, String typeOfFacility, String isPublished) {
        super("Industrial", budget, start, end, title, customer, size, isRenovation, isPublished);
        this.typeOfFacility = typeOfFacility;
    }

    /**
     * constructor for Industrial class, default values
     *
     * @param title    title of the project
     * @param customer name of the customer attached to the project
     */
    public Industrial(String title, String customer) {
        super("Industrial", 2000000, String.valueOf(LocalDate.now()), new MyDate(new MyDate(String.valueOf(LocalDate.now())).endDate(30).toStringDate()).toStringDate(), title, customer, -1, false, "Local");
        super.setEndDate(super.getStartDate().endDate(30));
        typeOfFacility = "Unspecified";
    }

    public String getTypeOfFacility() {
        return typeOfFacility;
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