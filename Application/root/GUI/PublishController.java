package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class PublishController implements Initializable {

  @FXML
  private Button newProjectButton;

  @FXML
  private Button viewProjectButton;

  @FXML
  private Button analyticsButton;

  @FXML
  private Button publishWebButton;

  @FXML
  private Button settingsButton;

  private ViewHandler viewHandler;

  public PublishController() {
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Initialization code...

    // Example: Set default values or perform some actions
    if (newProjectButton != null) {
      newProjectButton.setDisable(false);
      newProjectButton.setStyle("");
    }
  }
  public PublishController(ViewHandler viewHandler) {
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
