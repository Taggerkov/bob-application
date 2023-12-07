package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGUI extends Application
{

  @Override public void start(Stage primaryStage) throws Exception
  {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gui.fxml"));
    Parent root = fxmlLoader.load();

    GuiController guiController = fxmlLoader.getController();
    ViewHandler viewHandler = new ViewHandler(primaryStage);
    guiController.setViewHandler(viewHandler);

    Scene scene = new Scene(root);
    primaryStage.setTitle("Bob construction");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
