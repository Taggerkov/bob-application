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

import java.awt.*;
import java.io.IOException;

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

    public ViewHandler(Stage target, ProjectManager manager) {
        this.target = target;
        this.manager = manager;
    }

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
                WelcomeController.reset();
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
                AnalyticsController.reset();
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
                PublishWebController.reset();
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