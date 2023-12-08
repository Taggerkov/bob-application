package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AllProjectsController implements Initializable {

  private ViewHandler viewHandler;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Initialization code, if needed
    viewHandler = ViewHandler.getInstance(new Stage());
  }

  public AllProjectsController(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  // Alternatively, you can use a setter method
  public void setViewHandler(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }




  @FXML
  private void handleAllNewProject(ActionEvent event)
  {
    if (viewHandler != null)
    {
      viewHandler.switchView("NewProject.fxml", "New Project");
    }
    else
    {
      // Handle the case where viewHandler is null
      System.out.println(
          "ViewHandler is null. Make sure to set it before calling methods.");
    }
  }
  @FXML
  private void handleAllViewProject(ActionEvent event) {
    if (viewHandler != null)
    {
      viewHandler.switchView("ViewProject.fxml", "View Project");
    }
    else
    {
      // Handle the case where viewHandler is null
      System.out.println(
          "ViewHandler is null. Make sure to set it before calling methods.");
    }
  // This method is in the GuiController, so it's not needed here.
    // You can remove or leave it empty.
  }

  @FXML
  private void handleAllAnalytics(ActionEvent event) {
    if (viewHandler != null)
    {
      viewHandler.switchView("Analytics.fxml", "Analytics");
    }
    else
    {
      // Handle the case where viewHandler is null
      System.out.println(
          "ViewHandler is null. Make sure to set it before calling methods.");
    }
  }

  @FXML
  private void handleAllPublishWeb(ActionEvent event) {
    if (viewHandler != null)
    {
      viewHandler.switchView("Publish.fxml", "Publish");
    }
    else
    {
      // Handle the case where viewHandler is null
      System.out.println(
          "ViewHandler is null. Make sure to set it before calling methods.");
    }
  }

  @FXML
  private void handleAllSettings(ActionEvent event) {
    if (viewHandler != null)
    {
      viewHandler.switchView("Settings.fxml", "Settings");
    }
    else
    {
      // Handle the case where viewHandler is null
      System.out.println(
          "ViewHandler is null. Make sure to set it before calling methods.");
    }
  }
}
