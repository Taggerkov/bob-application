package Model;

import java.util.ArrayList;

/**
 * Class containing a list of projects
 *
 * @author Alexandria Hansen
 * @version 1.0
 */
public class ProjectList {
    private ArrayList<Project> projects;

    /**
     * No-argument constructor initialising the ProjectList
     */
    public ProjectList() {
        projects = new ArrayList<Project>();
    }

    /**
     * Get method for a student at a given index
     *
     * @param index position in the list
     * @return Project at the given position in the list
     */
    public Project get(int index) {
        if (index < projects.size()) {
            return projects.get(index);
        } else {
            return null;
        }
    }

    /**
     * Get method for the amount of projects in the list
     *
     * @return number of projects in the list
     */
    public int size() {
        return projects.size();
    }

    /**
     * Get method for the type of the project located at the given position in the list
     *
     * @param index position of the project in the lis
     * @return String with the type of the Project at the given index
     */
    public String getType(int index) {
        if (projects.get(index) instanceof Residential)
            return "RESIDENTIAL";
        else if (projects.get(index) instanceof Commercial)
            return "COMMERCIAL";
        else if (projects.get(index) instanceof Industrial)
            return "INDUSTRIAL";
        else if (projects.get(index) instanceof RoadConstruction)
            return "ROADCONSTRUCTION";
        else
            return "OTHER";
    }

    /**
     * Adds a project to the list
     *
     * @param project the project to be added to the list
     */
    public void add(Project project) {
        projects.add(project);
    }

    /**
     * Get method for the title of a project on a given position in the list
     *
     * @param index the position of the project in the list
     * @return the title of the project at the given index
     */
    public String getTitle(int index) {
        return projects.get(index).getTitle();
    }
}
