package Model;

/**
 * An abstract class parent to all other project classes.
 *
 * @author Sergiu Chirap
 * @version 1.2
 */
public abstract class Project {
    private double budget;
    private Resources resources;
    private final MyDate startDate;
    private MyDate endDate;
    private boolean isActive;

    /**
     * Full-Constructor. Custom use.
     *
     * @param budget project's custom budget
     * @param start  project's custom start date
     * @param end    project's custom end date
     */
    public Project(double budget, String start, String end) {
        this.budget = budget;
        this.resources = new Resources();
        this.startDate = new MyDate(start);
        this.endDate = new MyDate(end);
        this.isActive = true;
    }

    /**
     * Short-Constructor. Default use.
     *
     * @param budget project's default budget
     */
    public Project(double budget) {
        this.budget = budget;
        this.resources = new Resources();
        this.startDate = new MyDate(String.valueOf(java.time.LocalDate.now()));
        this.endDate = null;
        this.isActive = true;
    }

    /**
     * Sets project's budget.
     *
     * @param budget the 'budget' desired
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * Sets the 'active' status of the project.
     *
     * @param active 'true' if project is to be set active, else 'false'
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Gets project's budget.
     *
     * @return a double stating the 'budget'
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Gets project's 'active' status.
     *
     * @return a boolean stating the 'active' status
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Gets the project's start date.
     *
     * @return a MyDate stating the 'start date'
     */
    public MyDate getStartDate() {
        return startDate;
    }

    /**
     * Gets the project's end date.
     *
     * @return a MyDate stating the 'end date'
     */
    public MyDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the project's end date.
     *
     * @param endDate the 'end date' desired
     */
    public void setEndDate(MyDate endDate) {
        this.endDate = endDate;
    }
}
