package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class NewProjectController implements Initializable
{
  private ViewHandler viewHandler;


  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  public void setViewHandler(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  @FXML
  private void handleNewProject(ActionEvent event) {
    viewHandler.switchView("NewProject.fxml", "New Project");
  }

  @FXML
  private void handleViewProject(ActionEvent event) {
    viewHandler.switchView("AllProjects.fxml", "View Project");
  }

  @FXML
  private void handleAnalytics(ActionEvent event) {
    viewHandler.switchView("Analytics.fxml", "Analytics");
  }

  @FXML
  private void handlePublishWeb(ActionEvent event) {
    viewHandler.switchView("Publish.fxml", "Publish Web");
  }

  @FXML
  private void handleSettings(ActionEvent event) {
    viewHandler.switchView("Settings.fxml", "Settings");
  }

}
