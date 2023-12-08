package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    private ViewHandler viewHandler;

    // Default constructor for FXML
    public GuiController() {
    }

    // Constructor to set the viewHandler
    public GuiController(ViewHandler viewHandler) {
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

    // Other methods...

    @FXML
    private void handlemainNewProject(ActionEvent event) {
        viewHandler.switchView("NewProject.fxml", "New Project");
    }

    @FXML
    private void handlemainViewProject(ActionEvent event) {
        viewHandler.switchView("AllProjects.fxml", "View Project");
    }

    @FXML
    private void handlemainAnalytics(ActionEvent event) {
        viewHandler.switchView("Analytics.fxml", "Analytics");
    }

    @FXML
    private void handlemainPublishWeb(ActionEvent event) {
        if (viewHandler != null) {
            viewHandler.switchView("Publish.fxml", "Publish Web");
        } else {
            // Handle the case where viewHandler is null (maybe log an error or show an alert)
            System.err.println("viewHandler is not initialized!");
        }
    }

    @FXML
    private void handlemainSettings(ActionEvent event) {
        viewHandler.switchView("Settings.fxml", "Settings");
    }
    public ViewHandler getViewHandler() {
        return viewHandler;
    }
}
