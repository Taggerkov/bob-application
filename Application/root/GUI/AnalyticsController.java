package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AnalyticsController implements Initializable {

  private ViewHandler viewHandler;

  // Default constructor for FXML
  public AnalyticsController() {
  }

  // Constructor to set the viewHandler
  public AnalyticsController(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Initialization logic here

  }

  // Setter method to set the viewHandler
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
    if (viewHandler != null) {
      viewHandler.switchView("Publish.fxml", "Publish Web");
    } else {
      // Handle the case where viewHandler is null (maybe log an error or show an alert)
      System.err.println("viewHandler is not initialized!");
    }
  }

  @FXML
  private void handleSettings(ActionEvent event) {
    viewHandler.switchView("Settings.fxml", "Settings");
  }
}
