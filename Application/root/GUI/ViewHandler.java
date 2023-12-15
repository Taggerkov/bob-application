package GUI;

import Model.ProjectManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A GUI Manager that handles and links all other Controllers with their FXML files.
 *
 * @author Sergiu Chirap
 * @version 1.5
 */
public class ViewHandler {

    private Stage target;
    private WelcomeController WelcomeController;
    private NewProjectController NewProjectController;
    private BrowseProjectsController BrowseProjectsController;
    private EditProjectController EditProjectController;
    private AnalyticsController AnalyticsController;
    private PublishWebController PublishWebController;
    private final ProjectManager manager;
    private String css = "light";

    /**
     * ViewHandler Constructor.
     *
     * @param target  links JavaFX stage.
     * @param manager link to the ProjectManager.
     */
    public ViewHandler(Stage target, ProjectManager manager) {
        this.target = target;
        this.manager = manager;
    }

    /**
     * ViewHandler initiator.
     */
    public void start() {
        loadWelcome();
        loadNewProject();
        loadBrowseProjects();
        loadAnalytics();
        loadPublishWebController();
        target.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
        target.setResizable(false);
        openView("Welcome");
    }

    /**
     * Redirects display to the chosen Controller.
     *
     * @param id a String stating Controllers id.
     */
    public void openView(String id) {
        String sceneTitle = "BOB'S SOFTWARE - ";
        switch (id) {
            case "Welcome":
                WelcomeController.getScene().getStylesheets().clear();
                target.setScene(WelcomeController.getScene());
                if (css.equals("light")) {
                    WelcomeController.getScene().getStylesheets().add(getClass().getResource("light.css").toExternalForm());
                } else if (css.equals("dark")) {
                    WelcomeController.getScene().getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
                }
                sceneTitle += "Welcome!";
                break;
            case "NewProject":
                NewProjectController.getScene().getStylesheets().clear();
                target.setScene(NewProjectController.getScene());
                if (css.equals("light")) {
                    NewProjectController.getScene().getStylesheets().add(getClass().getResource("light.css").toExternalForm());
                } else if (css.equals("dark")) {
                    NewProjectController.getScene().getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
                }
                NewProjectController.reset();
                sceneTitle += "New Project";
                break;
            case "BrowseProject":
                BrowseProjectsController.getScene().getStylesheets().clear();
                target.setScene(BrowseProjectsController.getScene());
                if (css.equals("light")) {
                    BrowseProjectsController.getScene().getStylesheets().add(getClass().getResource("light.css").toExternalForm());
                } else if (css.equals("dark")) {
                    BrowseProjectsController.getScene().getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
                }
                BrowseProjectsController.set();
                sceneTitle += "Browse Projects";
                break;
            case "Analytics":
                AnalyticsController.getScene().getStylesheets().clear();
                target.setScene(AnalyticsController.getScene());
                if (css.equals("light")) {
                    AnalyticsController.getScene().getStylesheets().add(getClass().getResource("light.css").toExternalForm());
                } else if (css.equals("dark")) {
                    AnalyticsController.getScene().getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
                }
                sceneTitle += "Analytics";
                break;
            case "PublishWeb":
                PublishWebController.getScene().getStylesheets().clear();
                target.setScene(PublishWebController.getScene());
                if (css.equals("light")) {
                    PublishWebController.getScene().getStylesheets().add(getClass().getResource("light.css").toExternalForm());
                } else if (css.equals("dark")) {
                    PublishWebController.getScene().getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
                }
                sceneTitle += "Publish Web";
                break;
            case "Settings":
                ImageView imageView = new ImageView((new Image("file:Application/root/Utils/logo.gif", 75, 75, true, true)));
                ButtonType light = new ButtonType("Light");
                ButtonType dark = new ButtonType("Dark");
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Choose view style:\n(You will be redirected to the main page.)",
                        light, dark, ButtonType.CANCEL);
                alert.setTitle("SETTINGS");
                alert.setHeaderText("Z - MANAGER: SETTINGS");
                alert.setGraphic(imageView);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                alert.showAndWait();
                if (alert.getResult() == light) {
                    this.css = "light";
                    openView("Welcome");
                } else if (alert.getResult() == dark) {
                    this.css = "dark";
                    openView("Welcome");
                }
        }

        if (target.getScene().getRoot().getUserData() != null) {
            sceneTitle = target.getScene().getRoot().getUserData().toString();
        }

        target.setTitle(sceneTitle);
        target.show();
    }

    /**
     * Special redirect for EditProjectController which needs additional data to load.
     *
     * @param title a String stating projects name.
     * @param type  a String stating projects type.
     */
    public void openProject(String title, String type) {
        loadEditProject();
        String sceneTitle = "BOB'S SOFTWARE - ";
        EditProjectController.getScene().getStylesheets().clear();
        target.setScene(EditProjectController.getScene());
        if (css.equals("light")) {
            EditProjectController.getScene().getStylesheets().add(getClass().getResource("light.css").toExternalForm());
        } else if (css.equals("dark")) {
            EditProjectController.getScene().getStylesheets().add(getClass().getResource("dark.css").toExternalForm());
        }
        EditProjectController.loadProject(title);
        sceneTitle += type + ": " + title;
        if (target.getScene().getRoot().getUserData() != null) {
            sceneTitle = target.getScene().getRoot().getUserData().toString();
        }
        target.setTitle(sceneTitle);
        target.show();
    }

    /**
     * Loader for WelcomeController.
     */
    private void loadWelcome() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Welcome.fxml"));
            Region root = loader.load();
            WelcomeController = loader.getController();
            WelcomeController.init(this, new Scene(root), manager);
        } catch (IOException e) {
            //displays I/O error for FXML - Sergiu
            System.out.println("FXML not found!");
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "FXML (Welcome.fxml) not found!",
                    ButtonType.CLOSE);
            alert.setTitle("CRITICAL ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                System.exit(0);
            }
        }
    }

    /**
     * Loader for NewProjectController.
     */
    private void loadNewProject() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("NewProject.fxml"));
            Region root = loader.load();
            NewProjectController = loader.getController();
            NewProjectController.init(this, new Scene(root), manager);
        } catch (IOException e) {
            //displays I/O error for FXML - Sergiu
            System.out.println("FXML not found!");
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "FXML (NewProject.fxml) not found!",
                    ButtonType.CLOSE);
            alert.setTitle("CRITICAL ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                System.exit(0);
            }
        }

    }

    /**
     * Loader for BrowseProjectsController.
     */
    private void loadBrowseProjects() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("BrowseProjects.fxml"));
            Region root = loader.load();
            BrowseProjectsController = loader.getController();
            BrowseProjectsController.init(this, new Scene(root), manager);
        } catch (IOException e) {
            //displays I/O error for FXML - Sergiu
            System.out.println("FXML not found!");
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "FXML (BrowseProjects.fxml) not found!",
                    ButtonType.CLOSE);
            alert.setTitle("CRITICAL ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                System.exit(0);
            }
        }
    }

    /**
     * Loader for EditProjectController.
     */
    private void loadEditProject() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("EditProject.fxml"));
            Region root = loader.load();
            EditProjectController = loader.getController();
            EditProjectController.init(this, new Scene(root), manager);
        } catch (IOException e) {
            //displays I/O error for FXML - Sergiu
            System.out.println("FXML not found!");
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "FXML (EditProject.fxml) not found!",
                    ButtonType.CLOSE);
            alert.setTitle("CRITICAL ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                System.exit(0);
            }
        }

    }

    /**
     * Loader for AnalyticsController.
     */
    private void loadAnalytics() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Analytics.fxml"));
            Region root = loader.load();
            AnalyticsController = loader.getController();
            AnalyticsController.init(this, new Scene(root), manager);
        } catch (IOException e) {
            //displays I/O error for FXML - Sergiu
            System.out.println("FXML not found!");
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "FXML (Analytics.fxml) not found!",
                    ButtonType.CLOSE);
            alert.setTitle("CRITICAL ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                System.exit(0);
            }
        }
    }

    /**
     * Loader for PublishWebController.
     */
    private void loadPublishWebController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PublishWeb.fxml"));
            Region root = loader.load();
            PublishWebController = loader.getController();
            PublishWebController.init(this, new Scene(root), manager);
        } catch (IOException e) {
            //displays I/O error for FXML - Sergiu
            System.out.println("FXML not found!");
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "FXML (PublishWeb.fxml) not found!",
                    ButtonType.CLOSE);
            alert.setTitle("CRITICAL ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                System.exit(0);
            }
        }
    }
}