package Model;

import java.time.LocalDate;

/**
 * A class for the 'Commercial' project type.
 *
 * @author Sergiu Chirap
 * @version 1.5
 */
public class Commercial extends Project {
    private int noOfFloors;
    private String intendedUse;

    /**
     * 'Commercial' full-constructor. Custom use.
     *
     * @param budget      custom budget
     * @param start       custom start date
     * @param end         custom end date
     * @param noOfFloors  custom number of floors
     * @param size        building's m^3 size
     * @param intendedUse building's purpose
     */
    public Commercial(double budget, String start, String end, String title, String customer, double size, int noOfFloors, String intendedUse, boolean isRenovation, String isPublished) {
        super("Commercial", budget, start, end, title, customer, size, isRenovation, isPublished);
        this.noOfFloors = noOfFloors;
        this.intendedUse = intendedUse;
    }

    /**
     * 'Commercial' no-argument constructor. Default use.
     */
    public Commercial(String title, String customer) {
        super("Commercial", 500000, String.valueOf(LocalDate.now()), new MyDate(new MyDate(String.valueOf(LocalDate.now())).endDate(18).toStringDate()).toStringDate(), title, customer, -1, false, "Local");
        this.setEndDate(this.getStartDate().endDate(18));
        this.noOfFloors = 1;
        intendedUse = "Unspecified";
    }

    /**
     * Gets the number of floors of the project's building.
     *
     * @return an integer stating the 'number of floors'
     */
    public int getNoOfFloors() {
        return noOfFloors;
    }

    /**
     * Sets the number of floors of the project's building.
     *
     * @param noOfFloors the 'number of floors' desired
     */
    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public String getIntendedUse() {
        return intendedUse;
    }

    /**
     * Sets the intended use of the project's building.
     *
     * @param intendedUse the 'intended use' desired
     */
    public void setIntendedUse(String intendedUse) {
        this.intendedUse = intendedUse;
    }
}
