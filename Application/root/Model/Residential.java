package Model;

public class Residential extends Project
{
  private int noOfKitchens;
  private int noOfBathrooms;
  private int roomsWPlumbing;
  private boolean isRenovation;
  private double size;

  public Residential(double budget, String start, String end, int noOfKitchens, int noOfBathrooms, int roomsWPlumbing, boolean isRenovation, double size)
  {
    super(budget, start, end);
    this.noOfKitchens = noOfKitchens;
    this.noOfBathrooms = noOfBathrooms;
    this.roomsWPlumbing = roomsWPlumbing;
    this.isRenovation = isRenovation;
    this.size = size;

  }
  public Residential()
  {
   super(100000, String.valueOf(java.time.LocalDate.now()), String.valueOf(java.time.LocalDate.now()));
    
   //Temporary solution. Not sure how we make the end date in this format
   noOfKitchens = 1;
   noOfBathrooms = 1;
   roomsWPlumbing = 1;
   isRenovation = false;
   size = 0;
  }
  public void setNoOfKitchens(int noOfKitchens)
  {
    this.noOfKitchens = noOfKitchens;
  }
  public int getNoOfKitchens()
  {
    return noOfKitchens;
  }
  public void setNoOfBathrooms(int noOfBathrooms)
  {
    this.noOfBathrooms = noOfBathrooms;
  }
  public int getNoOfBathrooms()
  {
    return noOfBathrooms;
  }
  public void setRoomsWPlumbing(int roomsWPlumbing)
  {
    this.roomsWPlumbing = roomsWPlumbing;
  }
  public int getRoomsWPlumbing()
  {
    return roomsWPlumbing;
  }
  public void setIsRenovation(boolean isRenovation)
  {
    this.isRenovation = isRenovation;
  }
  public boolean getIsRenovation()
  {
    return isRenovation;
  }
  public void setSize(double size)
  {
    this.size = size;
  }
  public double getSize()
  {
    return size;
  }
}
