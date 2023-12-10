package GUI;

import Model.ModelManager;
import Model.ProjectManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Stage target;
    private WelcomeController WelcomeController;
    private NewProjectController NewProjectController;
    private AnalyticsController AnalyticsController;
    private PublishWebController PublishWebController;
    private ModelManager manager;

    public ViewHandler(Stage target/*, ProjectManager manager*/) {
        this.target = target;
        /*this.manager = manager;*/
    }

    public void start() {
        loadWelcome();
        loadNewProject();
        loadAnalytics();
        loadPublishWebController();
        openView("Welcome");
    }

    /*
    public void setView(String id) {
        String controller = id + "Controller";

        target.setScene(controller.getScene());
        WelcomeController.reset();
        String title = "";
        target.setTitle(title);
        target.show();
    }
    private void loadView(String id){
        String controller = id + "Controller";
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(id + ".fxml"));
            Region root = loader.load();
            controller = loader.getController();
            controller.init(this, new Scene(root), modelManager);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
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
            case "Analytics":
                target.setScene(AnalyticsController.getScene());
                AnalyticsController.reset();
                title += "Analytics";
                break;
            case "PublishWeb":
                target.setScene(PublishWebController.getScene());
                PublishWebController.reset();
                title += "Publish Web?";
                break;
        }

        if (target.getScene().getRoot().getUserData() != null) {
            title = target.getScene().getRoot().getUserData().toString();
        }

        target.setTitle(title);
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
            e.printStackTrace();
            System.out.println("SEX");
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
            e.printStackTrace();
            System.out.println("SEX");
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
            e.printStackTrace();
            System.out.println("SEX");
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
            e.printStackTrace();
            System.out.println("SEX");
        }
    }
}