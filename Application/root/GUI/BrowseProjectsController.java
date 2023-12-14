package GUI;

import Model.MyDate;
import Model.Project;
import Model.ProjectList;
import Model.ProjectManager;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
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
 * Browse Projects Controller // Project Browser class.
 *
 * @author Sergiu Chirap
 * @version 0.5
 */
public class BrowseProjectsController {
    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;
    private ArrayList<String> autoTitles;
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
    }

    /**
     * Resets all inputs, making it look like a freshly opened scene.
     */
    public void set() {
        flowPane.getChildren().clear();
        ProjectList allProjects = null;

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
            autoTitles = new ArrayList<>();
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
            TextFields.bindAutoCompletion(autoComplete, autoTitles);
        }
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

    public void labelLink(ActionEvent e) {
        handler.openView("Welcome");
    }
}
