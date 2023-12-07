package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable
{

    @FXML
    private VBox main;

    @FXML
    private MenuBar menuBar;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private HBox welcomeBox;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private Label versionLabel;

    @FXML
    private Hyperlink githubLink;

    @FXML
    private HBox footerBox;

    @FXML
    private Label copyrightLabel;
    private ViewHandler viewHandler;

    // Add more @FXML annotated fields for other UI elements as needed

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize your GUI components, set listeners, etc.
    }

    // You can add methods for handling button clicks or other actions

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


    // Add more methods for handling other actions as needed

    private void loadFXML(String fxmlFileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately for your application
        }
    }

    // Add more methods for handling other actions as needed
}
