package Model;

import Utils.FileHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("Saves/projects.bin");
            ObjectInputStream read = new ObjectInputStream(fileIn);
            ProjectList a = (ProjectList) read.readObject();
            System.out.println(a.get(0).getTitle());
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ImageView customImage = new ImageView(new Image("/home/mani/Desktop/img.jpg", 100, 80, false, true));
        alert.setGraphic(customImage);
        alert.showAndWait();
        FlowPane a = new FlowPane();
    }
}
