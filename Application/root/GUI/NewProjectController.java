// NewProjectController.java
package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewProjectController implements Initializable {
  private ViewHandler viewHandler;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Get the ViewHandler instance
    viewHandler = ViewHandler.getInstance(new Stage());
  }

  public void setViewHandler(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;
  }

  @FXML
  private void handleNewProject(ActionEvent event) {
    if (viewHandler != null) {
      viewHandler.switchView("NewProject.fxml", "New Project");
    } else {
      // Handle the case where viewHandler is null
      System.out.println("ViewHandler is null. Make sure to set it before calling methods.");
    }
  }

  @FXML
  private void handleViewProject(ActionEvent event) {
    if (viewHandler != null) {
      viewHandler.switchView("AllProjects.fxml", "View Project");
    } else {
      // Handle the case where viewHandler is null
      System.out.println("ViewHandler is null. Make sure to set it before calling methods.");
    }
  }

  @FXML
  private void handleAnalytics(ActionEvent event) {
    if (viewHandler != null) {
      viewHandler.switchView("Analytics.fxml", "Analytics");
    } else {
      // Handle the case where viewHandler is null
      System.out.println("ViewHandler is null. Make sure to set it before calling methods.");
    }
  }

  @FXML
  private void handlePublishWeb(ActionEvent event) {
    if (viewHandler != null) {
      viewHandler.switchView("Publish.fxml", "Publish Web");
    } else {
      // Handle the case where viewHandler is null
      System.out.println("ViewHandler is null. Make sure to set it before calling methods.");
    }
  }

  @FXML
  private void handleSettings(ActionEvent event) {
    if (viewHandler != null) {
      viewHandler.switchView("Settings.fxml", "Settings");
    } else {
      // Handle the case where viewHandler is null
      System.out.println("ViewHandler is null. Make sure to set it before calling methods.");
    }
  }

  public String getViewHandler() {
    if (viewHandler != null) {
      // You can return relevant information about the ViewHandler here
      return viewHandler.toString();
    } else {
      return "ViewHandler is null. Make sure to set it before calling methods.";
    }
  }
}
