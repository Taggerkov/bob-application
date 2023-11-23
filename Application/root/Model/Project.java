package Model;

public abstract class Project {
    private double budget;
    private Resources resources;
    private MyDate startDate;
    private MyDate endDate;
    private boolean isActive;

    public Project(double budget, String start, String end) {
        this.budget = budget;
        this.resources = new Resources();

        String[] temp = start.split("\\.");
        int tempDay = Integer.parseInt(temp[0]);
        int tempMonth = Integer.parseInt(temp[1]);
        int tempYear = Integer.parseInt(temp[2]);
        this.startDate = new MyDate(tempDay,tempMonth,tempYear);

        temp = end.split("\\.");
        tempDay = Integer.parseInt(temp[0]);
        tempMonth = Integer.parseInt(temp[1]);
        tempYear = Integer.parseInt(temp[2]);
        this.endDate = new MyDate(tempDay,tempMonth,tempYear);

        this.isActive = true;
    }
    
    public Project(MyDate startDate) {
        this.budget = 0;
        this.resources = new Resources();
        this.startDate = startDate;
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
