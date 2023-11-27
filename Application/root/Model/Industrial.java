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
  public Industrial ()
  {
    super(2000000,String.valueOf(java.time.LocalDate.now()), "30 months");
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
