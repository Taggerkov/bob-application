package Model;

public class Resources
{
  private double manHours;
  private  double expenses;
  private double expectedManHours;
  private double expectedExpenses;
public Resources()
{

}

public void setManHours(double manHours)
{
  this.manHours=manHours;
}

public double getManHours()
{
  return manHours;
}
public void setExpenses()
{
  this.expenses=expenses;
}
  public double getExpenses()
  {
    return expenses;
  }

  public double getExpectedManHours()
  {
    return expectedManHours;
  }

  public void setExpectedManHours(double expectedManHours)
  {
    this.expectedManHours = expectedManHours;
  }

  public double getExpectedExpenses()
  {
    return expectedExpenses;
  }

  public void setExpectedExpenses(double expectedExpenses)
  {
    this.expectedExpenses = expectedExpenses;
  }
}

