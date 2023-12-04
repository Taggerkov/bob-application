package Model;

public class RoadConstruction extends Project {
    /**
     * Class for RoadConstruction, extension of the class Project
     * @author Salomeea Tricolici
     * @version 1.0
     */
    private boolean hasBridges;
    private boolean hasTunnels;
    private double length;
    private double width;
    private boolean hasGeoChallenge;
    private int noOfLanes;

    /**
     * Full constructor for RoadConstruction class
     * @param budget
     * @param start
     * @param end
     * @param hasBridges
     * @param hasTunnels
     * @param length
     * @param width
     * @param hasGeoChallenge
     * @param noOfLanes
     */

    public RoadConstruction(double budget, String start, String end, boolean hasBridges,
                            boolean hasTunnels, double length, double width, boolean hasGeoChallenge, int noOfLanes) {
        super(budget, start, end);
        this.hasBridges = hasBridges;
        this.hasTunnels = hasTunnels;
        this.length = length;
        this.width = width;
        this.hasGeoChallenge= hasGeoChallenge;
        this.noOfLanes = noOfLanes;
    }
    /**
     * Constructor for RoadConstruction projects, default settings
     *     @param title     Title of the project
     *     @param customer  Name of the customer attached to the project
     */
    public RoadConstruction(String title, String customer)
    {
        super(1000000, title, customer);
        super.setEndDate(super.getStartDate().endDate(18));
        hasBridges = false;
        hasTunnels = false;
        length = 0;
        width = 0;
        hasGeoChallenge = false;
        noOfLanes = 0;

    }

    /**
     * sets the project to have or not bridges
     * No bridges by default
     * @param hasBridges
     */
    private void setHasBridges(boolean hasBridges){
        this.hasBridges = hasBridges;
    }

    /**
     * gets if the project has or not bridges
     * @return true if the project has bridges and false if it doesn't
     */
    private boolean getHasBridges(){
        return  hasBridges;
    }

    /**
     * sets the project to have or not tunnels
     * @param hasTunnels
     * no tunnels by default
     */
    private void setHasTunnels(boolean hasTunnels){
        this.hasTunnels = hasTunnels;
    }

    /**
     * gets whether the has project has or not tunnels
     * @return true if the project has tunnels and flase if it doesn't
     */
    private boolean getHasTunnels(){
        return hasTunnels;
    }

    /**
     * sets the length of the road
     * @param length
     */

    private void setLength(double length){
        this.length = length;
    }

    /**
     * gets the length of the road
     * @return length
     */
    private double getLength(){
        return length;
    }

    /**
     * sets the width of the road
     * @param width
     */
    private void setWidth(double width){
        this.width = width;
    }

    /**
     * gets the width of the road
     * @return width
     */
    private double getWidth(){
        return width;
    }

    /**
     * sets the project to have or not geographical challenges
     * not geoChallenges by default
     * @param hasGeoChallenge
     */
    private void setHasGeoChallenge(boolean hasGeoChallenge){
        this.hasGeoChallenge = hasGeoChallenge;
    }

    /**
     * returns whether the project has or not geographical challenges
     * @return true if the project has any geographical challenges and false if it does not
     */
    private boolean getHasGeoChallenge(){
        return hasGeoChallenge;
    }

    /**
     * sets the number of lines
     * @param noOfLanes
     */
    private void setNoOfLanes(int noOfLanes){
        this.noOfLanes = noOfLanes;
    }

    /**
     * gets the number of lanes
     * @return number of Lanes
     */
    private int getNoOfLanes(){
        return noOfLanes;
    }

    /**
     *
     * @param obj
     * @return true if the given object is the same as the RoadConstruction object and false if the given object is different from the RoadConstruction object
     */

    public boolean equals(Object obj){
        if(obj== null || obj.getClass()!= this.getClass())
            return false;
        RoadConstruction other = (RoadConstruction)obj;
        return super.equals(other) && hasBridges == other.hasBridges && hasTunnels == other.hasTunnels && length == other.length
                && width == other.width && hasGeoChallenge == other.hasGeoChallenge && noOfLanes == other.noOfLanes;
    }


}
