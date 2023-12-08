package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

  private static ViewHandler instance;
  private Stage primaryStage;

  // Private constructor to prevent instantiation
  private ViewHandler(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  // Static method to get the instance
  public static ViewHandler getInstance(Stage primaryStage) {
    if (instance == null) {
      instance = new ViewHandler(primaryStage);
    }
    return instance;
  }

  public void switchView(String fxmlFileName, String title) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
      Parent root = fxmlLoader.load();
      Scene scene = new Scene(root);
      primaryStage.setTitle(title);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      System.err.println("Error loading FXML file: " + fxmlFileName);
      e.printStackTrace();
      // You can show an alert or handle the exception in a way suitable for your application
    } catch (Exception e) {
      System.err.println("Error switching view to " + fxmlFileName);
      e.printStackTrace();
      // Handle other exceptions if needed
    }
  }

  public void show() {
    primaryStage.show();
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }
}
