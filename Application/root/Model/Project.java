package Model;

import java.io.Serializable;

/**
 * An abstract class parent to all other project classes.
 *
 * @author Sergiu Chirap
 * @version 2.5
 */
public abstract class Project implements Serializable {
    private final String type;
    private String title, customer;
    private double budget, size;
    private final MyDate startDate;
    private MyDate endDate;
    private boolean isActive;
    private final boolean isRenovation;
    private String isPublished;


    /**
     * Project's parent constructor. Sets up values every project type include.
     *
     * @param type         which type of project is.
     * @param budget       available budget for this project.
     * @param start        project's custom start date.
     * @param end          project's custom end date.
     * @param title        unique title of the project.
     * @param customer     customer of the project.
     * @param isRenovation if this construction is a 'New Build' or a 'Renovation'.
     */
    public Project(String type, double budget, String start, String end, String title, String customer, double size, boolean isRenovation, String isPublished) {
        this.type = type;
        this.budget = budget;
        this.startDate = new MyDate(start);
        this.endDate = new MyDate(end);
        this.isActive = true;
        this.title = title;
        this.customer = customer;
        this.size = size;
        this.isRenovation = isRenovation;
        this.isPublished = isPublished;
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

    /**
     * Gets project's title.
     * @return a String stating project's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets project's type.
     * @return a String stating project's type.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets project;s customer.
     * @return a String stating project's customer.
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Gets project's size.
     * @return a double stating project's size.
     */
    public double getSize() {
        return size;
    }

    /**
     * Checks if the project is a renovation.
     * @return a boolean stating true if it is a renovation & false if it is a new build.
     */
    public boolean isRenovation() {
        return isRenovation;
    }

    /**
     * Gets project's publish status.
     * @return a String stating project's status.
     */
    public String getIsPublished() {
        return isPublished;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
