package GUI;

import Model.ModelManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application {

    public void start(Stage window)
    {
        ModelManager manager = new ModelManager();
        ViewHandler viewHandler = new ViewHandler(window, manager);
        viewHandler.start();
    }
}
