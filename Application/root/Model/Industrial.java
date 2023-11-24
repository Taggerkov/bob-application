package Model;

public class Industrial extends Project
{
  private double size;
  private String typeOfFacility;

  public Industrial(double budget, String start, String end,double size, String typeOfFacility)
  {
    super(budget, start, end);
    this.size = size;
    this.typeOfFacility = typeOfFacility;
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
}
