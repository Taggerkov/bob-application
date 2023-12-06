package GUI;

import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class GuiController
{
    private Scene scene;
    private ModelManager modelManager;
    private ViewHandler viewHandler;

    @FXML private Button newProject;
    @FXML private Button manageProject;
    @FXML private Button analytics;
    @FXML private Button publishWeb;
    @FXML private Button settings;

    public Scene getScene()
    {
        return scene;
    }

    public void reset()
    {
    }

    public void setViewHandler(ViewHandler viewHandler)
    {
    }

    public void setRoot(Region guiRegion)
    {
    }

    public Parent getRoot()
    {
        return null;
    }

    public void init(ViewHandler viewHandler, ModelManager modelManager, Region guiRoot)
    {
    }
}
