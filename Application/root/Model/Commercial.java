package Model;

/**
 * A class for the 'Commercial' project type.
 *
 * @author Sergiu Chirap
 * @version 1.0
 */
public class Commercial extends Project {
    private int noOfFloors;
    private double size;
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
    public Commercial(double budget, String start, String end, int noOfFloors, double size, String intendedUse, String title, String customer, boolean isRenovation) {
        super(budget, start, end);
        this.noOfFloors = noOfFloors;
        this.size = size;
        this.intendedUse = intendedUse;
    }

    /**
     * 'Commercial' no-argument constructor. Default use.
     */
    public Commercial(String title, String customer) {
        super(500000, title, customer);
        this.setEndDate(this.getStartDate().endDate(18));
        this.noOfFloors = 1;
        size = 0;
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

    /**
     * Gets the m^3 size of the project's building.
     *
     * @return a double stating the 'm^3 size'
     */
    public double getSize() {
        return size;
    }

    /**
     * Sets the m^3 size of the project's building.
     *
     * @param size the 'm^3 size' desired
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Gets the intended use of the project's building.
     *
     * @return a String stating the 'intended use'
     */
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
