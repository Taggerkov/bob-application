package GUI;

import Model.ProjectManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;

public class StartGUI extends Application {

    public void start(Stage window) {
        try {
            // Check if the directory exists, create it if not
            File savesDirectory = new File("Saves");
            if (!savesDirectory.exists()) {
                savesDirectory.mkdir();
            }

            // Now, try to open the file
            FileInputStream fileIn = new FileInputStream("Saves/projects.bin");
            fileIn.close();  // Close the input stream
            System.out.println(".bin file detected.");
        } catch (FileNotFoundException e) {
            try {
                // If the file doesn't exist, create it
                FileOutputStream fileOut = new FileOutputStream("Saves/projects.bin");
                fileOut.close();  // Close the output stream
                System.out.println(".bin file created.");
            } catch (IOException ex) {
                System.out.println("Unable to I/O!");
                ex.printStackTrace();
                System.exit(0);
            }
        } catch (IOException e) {
            // Handle other IOExceptions if needed
            e.printStackTrace();
        }

        ProjectManager manager = new ProjectManager("Saves/projects.bin");
        ViewHandler viewHandler = new ViewHandler(window, manager);
        viewHandler.start();
    }
}