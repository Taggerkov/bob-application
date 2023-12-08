package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private Stage primaryStage;

  public ViewHandler(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  public void switchView(String fxmlFileName, String title) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
      Parent root = fxmlLoader.load();
      Scene scene = new Scene(root);
      primaryStage.setTitle(title);
      primaryStage.setScene(scene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void show() {
    primaryStage.show();
  }
}
