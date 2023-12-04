package Model;

/**
 * The {@code Resources} class represents resources associated with a project.
 * It includes information about man-hours, expenses, and expected values for both.
 *
 * @author Raj Ban
 * @version 1.0
 */
public class Resources {
  private double manHours;
  private double expenses;
  private double expectedManHours;
  private double expectedExpenses;

  /**
   * Constructs a new Resources object with the specified expected expenses and man-hours.
   *
   * @param expectedExpenses The expected expenses for the project.
   * @param expectedManHours The expected man-hours for the project.
   */
  public Resources(double expectedExpenses, double expectedManHours) {
    this.expectedExpenses = expectedExpenses;
    this.expectedManHours = expectedManHours;
    expenses = 0;
    manHours = 0;
  }

  /**
   * Constructs a new Resources object with default values for expenses and man-hours.
   */
  public Resources() {
    manHours = 0;
    expenses = 0;
    expectedExpenses = 0;
    expectedManHours = 0;
  }

  /**
   * Sets the actual man-hours for the project.
   *
   * @param manHours The actual man-hours spent on the project.
   */
  public void setManHours(double manHours) {
    this.manHours = manHours;
  }

  /**
   * Gets the actual man-hours for the project.
   *
   * @return The actual man-hours spent on the project.
   */
  public double getManHours() {
    return manHours;
  }

  /**
   * Sets the actual expenses for the project.
   *
   * @param expenses The actual expenses incurred for the project.
   */
  public void setExpenses(double expenses) {
    this.expenses = expenses;
  }

  /**
   * Gets the actual expenses for the project.
   *
   * @return The actual expenses incurred for the project.
   */
  public double getExpenses() {
    return expenses;
  }

  /**
   * Gets the expected man-hours for the project.
   *
   * @return The expected man-hours for the project.
   */
  public double getExpectedManHours() {
    return expectedManHours;
  }

  /**
   * Sets the expected man-hours for the project.
   *
   * @param expectedManHours The expected man-hours for the project.
   */
  public void setExpectedManHours(double expectedManHours) {
    this.expectedManHours = expectedManHours;
  }

  /**
   * Gets the expected expenses for the project.
   *
   * @return The expected expenses for the project.
   */
  public double getExpectedExpenses() {
    return expectedExpenses;
  }

  /**
   * Sets the expected expenses for the project.
   *
   * @param expectedExpenses The expected expenses for the project.
   */
  public void setExpectedExpenses(double expectedExpenses) {
    this.expectedExpenses = expectedExpenses;
  }

  /**
   * Checks if this Resources object is equal to another object.
   *
   * @param obj The object to compare for equality.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */


  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass())
      return false;
    Resources other = (Resources) obj;
    return manHours == other.manHours && expenses == other.expenses &&
        expectedManHours == other.expectedManHours && expectedExpenses == other.expectedExpenses;
  }
}
