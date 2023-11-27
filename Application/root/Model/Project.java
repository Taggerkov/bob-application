package Model;

public abstract class Project {
    private double budget;
    private Resources resources;
    private final MyDate startDate;
    private MyDate endDate;
    private boolean isActive;

    public Project(double budget, String start, String end) {
        this.budget = budget;
        this.resources = new Resources();
        this.startDate = new MyDate(start);
        this.endDate = new MyDate(end);
        this.isActive = true;
    }
    
    public Project(double budget, String start) {
        this.budget = budget;
        this.resources = new Resources();
        this.startDate = new MyDate(start);
        this.endDate = null;
        this.isActive = true;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getBudget() {
        return budget;
    }

    public boolean isActive() {
        return isActive;
    }
}
