package GUI;

import Model.ProjectManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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
        if (e.getSource() == quickNewProject) {
            handler.openView("NewProject");
        } else if (e.getSource() == quickViewProject) {
            handler.openView("BrowseProject");
        } else if (e.getSource() == quickAnalytics) {
            handler.openView("Analytics");
        } else if (e.getSource() == quickPublishWeb) {
            handler.openView("PublishWeb");
        } else if (e.getSource() == quickSettings) {
            handler.openView("Settings");
        } else if (e.getSource() == quickCancel) {
            handler.openView("Welcome");
        }
    }
}
