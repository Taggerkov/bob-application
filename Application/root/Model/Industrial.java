package Model;

public class Industrial extends Project
{
  private double size;
  private String typeOfFacility;

  public Industrial(double budget, String start, String end, String title, String customer,double size, String typeOfFacility)
  {
    super(budget, start, end, title, customer);
    this.size = size;
    this.typeOfFacility = typeOfFacility;
  }
  public Industrial (String title, String customer)
  {
    super(2000000, title, customer);
    super.setEndDate(super.getStartDate().endDate(30));
    size = 0.00;
    typeOfFacility = "Unspecified";
  }

  public double getSize()
  {
    return size;
  }

  public void setSize(double size)
  {
    this.size = size;
  }

  public String getTypeOfFacility()
  {
    return typeOfFacility;
  }

  public void setTypeOfFacility(String typeOfFacility)
  {
    this.typeOfFacility = typeOfFacility;
  }
  public boolean equals(Object obj)
  {
    if (obj== null || obj.getClass()!=this.getClass())
      return false;
    Industrial other=(Industrial) obj;
    return super.equals(other) && size==other.size && typeOfFacility.equals(other.typeOfFacility);
  }
}
