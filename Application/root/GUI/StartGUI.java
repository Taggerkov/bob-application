package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGUI extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Create an instance of ViewHandler
    ViewHandler viewHandler = ViewHandler.getInstance(primaryStage);

    // Load the GUI FXML file and set the ViewHandler for GuiController
    FXMLLoader guiLoader = new FXMLLoader(getClass().getResource("Gui.fxml"));
    Parent guiRoot = guiLoader.load();
    GuiController guiController = guiLoader.getController();
    guiController.setViewHandler(viewHandler);

    // Set the scene
    Scene scene = new Scene(guiRoot);
    primaryStage.setTitle("Bob construction");
    primaryStage.setScene(scene);
    primaryStage.show();

    // Debug information
    System.out.println("GuiController.viewHandler: " + guiController.getViewHandler());
  }

  public static void main(String[] args) {
    launch(args);
  }
}
