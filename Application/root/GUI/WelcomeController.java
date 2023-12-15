package GUI;

import Model.ProjectManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

/**
 * Controller that takes care of welcoming display.
 *
 * @author Sergiu Chirap
 * @version 1.0
 */
public class WelcomeController {

    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;
    @FXML
    public Button quickNewProject;
    @FXML
    public Button quickViewProject;
    @FXML
    public Button quickAnalytics;
    @FXML
    public Button quickPublishWeb;
    @FXML
    public Button quickSettings;
    @FXML
    private MenuItem menuNew, menuSettings, menuQuit;
    @FXML
    private Hyperlink gitHub;

    /**
     * Controller initiator.
     *
     * @param handler link to the ViewHandler.
     * @param target  sets Controllers stage.
     * @param manager link to the ProjectManager.
     */
    public void init(ViewHandler handler, Scene target, ProjectManager manager) {
        this.handler = handler;
        this.target = target;
        this.manager = manager;
    }

    /**
     * Gets Controller scene.
     *
     * @return a Scene which is Controllers scene.
     */
    public Scene getScene() {
        return target;
    }

    /**
     * A set of ViewHandler petitions preset.
     *
     * @param e an ActionEvent stating the chosen preset.
     */
    public void quickActions(ActionEvent e) {
        if (e.getSource() == quickNewProject || e.getSource() == menuNew) {
            handler.openView("NewProject");
        } else if (e.getSource() == quickViewProject) {
            handler.openView("BrowseProject");
        } else if (e.getSource() == quickAnalytics) {
            handler.openView("Analytics");
        } else if (e.getSource() == quickPublishWeb) {
            handler.openView("PublishWeb");
        } else if (e.getSource() == quickSettings || e.getSource() == menuSettings) {
            handler.openView("Settings");
        } else if (e.getSource() == menuQuit) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Are you sure?", ButtonType.YES,
                    ButtonType.NO);
            alert.setTitle("QUIT");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                System.exit(0);
            }
        } else if (e.getSource() == gitHub) {
            try {
                Desktop.getDesktop().browse(new URL("https://github.com/Taggerkov/bob-application").toURI());
            } catch (Exception k) {
                System.out.println("Repository not available!");
            }
        }
    }
}