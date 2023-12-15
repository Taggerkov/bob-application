package GUI;

import Model.MyDate;
import Model.Project;
import Model.ProjectList;
import Model.ProjectManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Controller that takes care of project browsing.
 *
 * @author Sergiu Chirap
 * @version 1.5
 */
public class BrowseProjectsController {
    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;
    @FXML
    public TextField autoComplete;
    @FXML
    private Button quickNewProject, quickViewProject, quickAnalytics, quickPublishWeb, quickSettings, quickCancel;
    @FXML
    private Label labelTitle, isEmpty, labelStart, labelEnd, labelType, labelCustomer, labelBuild, labelPublish;
    @FXML
    private VBox labelBox, labelActive;
    @FXML
    private FlowPane flowPane;
    @FXML
    private MenuItem menuNew, menuCancel, menuSettings, menuQuit, menuReset;

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
     * Visually injects all projects into the GUI and links their IDs to the EditProjectController.
     */
    public void set() {
        flowPane.getChildren().clear();
        ProjectList allProjects = null;
        autoComplete.setText("");

        //checks if the file has been deleted and creates one if needed - Sergiu
        try {
            FileInputStream fileIn = new FileInputStream("Saves/projects.bin");
            ObjectInputStream read = new ObjectInputStream(fileIn);
            fileIn.close();
            read.close();
        } catch (Exception e) {
            try {
                FileOutputStream fileOut = new FileOutputStream("Saves/projects.bin");
                ObjectOutputStream write = new ObjectOutputStream(fileOut);
                fileOut.close();
                write.close();
            } catch (Exception k) {
                System.out.println("Unable to I/O!");
                k.printStackTrace();
                System.exit(0);
            }
        }

        allProjects = manager.readAllProjects();

        //checks if file is empty - Sergiu
        if (allProjects == null) {
            isEmpty.setVisible(true);
        } else {
            isEmpty.setVisible(false);
            ArrayList<String> autoTitles = new ArrayList<>();
            for (int i = allProjects.size(); i > 0; i--) {
                Project temp = allProjects.get(i - 1);

                String type = temp.getType();
                String title = temp.getTitle();
                autoTitles.add(title);
                String customer = "-" + temp.getCustomer() + "-";
                MyDate start = temp.getStartDate();
                MyDate end = temp.getEndDate();
                boolean active = temp.isActive();
                boolean isRenovation = temp.isRenovation();
                String isPublished = temp.getIsPublished();

                VBox x = new VBox();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ProjectLabel.fxml"));
                loader.setController(this);
                try {
                    x = loader.load();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
                flowPane.getChildren().add(x);
                FlowPane.setMargin(x, new Insets(10, 10, 10, 5));
                labelTitle.setText(title);
                labelStart.setText(start.toString());
                labelEnd.setText(end.toString());
                labelType.setText(type.toUpperCase());
                labelCustomer.setText(customer);
                if (isRenovation) labelBuild.setText("R");
                else labelBuild.setText("NB");
                switch (isPublished) {
                    case "Local":
                        labelPublish.setText("L");
                        break;
                    case "Publish":
                        labelPublish.setText("P");
                        break;
                    case "Online":
                        labelPublish.setText("O");
                        break;
                }
                if (active) {
                    labelActive.setStyle("-fx-background-color:lightgreen; -fx-background-radius:15px; " +
                            "-fx-border-color:black; -fx-border-radius:15px; -fx-border-width:1px");
                } else {
                    labelActive.setStyle("-fx-background-color:red; -fx-background-radius:15px; " +
                            "-fx-border-color:black; -fx-border-radius:15px; -fx-border-width:1px");
                }
                labelBox.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> handler.openProject(title, type));
            }
            //adds autocomplete function VM arg (--add-exports javafx.base/com.sun.javafx.event=ALL-UNNAMED) needed!
            TextFields.bindAutoCompletion(autoComplete, autoTitles);
        }
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
        } else if (e.getSource() == quickViewProject || e.getSource() == menuReset) {
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
     * Redirects the user to the EditProjectController with the linked ID inputted.
     *
     * @param e an ActionEvent which activates this method.
     */
    public void openProject(ActionEvent e) {
        if (!autoComplete.getText().isEmpty()) {
            try {
                Project project = manager.getProject(autoComplete.getText());
                handler.openProject(project.getTitle(), project.getType());
            } catch (Exception k) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Project doesn't exist!",
                        ButtonType.CLOSE);
                alert.setTitle("INVALID INPUT");
                alert.setHeaderText(null);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CLOSE) {
                    alert.close();
                }
            }
        }
    }
}