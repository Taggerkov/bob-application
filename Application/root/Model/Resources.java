package Model;

public class Resources
{
  private double manHours;
  private double expenses;
  private double expectedManHours;
  private double expectedExpenses;

  public Resources(double expectedExpenses, double expectedManHours)
  {
    this.expectedExpenses = expectedExpenses;
    this.expectedManHours = expectedManHours;
    expenses = 0;
    manHours = 0;
  }
  public Resources()
{
  manHours = 0;
  expenses = 0;
  expectedExpenses = 0;
  expectedManHours = 0;
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

