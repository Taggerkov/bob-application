package GUI;

import GUI.ViewHandler;
import Model.ModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    ModelManager modelManager = new ModelManager("");
    ViewHandler viewHandler = new ViewHandler(primaryStage, modelManager);

    // Open the initial view (replace "gui" with the appropriate view ID)
    viewHandler.openView("gui");

    primaryStage.setTitle("Your Application Title");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}