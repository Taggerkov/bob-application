package GUI;

import Model.ProjectManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StartGUI extends Application {

    public void start(Stage window)
    {
        try{
            FileInputStream fileIn = new FileInputStream("Saves/projects.bin");
            ObjectInputStream read = new ObjectInputStream(fileIn);
            System.out.println(".bin file detected.");
        } catch (Exception e){
            try{
                FileOutputStream fileOut = new FileOutputStream("Saves/projects.bin");
                ObjectOutputStream write = new ObjectOutputStream(fileOut);
                System.out.println(".bin file created.");
            } catch (Exception E){
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
