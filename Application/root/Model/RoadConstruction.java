package Model;

public class RoadConstruction extends Project {

    private boolean hasBridges;
    private boolean hasTunnels;
    private double length;
    private double width;
    private boolean hasGeoChallenge;
    private int noOfLanes;

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
    public RoadConstruction()
    {
        super(1000000, String.valueOf(java.time.LocalDate.now()), "");
        hasBridges = false;
        hasTunnels = false;
        length = 0;
        width = 0;
        hasGeoChallenge = false;
        noOfLanes = 0;

    }
    private void setHasBridges(boolean hasBridges){
        this.hasBridges = hasBridges;
    }
    private boolean getHasBridges(){
        return  hasBridges;
    }
    private void setHasTunnels(boolean hasTunnels){
        this.hasTunnels = hasTunnels;
    }
    private boolean getHasTunnels(){
        return hasTunnels;
    }
    private void setLength(double length){
        this.length = length;
    }
    private double getLength(){
        return length;
    }
    private void setWidth(double width){
        this.width = width;
    }
    private double getWidth(){
        return width;
    }
    private void setHasGeoChallenge(boolean hasGeoChallenge){
        this.hasGeoChallenge = hasGeoChallenge;
    }
    private boolean getHasGeoChallenge(){
        return hasGeoChallenge;
    }
    private void setNoOfLanes(int noOfLanes){
        this.noOfLanes = noOfLanes;
    }
    private int getNoOfLanes(){
        return noOfLanes;
    }


}
