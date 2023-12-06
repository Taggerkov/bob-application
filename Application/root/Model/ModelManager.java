package Model;

import Utils.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ModelManager
{
  private String fileName;

  public ModelManager(String fileName)
  {
    this.fileName = fileName;
  }

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
public ProjectList getProjectType(String type)
{
    type.toUpperCase();
    ProjectList projectType = new ProjectList();
    ProjectList allProjects = getAllProjects();

    for (int i = 0; i < allProjects.size(); i++)
    {
      if(allProjects.getType(i).equals(type))
        projectType.add(allProjects.get(i));
    }
    return projectType;
}
}
