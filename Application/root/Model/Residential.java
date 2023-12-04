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
   * @param budget
   * @param start
   * @param end
   * @param noOfKitchens
   * @param noOfBathrooms
   * @param roomsWPlumbing
   * @param isRenovation
   * @param size
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
   */
  public Residential(String title, String customer)
  {
   super(100000, String.valueOf(java.time.LocalDate.now()), String.valueOf(java.time.LocalDate.now()), title, customer);
   super.setEndDate(super.getEndDate().endDate(9));
   noOfKitchens = 1;
   noOfBathrooms = 1;
   roomsWPlumbing = 1;
   isRenovation = false;
   size = 0;
  }

  /**
   * Sets number of kitchens to the input value
   *
   * @param noOfKitchens
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
   * @param noOfBathrooms
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
   * @param roomsWPlumbing
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
   * Sets the size of the building in m^3 to the input value
   *
   * @param size
   */
  public void setSize(double size)
  {
    this.size = size;
  }

  /**
   * Gets the size of the building
   *
   * @return the size of the building in m^3
   */
  public double getSize()
  {
    return size;
  }

  /**
   * Override of the equals method in Object class. Checks if the input object is the same as a given Residential project
   *
   * @param obj
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
