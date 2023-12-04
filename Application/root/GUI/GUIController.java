package GUI;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GUIController {
    private Scene scene;
    private ModelManager modelManager;
    private ViewHandler viewHandler;

    @FXML private Button newProject;
    @FXML private Button manageProject;
    @FXML private Button analytics;
    @FXML private Button publishWeb;
    @FXML private Button settings;

}
