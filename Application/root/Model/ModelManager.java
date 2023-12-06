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

}
