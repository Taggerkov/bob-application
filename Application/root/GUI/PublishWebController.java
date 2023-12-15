package GUI;

import Model.ProjectList;
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
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;

/**
 * Controller that takes care of web publishing the projects.
 *
 * @author Raj, Sergiu Chirap
 */
public class PublishWebController {
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

    /**
     * Parses project into a .xml which will be later injected into the web page.
     *
     * @throws ParserException a parser exception.
     */
    public void confirmButtonClick() throws ParserException {
        ProjectList allProjects = manager.readAllProjects();
        ProjectList unpublishedProjects = new ProjectList();

        for (int i = 0; i < allProjects.size(); i++) {
            if ((allProjects.get(i).getIsPublished()).equals("Publish")) {
                unpublishedProjects.add(allProjects.get(i));
            }
        }

        XmlJsonParser parser = new XmlJsonParser();

        // Specify the full file path
        String filePath = "bob-webpage/xml/PublisingFile.xml";

        // Create the File object with the specified path
        File xmlFile = new File(filePath);

        xmlFile = parser.toXml(unpublishedProjects, filePath);
        System.out.println("XML file: " + xmlFile.getAbsolutePath());

    }

}


