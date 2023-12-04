package Model;

/**
 * Class for Residential projects
 *
 * @author Alexandria Hansen
 * @version 1.0
 */
public class Residential extends Project
{
  private int noOfKitchens;
  private int noOfBathrooms;
  private int roomsWPlumbing;
  private boolean isRenovation;
  private double size;

  /**
   * Full constructor for custom Residential projects
   *
   * @param budget          Starting budget for the project
   * @param start           Start date for the project
   * @param end             Expected end date for the project
   * @param title           Unique title for the project
   * @param customer        Name of the customer attached to the project
   * @param noOfKitchens    Number of kitchens
   * @param noOfBathrooms   Number of bathrooms
   * @param roomsWPlumbing  Number of rooms with plumbing excluding bathrooms and kitchens
   * @param isRenovation    Parameter for whether the project is a renovation or a new build
   * @param size            Size of the building in m^2
   *
   */
  public Residential(double budget, String start, String end, String title, String customer, int noOfKitchens, int noOfBathrooms, int roomsWPlumbing, boolean isRenovation, double size)
  {
    super(budget, start, end, title, customer);
    this.noOfKitchens = noOfKitchens;
    this.noOfBathrooms = noOfBathrooms;
    this.roomsWPlumbing = roomsWPlumbing;
    this.isRenovation = isRenovation;
    this.size = size;

  }

  /**
   * Constructor for Residential projects, default values
   *
   * @param title     Unique title for the project
   * @param customer  Name of the customer attached to the project
   */
  public Residential(String title, String customer)
  {
   super(100000, title, customer);
   super.setEndDate(super.getStartDate().endDate(9));
   noOfKitchens = 1;
   noOfBathrooms = 1;
   roomsWPlumbing = 1;
   isRenovation = false;
   size = 0;
  }

  /**
   * Sets number of kitchens to the input value
   *
   * @param noOfKitchens desired number of kitchens for the building
   */
  public void setNoOfKitchens(int noOfKitchens)
  {
    this.noOfKitchens = noOfKitchens;
  }

  /**
   * Gets the number of kitchens the building has/should have
   *
   * @return number of kitchens
   */
  public int getNoOfKitchens()
  {
    return noOfKitchens;
  }

  /**
   * Sets number of bathrooms to the input value
   *
   * @param noOfBathrooms  Desired number of bathrooms for the building
   */
  public void setNoOfBathrooms(int noOfBathrooms)
  {
    this.noOfBathrooms = noOfBathrooms;
  }

  /**
   * Gets the number of bathrooms the building has/should have
   *
   * @return number of bathrooms
   */
  public int getNoOfBathrooms()
  {
    return noOfBathrooms;
  }

  /**
   * Sets the number of rooms with plumbing in the building to the input value
   *
   * @param roomsWPlumbing  Desired number of rooms with plumbing, not counting kitchens and bathrooms
   */
  public void setRoomsWPlumbing(int roomsWPlumbing)
  {
    this.roomsWPlumbing = roomsWPlumbing;
  }

  /**
   * Gets the number of rooms with plumbing excluding kitchens and bathrooms the building has/should have
   *
   * @return the number of rooms with plumbing in the building, not counting bathrooms and kitchens
   */
  public int getRoomsWPlumbing()
  {
    return roomsWPlumbing;
  }

  /**
   * Sets the parameter for whether the project is a renovation or a new build
   *
   * @param isRenovation if true the project is a renovation, if false the project is a new build
   */
  public void setIsRenovation(boolean isRenovation)
  {
    this.isRenovation = isRenovation;
  }

  /**
   * Gets the value of whether the project is a renovation or a new build
   *
   * @return true if the project is a renovation, false if the project is a new build.
   */
  public boolean getIsRenovation()
  {
    return isRenovation;
  }

  /**
   * Sets the size of the building in m^2 to the input value
   *
   * @param size  Size of the building in m^2
   */
  public void setSize(double size)
  {
    this.size = size;
  }

  /**
   * Gets the size of the building
   *
   * @return the size of the building in m^2
   */
  public double getSize()
  {
    return size;
  }

  /**
   * Override of the equals method in Object class. Checks if the input object is the same as a given Residential project
   *
   * @param obj Object to be compared with the project
   * @return true if the input object is the same as the residential project, false if the object is null or different from the Residential project
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != this.getClass())
      return false;
    Residential other = (Residential) obj;
    return super.equals(other) && noOfKitchens == other.noOfKitchens && noOfBathrooms == other.noOfBathrooms && roomsWPlumbing == other.roomsWPlumbing && isRenovation == other.isRenovation && size==other.size;
  }
}
