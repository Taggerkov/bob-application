package Model;

import java.time.LocalDate;

/**
 * Class for RoadConstruction, extension of the class Project
 *
 * @author Salomeea Tricolici, Sergiu Chirap
 * @version 2.0
 */
public class RoadConstruction extends Project {

    private int noOfLanes;
    private double length;
    private double width;
    private boolean hasGeoChallenge;
    private boolean hasBridges;
    private boolean hasTunnels;

    /**
     * Full constructor for RoadConstruction class.
     *
     * @param budget          projects budget.
     * @param start           projects start date.
     * @param end             projects end date.
     * @param hasBridges      if project has bridges.
     * @param hasTunnels      if project has tunnels.
     * @param length          projects length.
     * @param width           projects width.
     * @param hasGeoChallenge if project has geo challenges.
     * @param noOfLanes       projects number of lanes.
     */
    public RoadConstruction(double budget, String start, String end, String title, String customer, double size, boolean isRenovation, int noOfLanes, double length, double width,
                            boolean hasGeoChallenge, boolean hasBridges, boolean hasTunnels, String isPublished) {
        super("Roads", budget, start, end, title, customer, size, isRenovation, isPublished);
        this.noOfLanes = noOfLanes;
        this.length = length;
        this.width = width;
        this.hasGeoChallenge = hasGeoChallenge;
        this.hasBridges = hasBridges;
        this.hasTunnels = hasTunnels;
    }

    /**
     * Constructor for RoadConstruction projects, default settings
     *
     * @param title    Title of the project
     * @param customer Name of the customer attached to the project
     */
    public RoadConstruction(String title, String customer) {
        super("Roads", 1000000, String.valueOf(LocalDate.now()), new MyDate(new MyDate(String.valueOf(LocalDate.now())).endDate(18).toStringDate()).toStringDate(),
                title, customer, -1, false, "Local");
        super.setEndDate(super.getStartDate().endDate(18));
        noOfLanes = 0;
        length = 0;
        width = 0;
        hasGeoChallenge = false;
        hasBridges = false;
        hasTunnels = false;
    }

    /**
     * gets if the project has or not bridges
     *
     * @return true if the project has bridges and false if it doesn't
     */
    public boolean getHasBridges() {
        return hasBridges;
    }

    /**
     * gets whether the has project has or not tunnels
     *
     * @return true if the project has tunnels and flase if it doesn't
     */
    public boolean getHasTunnels() {
        return hasTunnels;
    }

    /**
     * sets the length of the road
     *
     * @param length the length width to be changed with.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * gets the length of the road
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * sets the width of the road
     *
     * @param width the desired width to be changed with.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * gets the width of the road
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * returns whether the project has or not geographical challenges
     *
     * @return true if the project has any geographical challenges and false if it does not
     */
    public boolean getHasGeoChallenge() {
        return hasGeoChallenge;
    }

    /**
     * gets the number of lanes
     *
     * @return number of Lanes
     */
    public int getNoOfLanes() {
        return noOfLanes;
    }

    /**
     * Checks if the given object is the same as the RoadConstruction one
     *
     * @param obj the desired project to be compared with.
     * @return true if the given object is the same as the RoadConstruction object and false if the given object is different from the RoadConstruction object
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        RoadConstruction other = (RoadConstruction) obj;
        return super.equals(other) && hasBridges == other.hasBridges && hasTunnels == other.hasTunnels && length == other.length
                && width == other.width && hasGeoChallenge == other.hasGeoChallenge && noOfLanes == other.noOfLanes;
    }
}