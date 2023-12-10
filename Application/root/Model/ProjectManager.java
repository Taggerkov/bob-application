package Model;

import Utils.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Model manager connecting the model with the file handler
 *
 * @author Alexandria Hansen, Sergiu Chirap
 * @version 1.0
 */
public class ProjectManager {
    private String path;

    /**
     * ProjectManager constructor setting the file's path.
     *
     * @param path a String stating file's path
     */
    public ProjectManager(String path) {
        this.path = path;

    }

    /**
     * Method to retrieve all projects from files using FileHandler.
     *
     * @return a ProjectList with all projects stored in files
     */
    public ProjectList readAllProjects() {
        ProjectList allProjects = new ProjectList();
        try {
            allProjects = (ProjectList) FileHandler.getFromBinaryFile(path);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error reading file");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
        }
        return allProjects;
    }

    /**
     * Method to retrieve all projects of a specific type.
     *
     * @param type the project type being isolated
     * @return a ProjectList with all projects of the given type
     */
    public ProjectList readProjectType(String type) {
        ProjectList projectType = new ProjectList();
        ProjectList allProjects = readAllProjects();

        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.getType(i).equals(type))
                projectType.add(allProjects.get(i));
        }
        return projectType;
    }

    /**
     * Save a list of projects in files using the FileHandler
     *
     * @param projects list of projects to be saved in files
     */
    public void saveProjects(ProjectList projects) {
        try {
            FileHandler.saveAsBinaryFile(path, projects);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error writing to file");
            e.printStackTrace();
        }
    }

    /**
     * Boolean determining if a project title exists for any saved projects
     *
     * @param title the title to be compared to all project titles
     * @return true if no project exists with the given title, false if the title is taken
     */
    public boolean titleAvailable(String title) {
        ProjectList allProjects = readAllProjects();

        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.getTitle(i).equals(title))
                return false;
        }
        return true;
    }

    /**
     * Searches through all projects in files to find one with a given title
     *
     * @param title the title being searched for in all files
     * @return project with the given title if it exists
     */
    public Project getProject(String title) {
        ProjectList allProjects = readAllProjects();

        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.getTitle(i).equals(title))
                return allProjects.get(i);
        }
        return null;
    }

    public ProjectList getProjectByDate(String date) {
        MyDate temp = new MyDate(date);
        ProjectList allProjects = readAllProjects();
        ProjectList projectsBeforeDate = new ProjectList();

        for (int i = 0; i < allProjects.size(); i++) {
            if (allProjects.get(i).getEndDate().isBefore(temp))
                projectsBeforeDate.add(allProjects.get(i));
        }
        return projectsBeforeDate;
    }
}
