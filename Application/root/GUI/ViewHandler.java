package GUI;

import Model.ProjectManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

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
    private String css;

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
                target.setScene(WelcomeController.getScene());
                if (css.equals("light")){
                    WelcomeController.getScene().getStylesheets().add(getClass().getResource("file:Application/root/GUI/light.css").toExternalForm());
                }
                WelcomeController.reset();
                sceneTitle += "Welcome!";
                break;
            case "NewProject":
                target.setScene(NewProjectController.getScene());
                NewProjectController.reset();
                sceneTitle += "New Project";
                break;
            case "BrowseProject":
                target.setScene(BrowseProjectsController.getScene());
                BrowseProjectsController.set();
                sceneTitle += "Browse Projects";
                break;
            case "Analytics":
                target.setScene(AnalyticsController.getScene());
                AnalyticsController.reset();
                sceneTitle += "Analytics";
                break;
            case "PublishWeb":
                target.setScene(PublishWebController.getScene());
                PublishWebController.reset();
                sceneTitle += "Publish Web";
                break;
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
        target.setScene(EditProjectController.getScene());
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