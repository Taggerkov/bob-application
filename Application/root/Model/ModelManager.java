package Model;

import Utils.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Model manager connecting the model with the file handler
 *
 * @author Alexandria Hansen
 * @version 1.0
 * */
public class ModelManager
{
  private String fileName;

  /**
   * One-argument constructor setting the filename
   *
   * @param fileName file name and path where the projects will be saved
   */
  public ModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  /**
   * Method to retrieve all projects from files using FileHandler
   *
   * @return a ProjectList with all projects stored in files
   */
  public ProjectList getAllProjects()
  {
    ProjectList allProjects = new ProjectList();
    try
    {
      allProjects = (ProjectList) FileHandler.getFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allProjects;
  }

  /**
   * Method to retrieve all projects of a specific type
   *
   * @param type the project type being isolated
   * @return a ProjectList with all projects of the given type
   */
  public ProjectList getProjectType(String type)
{
    type.toUpperCase();
    if(type.equals("ROAD CONSTRUCTION"))
      type = "ROADCONSTRUCTION";

    ProjectList projectType = new ProjectList();
    ProjectList allProjects = getAllProjects();

    for (int i = 0; i < allProjects.size(); i++)
    {
      if(allProjects.getType(i).equals(type))
        projectType.add(allProjects.get(i));
    }
    return projectType;
}

  /**
   * Save a list of projects in files using the FileHandler
   *
   * @param projects list of projects to be saved in files
   */
  public void saveProjects(ProjectList projects)
{
  try
  {
    FileHandler.convertToBinaryFile(fileName, projects);
  }
  catch (FileNotFoundException e)
  {
    System.out.println("File not found");
  }
  catch (IOException e)
  {
    System.out.println("IO Error writing to file");
  }
}

  /**
   * Boolean determining if a project title exists for any saved projects
   *
   * @param title the title to be compared to all project titles
   * @return true if no project exists with the given title, false if the title is taken
   */
  public boolean titleAvailable(String title)
{
  ProjectList allProjects = getAllProjects();

  for (int i = 0; i < allProjects.size(); i++)
  {
    if(allProjects.getTitle(i).equals(title))
      return false;
  }
  return true;
}

  /**
   * Searches through all projects in files to find one with a given title
   * @param title the title being searched for in all files
   * @return project with the given title if it exists
   */
  public Project getProject(String title)
{
  ProjectList allProjects = getAllProjects();

  for (int i = 0; i < allProjects.size(); i++)
  {
    if(allProjects.getTitle(i).equals(title))
      return allProjects.get(i);
  }
  return null;
}
}
