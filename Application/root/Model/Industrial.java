package Model;

public class Industrial extends Project
{
  /**
   * Class for Industrial, extension of the class "Project"
   * @author Bibek
   * @version 1.0
   */
  private double size;
  private String typeOfFacility;

  /**
   * Full constructor for Industrial class
   * @param budget
   * @param start
   * @param end
   * @param title
   * @param customer
   * @param size
   * @param typeOfFacility
   */

  public Industrial(double budget, String start, String end, String title, String customer,double size, String typeOfFacility)
  {
    super(budget, start, end, title, customer);
    this.size = size;
    this.typeOfFacility = typeOfFacility;
  }

  /**
   * constructor for Industrial class, default values
   * @param title         title of the project
   * @param customer      name of the customer attached to the project
   */
  public Industrial (String title, String customer)
  {
    super(2000000, title, customer);
    super.setEndDate(super.getStartDate().endDate(30));
    size = 0.00;
    typeOfFacility = "Unspecified";
  }

  /**
   * gets the size of the building
   * @return size
   */

  public double getSize()
  {
    return size;
  }

  /**
   * sets the size of the building
   * @param size
   */
  public void setSize(double size)
  {
    this.size = size;
  }

  /**
   * gets the type of facility the building will provide
   * @return type of facility
   */

  public String getTypeOfFacility()
  {
    return typeOfFacility;
  }

  /**
   * sets the type of facility
   * @param typeOfFacility
   */

  public void setTypeOfFacility(String typeOfFacility)
  {
    this.typeOfFacility = typeOfFacility;
  }

  /**
   * Checks if the given object is the same as the Industrial one
   * @param obj
   * @return true if the given object is the same as the Industrial object and false if it is not
   */
  public boolean equals(Object obj)
  {
    if (obj== null || obj.getClass()!=this.getClass())
      return false;
    Industrial other=(Industrial) obj;
    return super.equals(other) && size==other.size && typeOfFacility.equals(other.typeOfFacility);
  }
}
