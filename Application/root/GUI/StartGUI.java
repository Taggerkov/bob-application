package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application {

    public void start(Stage window)
    {
        /*ProjectManager manager = new ProjectManager()("");*/
        ViewHandler viewHandler = new ViewHandler(window/*, manager*/);
        viewHandler.start();
    }
}
