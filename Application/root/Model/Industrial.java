package Model;

public class Industrial
{
  private double size;
  private String typeOfFacility;

  public Industrial(double size, String typeOfFacility)
  {
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
