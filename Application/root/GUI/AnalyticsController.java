package GUI;

import Model.*;
import Utils.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Controller that takes care of project Analytics exportation.
 *
 * @author Sergiu Chirap
 * @version 1.0
 */
public class AnalyticsController {
    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;

    @FXML
    public Button quickNewProject, quickViewProject, quickAnalytics, quickPublishWeb, quickSettings, quickCancel, expResidential, expCommercial, expIndustrial, expRoads;
    @FXML
    private MenuItem menuNew, menuCancel, menuSettings, menuQuit;

    /**
     * Controller initiator.
     *
     * @param handler link to the ViewHandler.
     * @param target  sets Controllers stage.
     * @param manager link to the ProjectManager.
     */
    public void init(ViewHandler handler, Scene target, ProjectManager manager) {
        this.handler = handler;
        this.target = target;
        this.manager = manager;
    }

    /**
     * Gets Controller scene.
     *
     * @return a Scene which is Controllers scene.
     */
    public Scene getScene() {
        return target;
    }

    /**
     * A set of ViewHandler petitions preset.
     *
     * @param e an ActionEvent stating the chosen preset.
     */
    public void quickActions(ActionEvent e) {
        if (e.getSource() == quickNewProject || e.getSource() == menuNew) {
            handler.openView("NewProject");
        } else if (e.getSource() == quickViewProject) {
            handler.openView("BrowseProject");
        } else if (e.getSource() == quickAnalytics) {
            handler.openView("Analytics");
        } else if (e.getSource() == quickPublishWeb) {
            handler.openView("PublishWeb");
        } else if (e.getSource() == quickSettings || e.getSource() == menuSettings) {
            handler.openView("Settings");
        } else if (e.getSource() == quickCancel || e.getSource() == menuCancel) {
            handler.openView("Welcome");
        } else if (e.getSource() == menuQuit) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Are you sure?", ButtonType.YES,
                    ButtonType.NO);
            alert.setTitle("QUIT");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                System.exit(0);
            }
        }
    }

    /**
     * Extracts some data from all project of chosen type, calculates their analysis and saves it to a .txt file inside the 'Saves' folder.
     *
     * @param e an ActionEvent which states the project type.
     */
    public void export(ActionEvent e) {
        try {
            //extracts all data - Sergiu
            ProjectList list;
            ArrayList<String> Customers = new ArrayList<>();
            ArrayList<Double> Budgets = new ArrayList<>();
            ArrayList<MyDate> StartDates = new ArrayList<>();
            ArrayList<Double> Sizes = new ArrayList<>();
            ArrayList<Boolean> Builds = new ArrayList<>();

            ArrayList<Integer> Kitchens = new ArrayList<>();
            ArrayList<Integer> Bathrooms = new ArrayList<>();
            ArrayList<Integer> Plumbings = new ArrayList<>();
            ArrayList<Integer> Floors = new ArrayList<>();
            ArrayList<Boolean> Bridges = new ArrayList<>();
            ArrayList<Boolean> Tunnels = new ArrayList<>();
            ArrayList<Boolean> Geos = new ArrayList<>();
            ArrayList<Integer> Lanes = new ArrayList<>();
            ArrayList<Double> Length = new ArrayList<>();
            ArrayList<Double> Width = new ArrayList<>();

            if (e.getSource() == expResidential) {
                list = manager.readProjectType("Residential");

                ProjectList temp = manager.readAllProjects();
                for (int i = 0; i < temp.size(); i++) {
                    if (Objects.equals(temp.get(i).getType(), "Residential")) {
                        list.add(temp.get(i));
                    }
                }

                for (int i = 0; i < list.size(); i++) {
                    Customers.add(list.get(i).getCustomer());
                    Budgets.add(list.get(i).getBudget());
                    StartDates.add(list.get(i).getStartDate());
                    Sizes.add(list.get(i).getSize());
                    Builds.add(list.get(i).isRenovation());

                    Residential residential = (Residential) list.get(i);

                    Kitchens.add(residential.getNoOfKitchens());
                    Bathrooms.add(residential.getNoOfBathrooms());
                    Plumbings.add(residential.getRoomsWPlumbing());
                }

            } else if (e.getSource() == expCommercial) {
                list = manager.readProjectType("Commercial");

                ProjectList temp = manager.readAllProjects();
                for (int i = 0; i < temp.size(); i++) {
                    if (Objects.equals(temp.get(i).getType(), "Commercial")) {
                        list.add(temp.get(i));
                    }
                }

                for (int i = 0; i < list.size(); i++) {
                    Customers.add(list.get(i).getCustomer());
                    Budgets.add(list.get(i).getBudget());
                    StartDates.add(list.get(i).getStartDate());
                    Sizes.add(list.get(i).getSize());
                    Builds.add(list.get(i).isRenovation());

                    Commercial commercial = (Commercial) list.get(i);

                    Floors.add(commercial.getNoOfFloors());
                }

            } else if (e.getSource() == expIndustrial) {
                list = manager.readProjectType("Industrial");

                ProjectList temp = manager.readAllProjects();
                for (int i = 0; i < temp.size(); i++) {
                    if (Objects.equals(temp.get(i).getType(), "Industrial")) {
                        list.add(temp.get(i));
                    }
                }

                for (int i = 0; i < list.size(); i++) {
                    Customers.add(list.get(i).getCustomer());
                    Budgets.add(list.get(i).getBudget());
                    StartDates.add(list.get(i).getStartDate());
                    Sizes.add(list.get(i).getSize());
                    Builds.add(list.get(i).isRenovation());
                }

            } else if (e.getSource() == expRoads) {
                list = manager.readProjectType("Roads");

                ProjectList roads = manager.readAllProjects();
                for (int i = 0; i < roads.size(); i++) {
                    if (Objects.equals(roads.get(i).getType(), "Roads")) {
                        list.add(roads.get(i));
                    }
                }

                for (int i = 0; i < 1; i++) {
                    Customers.add(list.get(i).getCustomer());
                    Budgets.add(list.get(i).getBudget());
                    StartDates.add(list.get(i).getStartDate());
                    Sizes.add(list.get(i).getSize());
                    Builds.add(list.get(i).isRenovation());

                    RoadConstruction roadConstruction = (RoadConstruction) list.get(i);

                    Bridges.add(roadConstruction.getHasBridges());
                    Tunnels.add(roadConstruction.getHasTunnels());
                    Geos.add(roadConstruction.getHasGeoChallenge());
                    Lanes.add(roadConstruction.getNoOfLanes());
                    Length.add(roadConstruction.getLength());
                    Width.add(roadConstruction.getWidth());
                }
            }

            //checks most repeated customer - Sergiu
            int count = 1;
            int max = 0;
            String MostCustomer = null;
            for (int i = 1; i < Customers.size(); i++) {
                if (Objects.equals(Customers.get(i), Customers.get(i - 1))) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                        MostCustomer = Customers.get(i - 1);
                    }
                    count = 1;
                }
            }
            if (count > max) {
                max = count;
                MostCustomer = Customers.get(Customers.size() - 1);
            }

            //checks highest and lowest budgets - Sergiu
            double budgetMax = Collections.max(Budgets);
            double budgetMin = Collections.min(Budgets);
            //checks average - Sergiu
            double budgetAverage = 0;
            int index = 0;
            for (Double aDouble : Budgets) {
                budgetAverage += aDouble;
                index++;
            }
            budgetAverage = budgetAverage / index;

            //checks latest and newest date - Sergiu
            MyDate check;
            MyDate dateLatest = null;
            MyDate dateNewest = null;
            for (MyDate startDate : StartDates) {
                if (dateLatest != null) {
                    check = startDate;
                    if (!dateLatest.isBefore(check)) {
                        dateLatest = check;
                    } else if (dateNewest.isBefore(check)) {
                        dateNewest = check;
                    }
                } else {
                    dateLatest = startDate;
                    dateNewest = startDate;
                }
            }
            // extracts date titles - Sergiu
            String dateLatestTitle = null;
            String dateNewestTitle = null;
            ProjectList temp = manager.readAllProjects();
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).getStartDate().equals(dateNewest)) {
                    dateNewestTitle = temp.getTitle(i);
                }
                if (temp.get(i).getStartDate().equals(dateLatest)) {
                    dateLatestTitle = temp.getTitle(i);
                }
            }

            //checks highest, lowest sizes and average - Sergiu
            double sizeMax = Collections.max(Budgets);
            double sizeMin = Collections.min(Budgets);
            //checks average - Sergiu
            double sizeAverage = 0;
            index = 0;
            for (Double budget : Budgets) {
                budgetAverage += budget;
                index++;
            }
            sizeAverage = sizeAverage / index;

            //checks most repeated build - Sergiu
            count = 1;
            max = 0;
            Boolean tempBuild = null;
            String MostBuild = null;
            for (int i = 1; i < Customers.size(); i++) {
                if (Objects.equals(Builds.get(i), Builds.get(i - 1))) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                        tempBuild = Builds.get(i - 1);
                    }
                    count = 1;
                }
            }
            if (count > max) {
                max = count;
                tempBuild = Builds.get(Builds.size() - 1);
            }
            if (tempBuild) MostBuild = "Renovation";
            else MostBuild = "New Build";
            if (e.getSource() == expResidential) {
                //checks average kitchens - Sergiu
                int averageKitchens = 0;
                index = 0;
                for (Integer kitchen : Kitchens) {
                    averageKitchens += kitchen;
                    index++;
                }
                averageKitchens = averageKitchens / index;

                //checks average bathrooms - Sergiu
                int averageBathrooms = 0;
                index = 0;
                for (Integer bathroom : Bathrooms) {
                    averageBathrooms += bathroom;
                    index++;
                }
                averageBathrooms = averageBathrooms / index;

                //checks average plumbing - Sergiu
                int averagePlumbing = 0;
                index = 0;
                for (Integer plumbing : Plumbings) {
                    averagePlumbing += plumbing;
                    index++;
                }
                averagePlumbing = averagePlumbing / index;

                //builds & exports analysis - Sergiu
                String msg = "RESIDENTIAL\nExportation Date: " + LocalDate.now() + "\n///////////////////////////////////////////////////////////////////////////\n\n" +
                        "Common Customer: " + MostCustomer + "\nAverage Budget: " + budgetAverage + "\nHighest Budget: " + budgetMax + "\nLowest Budget: " + budgetMin +
                        "\nLatest Project: " + dateLatestTitle + " - " + dateLatest + "\nNewest Project: " + dateNewestTitle + " - " + dateNewest + "\nAverage Size: "
                        + sizeAverage + "\nBiggest Size: " + sizeMax + "\nSmallest Size: " + sizeMin + "\nFavourite Build: " + MostBuild + "\n------------------------------------"
                        + "\nAverage Kitchens: " + averageKitchens + "\nAverage Bathrooms: " + averageBathrooms + "\nAverage Plumbing: " + averagePlumbing + "\n\n"
                        + "///////////////////////////////////////////////////////////////////////////\nZ-MANAGER 1.0\n© 2023 Bob the Builder. All rights reserved.";
                String path = "Saves/residential_" + LocalDate.now() + "_" + LocalTime.now().getHour() + LocalTime.now().getMinute() +
                        LocalTime.now().getSecond() + ".txt";
                try {
                    FileHandler.writeToTextFile(path, msg);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Check 'Saves' folder.",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS EXPORTED");
                    alert.setHeaderText("Analysis has been be exported!");
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        Desktop.getDesktop().open(new File(path));
                    }
                } catch (Exception k) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Analysis couldn't be exported!",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS NOT EXPORTED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }
            } else if (e.getSource() == expCommercial) {
                //checks average floors - Sergiu
                int averageFloors = 0;
                index = 0;
                for (Integer floors : Floors) {
                    averageFloors += floors;
                    index++;
                }
                averageFloors = averageFloors / index;

                //builds & exports analysis - Sergiu
                String msg = "COMMERCIAL\nExportation Date: " + LocalDate.now() + "\n///////////////////////////////////////////////////////////////////////////\n\n" +
                        "Common Customer: " + MostCustomer + "\nAverage Budget: " + budgetAverage + "\nHighest Budget: " + budgetMax + "\nLowest Budget: " + budgetMin +
                        "\nLatest Project: " + dateLatestTitle + " - " + dateLatest + "\nNewest Project: " + dateNewestTitle + " - " + dateNewest + "\nAverage Size: "
                        + sizeAverage + "\nBiggest Size: " + sizeMax + "\nSmallest Size: " + sizeMin + "\nFavourite Build: " + MostBuild + "\n------------------------------------"
                        + "\nAverage Floors: " + averageFloors + "\n\n"
                        + "///////////////////////////////////////////////////////////////////////////\nZ-MANAGER 1.0\n© 2023 Bob the Builder. All rights reserved.";
                String path = "Saves/commercial_" + LocalDate.now() + "_" + LocalTime.now().getHour() + LocalTime.now().getMinute() +
                        LocalTime.now().getSecond() + ".txt";
                try {
                    FileHandler.writeToTextFile(path, msg);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Check 'Saves' folder.",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS EXPORTED");
                    alert.setHeaderText("Analysis has been be exported!");
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        Desktop.getDesktop().open(new File(path));
                    }
                } catch (Exception k) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Analysis couldn't be exported!",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS NOT EXPORTED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }
            } else if (e.getSource() == expIndustrial) {
                //builds & exports analysis - Sergiu
                String msg = "INDUSTRIAL\nExportation Date: " + LocalDate.now() + "\n///////////////////////////////////////////////////////////////////////////\n\n" +
                        "Common Customer: " + MostCustomer + "\nAverage Budget: " + budgetAverage + "\nHighest Budget: " + budgetMax + "\nLowest Budget: " + budgetMin +
                        "\nLatest Project: " + dateLatestTitle + " - " + dateLatest + "\nNewest Project: " + dateNewestTitle + " - " + dateNewest + "\nAverage Size: "
                        + sizeAverage + "\nBiggest Size: " + sizeMax + "\nSmallest Size: " + sizeMin + "\nFavourite Build: " + MostBuild + "\n\n"
                        + "///////////////////////////////////////////////////////////////////////////\nZ-MANAGER 1.0\n© 2023 Bob the Builder. All rights reserved.";
                String path = "Saves/industrial_" + LocalDate.now() + "_" + LocalTime.now().getHour() + LocalTime.now().getMinute() +
                        LocalTime.now().getSecond() + ".txt";
                try {
                    FileHandler.writeToTextFile(path, msg);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Check 'Saves' folder.",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS EXPORTED");
                    alert.setHeaderText("Analysis has been be exported!");
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        Desktop.getDesktop().open(new File(path));
                    }
                } catch (Exception k) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Analysis couldn't be exported!",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS NOT EXPORTED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }
            } else if (e.getSource() == expRoads) {
                //checks amount of builds - Sergiu
                int amountBuilds = 0;
                for (Boolean build : Builds) {
                    if (build) {
                        amountBuilds++;
                    }
                }

                //checks amount of tunnels - Sergiu
                int amountTunnels = 0;
                for (Boolean tunnel : Builds) {
                    if (tunnel) {
                        amountTunnels++;
                    }
                }

                //checks amount of geo challenges - Sergiu
                int amountGeos = 0;
                for (Boolean geo : Geos) {
                    if (geo) {
                        amountGeos++;
                    }
                }

                //checks amount of lanes - Sergiu
                int amountLanes = 0;
                for (Integer lane : Lanes) {
                    amountLanes++;
                }

                //checks total length - Sergiu
                int amountLength = 0;
                for (Double length : Length) {
                }
                //checks average width - Sergiu
                int averageWidth = 0;
                index = 0;
                for (Double width : Width) {
                    averageWidth += width;
                    index++;
                }
                averageWidth = averageWidth / index;

                //builds & exports analysis - Sergiu
                String msg = "RESIDENTIAL\nExportation Date: " + LocalDate.now() + "\n///////////////////////////////////////////////////////////////////////////\n\n" +
                        "Common Customer: " + MostCustomer + "\nAverage Budget: " + budgetAverage + "\nHighest Budget: " + budgetMax + "\nLowest Budget: " + budgetMin +
                        "\nLatest Project: " + dateLatestTitle + " - " + dateLatest + "\nNewest Project: " + dateNewestTitle + " - " + dateNewest + "\nAverage Size: "
                        + sizeAverage + "\nBiggest Size: " + sizeMax + "\nSmallest Size: " + sizeMin + "\nFavourite Build: " + MostBuild + "\n------------------------------------"
                        + "\nTotal Builds: " + amountBuilds + "\nTotal Tunnels: " + amountTunnels + "\nTotal Geo-Challenges: " + amountGeos + "\nTotal Lanes: " + amountLanes +
                        "\nTotal Length: " + amountLength + "\nAverage Width: " + averageWidth + "\n\n"
                        + "///////////////////////////////////////////////////////////////////////////\nZ-MANAGER 1.0\n© 2023 Bob the Builder. All rights reserved.";
                String path = "Saves/roads_" + LocalDate.now() + "_" + LocalTime.now().getHour() + LocalTime.now().getMinute() +
                        LocalTime.now().getSecond() + ".txt";
                try {
                    FileHandler.writeToTextFile(path, msg);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Check 'Saves' folder.",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS EXPORTED");
                    alert.setHeaderText("Analysis has been be exported!");
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        Desktop.getDesktop().open(new File(path));
                    }
                } catch (Exception k) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Analysis couldn't be exported!",
                            ButtonType.CLOSE);
                    alert.setTitle("ANALYSIS NOT EXPORTED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }
            }
        } catch (Exception k) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "There are no projects of this type!",
                    ButtonType.CLOSE);
            alert.setTitle("ANALYSIS NOT EXPORTED");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        }
    }
}
