package GUI;

import Model.ProjectList;
import Model.ProjectManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Browse Projects Controller // Project Browser class.
 *
 * @author Sergiu Chirap
 * @version 0.5
 */
public class BrowseProjectsController {
    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;
    @FXML
    private Button quickNewProject;
    @FXML
    private Button quickViewProject;
    @FXML
    private Button quickAnalytics;
    @FXML
    private Button quickPublishWeb;
    @FXML
    private Button quickSettings;
    @FXML
    private Button quickCancel;
    @FXML
    private Label isEmpty;
    @FXML
    private FlowPane flowPane;

    /**
     * Sets up the first view.
     *
     * @param handler linked ViewHandler
     * @param target  linked scene
     * @param manager linked ProjectManager
     */
    public void init(ViewHandler handler, Scene target, ProjectManager manager) {
        this.handler = handler;
        this.target = target;
        this.manager = manager;

        //checks if file is empty
        VBox vBox = null;
        VBox b = null;
        VBox c = null;

        ProjectList allProjects = manager.readAllProjects();
        if (allProjects == null) {
            isEmpty.setVisible(true);
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ProjectLabel.fxml"));
            loader.setController(this);
            FXMLLoader loaderB = new FXMLLoader();
            loaderB.setLocation(getClass().getResource("ProjectLabel.fxml"));
            loader.setController(this);
            FXMLLoader loaderC = new FXMLLoader();
            loaderC.setLocation(getClass().getResource("ProjectLabel.fxml"));
            loader.setController(this);
            try {
                vBox = loader.load();
                b = loaderB.load();
                c = loaderC.load();
            } catch (Exception e){
                e.printStackTrace();
            }
            flowPane.getChildren().add(vBox);
            flowPane.getChildren().add(b);
            flowPane.getChildren().add(c);
            FlowPane.setMargin(vBox,new Insets(10,5,10,10));
            FlowPane.setMargin(b,new Insets(10,5,10,10));
            FlowPane.setMargin(c,new Insets(10,5,10,10));
        }
    }

    /**
     * Resets all inputs, making it look like a freshly opened scene.
     */
    public void reset() {
        isEmpty.setVisible(false);
    }

    /**
     * Gets the scene from it's FXML.
     *
     * @return the scene of this Controller
     */
    public Scene getScene() {
        return target;
    }

    /**
     * Group of scene changer buttons to make moving around easy and fast.
     *
     * @param e ActionEvent with quickActions() mostly being buttons
     */
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
