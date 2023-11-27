package Model;

public class Commercial extends Project {
    private int noOfFloors;
    private double size;
    private String intendedUse;

    public Commercial(double budget, String start, String end, int noOfFloors, double size, String intendedUse) {
        super(budget, start, end);
        this.noOfFloors = noOfFloors;
        this.size = size;
        this.intendedUse = intendedUse;
    }

    public Commercial(){
        super(500000, String.valueOf(java.time.LocalDate.now()));
        this.noOfFloors = 1;
        //end 'Date' would default 18 months.
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getIntendedUse() {
        return intendedUse;
    }

    public void setIntendedUse(String intendedUse) {
        this.intendedUse = intendedUse;
    }
}
