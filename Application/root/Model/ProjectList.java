package Model;

import java.util.ArrayList;

public class ProjectList
{
  private ArrayList<Project> projects;
  private ArrayList<String> titles;

  public ProjectList()
  {
  }
  public Project get(int index)
  {
    if(index<projects.size())
    {
      return projects.get(index);
    }
    else
    {
      return null;
    }
  }
  public int size()
  {
    return projects.size();
  }
  public String getType(int index)
  {
    if (projects.get(index) instanceof Residential )
      return "RESIDENTIAL";
    else if(projects.get(index) instanceof Commercial)
      return "COMMERCIAL";
    else if(projects.get(index) instanceof Industrial)
      return "INDUSTRIAL";
    else if(projects.get(index) instanceof RoadConstruction)
      return "ROADCONSTRUCTION";
    else
      return "OTHER";
  }
  public void add(Project project)
  {
    projects.add(project);
  }

  public String getTitle(int index)
  {
    return projects.get(index).getTitle();
  }
}
