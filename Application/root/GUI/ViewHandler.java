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
    private AnalyticsController AnalyticsController;
    private PublishWebController PublishWebController;
    private ProjectManager manager;

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
        String title = "BOB'S SOFTWARE - ";
        switch (id) {
            case "Welcome":
                target.setScene(WelcomeController.getScene());
                WelcomeController.reset();
                title += "Welcome!";
                break;
            case "NewProject":
                target.setScene(NewProjectController.getScene());
                NewProjectController.reset();
                title += "New Project";
                break;
            case "BrowseProject":
                target.setScene(BrowseProjectsController.getScene());
                BrowseProjectsController.reset();
                title += "Browse Projects";
                break;
            case "Analytics":
                target.setScene(AnalyticsController.getScene());
                AnalyticsController.reset();
                title += "Analytics";
                break;
            case "PublishWeb":
                target.setScene(PublishWebController.getScene());
                PublishWebController.reset();
                title += "Publish Web";
                break;
        }

        if (target.getScene().getRoot().getUserData() != null) {
            title = target.getScene().getRoot().getUserData().toString();
        }

        target.setTitle(title);
        target.show();
    }

    public void openProject(int index){

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