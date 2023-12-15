package GUI;

import Model.ProjectManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Gui initiator.
 *
 * @author Sergiu Chirap
 * @version 1.5
 */
public class StartGUI extends Application {

    /**
     * Links ProjectManager with ViewHandler.
     *
     * @param window the primary stage for this application, onto which
     *               the application scene can be set.
     *               Applications may create other stages, if needed, but they will not be
     *               primary stages.
     */
    public void start(Stage window) {
        //checks if there is a save file and creates one if needed - Sergiu
        try {
            FileInputStream fileIn = new FileInputStream("Saves/projects.bin");
            ObjectInputStream read = new ObjectInputStream(fileIn);
            fileIn.close();
            read.close();
        } catch (Exception e) {
            try {
                FileOutputStream fileOut = new FileOutputStream("Saves/projects.bin");
                ObjectOutputStream write = new ObjectOutputStream(fileOut);
                fileOut.close();
                write.close();
            } catch (Exception E) {
                System.out.println("Unable to I/O!");
                E.printStackTrace();
                System.exit(0);
            }
        }

        ProjectManager manager = new ProjectManager("Saves/projects.bin");
        ViewHandler viewHandler = new ViewHandler(window, manager);
        viewHandler.start();
    }
}
