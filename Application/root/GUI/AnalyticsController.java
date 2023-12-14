package GUI;

import Model.ProjectManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AnalyticsController {
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
    public Button quickCancel;
    @FXML
    private MenuItem menuNew, menuCancel, menuSettings, menuQuit;

    public void init(ViewHandler handler, Scene target, ProjectManager manager) {
        this.handler = handler;
        this.target = target;
        this.manager = manager;
    }

    public void reset() {
    }

    public Scene getScene() {
        return target;
    }

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
        } else if (e.getSource() == quickCancel || e.getSource() == menuCancel) {
            handler.openView("Welcome");
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
        }
    }
}
