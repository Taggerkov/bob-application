package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import Model.ModelManager;

import java.io.IOException;

public class ViewHandler {
  private Stage stage;
  private GuiController guiController;
  private NewProjectController newProjectController;
  private ProjCustomController projCustomController;
  private AllProjectsController allProjectsController;
  private ProjQuickController projQuickController;
  private PublishController publishController;
  private AnalyticsController analyticsController;
  private ManageController manageController;
  private ModelManager modelManager;

  public ViewHandler(Stage stage, ModelManager modelManager) {
    this.stage = stage;
    this.modelManager = modelManager;
    initializeControllers();
  }

  private void initializeControllers() {
    try {
      FXMLLoader guiLoader = new FXMLLoader();
      guiLoader.setLocation(getClass().getResource("Gui.fxml")); // Adjust the path accordingly
      Region guiRoot = guiLoader.load();
      guiController = guiLoader.getController();
      guiController.init(this, modelManager, guiRoot);

      // Repeat similar steps for other controllers...

      // Set the view handler after initializing controllers
      guiController.setViewHandler(this);

    } catch (IOException e) {
      e.printStackTrace();
      // Handle the exception accordingly
    }
  }


  public void openView(String id) {
    switch (id) {
      case "gui":
        stage.setScene(new Scene(guiController.getRoot()));
        guiController.reset();
        break;
      case "newProject":
        stage.setScene(new Scene(newProjectController.getRoot()));
        newProjectController.reset();
        break;
      // Add cases for other views
    }
  }
}