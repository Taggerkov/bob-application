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
     * 'Commercial' base constructor.
     *
     * @param budget      projects budget.
     * @param start       projects start date.
     * @param end         projects end date.
     * @param noOfFloors  projects number of floors.
     * @param size        projects size.
     * @param intendedUse projects purpose.
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
     * Gets the number of floors of the project.
     *
     * @return an integer stating the 'number of floors'.
     */
    public int getNoOfFloors() {
        return noOfFloors;
    }

    /**
     * Gets the intended use of the project.
     *
     * @return a String stating its intended use.
     */
    public String getIntendedUse() {
        return intendedUse;
    }
}