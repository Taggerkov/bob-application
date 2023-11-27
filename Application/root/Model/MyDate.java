package Model;

public class MyDate
{
  private int day;
  private int month;
  private  int year;

  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  public MyDate(String date){
    String[] temp = date.split("-");
    this.year = Integer.parseInt(temp[0]);
    this.month = Integer.parseInt(temp[1]);
    this.day = Integer.parseInt(temp[2]);
  }

  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }
}
