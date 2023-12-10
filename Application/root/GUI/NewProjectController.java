package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.time.LocalDate;

/**
 * New Project Controller // Project Creation.
 *
 * @author Sergiu Chirap
 * @version 1.0
 */
public class NewProjectController {
    private Scene target;
    private ModelManager manager;
    private ViewHandler handler;
    private boolean build;
    @FXML
    private Button quickNewProject;
    @FXML
    private Button quickViewProject;
    @FXML
    private Button quickAnalytics;
    @FXML
    private Button quickPublishWeb;
    @FXML
    private Button quickSettings;
    @FXML
    private Button quickCancel;
    @FXML
    private Button quickConfirm;
    @FXML
    private Label labelTitle;
    @FXML
    private TextField projectTitle;
    @FXML
    private TextField projectCustomer;
    @FXML
    private TextField projectBudget;
    @FXML
    private DatePicker projectStartDate;
    @FXML
    private DatePicker projectEndDate;
    @FXML
    private TextField projectSize;
    @FXML
    private TextField residentialKitchens = new TextField();
    @FXML
    private TextField residentialBathrooms = new TextField();
    @FXML
    private TextField residentialPlumbing = new TextField();
    @FXML
    private TextField commercialFloors = new TextField();
    @FXML
    private TextField commercialUse = new TextField();
    @FXML
    private TextField industrialType = new TextField();
    @FXML
    private CheckBox roadsBridges = new CheckBox();
    @FXML
    private CheckBox roadsTunnels = new CheckBox();
    @FXML
    private CheckBox roadsChallenges = new CheckBox();
    @FXML
    private TextField roadsLanes = new TextField();
    @FXML
    private TextField roadsLength = new TextField();
    @FXML
    private TextField roadsWidth = new TextField();
    @FXML
    private ComboBox<String> projectType;
    @FXML
    private ComboBox<String> projectBuild;

    /**
     * Sets up the first view.
     *
     * @param handler linked ViewHandler
     * @param target  linked scene
     * @param manager linked ModelManager
     */
    public void init(ViewHandler handler, Scene target, ModelManager manager) {
        this.handler = handler;
        this.target = target;
        this.manager = manager;

        //sets ComboBoxes - Sergiu
        projectType.getItems().setAll("Residential", "Commercial", "Industrial", "Roads");
        projectType.setValue("Residential");
        projectBuild.getItems().setAll("New Build", "Renovation");

        //sets StartDate preview(current) - Sergiu
        MyDate startDate = new MyDate(String.valueOf(LocalDate.now()));
        projectStartDate.setPromptText(startDate.toString());

        //sets default(Residential) type - Sergiu
        projectBudget.setPromptText("100000");
        MyDate endDate = startDate.endDate(9);
        projectEndDate.setPromptText(endDate.toString());

        residentialKitchens.setDisable(false);
        residentialBathrooms.setDisable(false);
        residentialPlumbing.setDisable(false);

        commercialFloors.setDisable(true);
        commercialUse.setDisable(true);
        industrialType.setDisable(true);
        roadsBridges.setDisable(true);
        roadsTunnels.setDisable(true);
        roadsChallenges.setDisable(true);
        roadsLanes.setDisable(true);
        roadsLength.setDisable(true);
        roadsWidth.setDisable(true);

        build = false;
    }

    /**
     * Resets all inputs, making it look like a freshly opened scene.
     */
    public void reset() {
        projectType.setValue("Residential");
        labelTitle.setText("NEW PROJECT");
        projectTitle.setText("");
        projectCustomer.setText("");
        projectBudget.setText("");
        projectSize.setText("");
        projectTitle.setStyle("");
        projectCustomer.setStyle("");
        projectBudget.setStyle("");
        projectSize.setStyle("");
        projectStartDate.setValue(null);
        projectEndDate.setValue(null);
        residentialKitchens.setText("");
        residentialBathrooms.setText("");
        residentialPlumbing.setText("");
        residentialKitchens.setStyle("");
        residentialBathrooms.setStyle("");
        residentialPlumbing.setStyle("");
        commercialFloors.setText("");
        commercialUse.setText("");
        commercialFloors.setStyle("");
        industrialType.setText("");
        roadsBridges.setSelected(false);
        roadsTunnels.setSelected(false);
        roadsChallenges.setSelected(false);
        roadsLanes.setText("");
        roadsLength.setText("");
        roadsWidth.setText("");
        roadsLanes.setStyle("");
        roadsLength.setStyle("");
        roadsWidth.setStyle("");
    }

    public Scene getScene() {
        return target;
    }

    public void quickActions(ActionEvent e) {
        if (e.getSource() == quickNewProject) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CLEAR NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("NewProject");
            }
        } else if (e.getSource() == quickViewProject) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("AllProjects");
            }
        } else if (e.getSource() == quickAnalytics) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Analytics");
            }
        } else if (e.getSource() == quickPublishWeb) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("PublishWeb");
            }
        } else if (e.getSource() == quickSettings) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Settings");
            }
        } else if (e.getSource() == quickCancel) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CANCEL NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Welcome");
            }
        } else if (e.getSource() == quickConfirm) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be saved!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CONFIRM NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                createProject();
            }
        }
    }

    /**
     * Modifies enabled inputs based on project type.
     *
     * @param e an ActionEvent with setType(), in this case a ComboBox
     */
    public void setType(ActionEvent e) {
        //extracts the chosen type from ComboBox - Sergiu
        String type = projectType.getValue();
        MyDate endDate;
        MyDate startDate = new MyDate(String.valueOf(LocalDate.now()));
        //sets, disables & enables inputs based on extracted type - Sergiu
        switch (type) {
            case "Residential":
                projectBudget.setPromptText("100000");
                endDate = startDate.endDate(9);
                projectEndDate.setPromptText(endDate.toString());

                residentialKitchens.setDisable(false);
                residentialBathrooms.setDisable(false);
                residentialPlumbing.setDisable(false);

                commercialFloors.setDisable(true);
                commercialUse.setDisable(true);
                industrialType.setDisable(true);
                roadsBridges.setDisable(true);
                roadsTunnels.setDisable(true);
                roadsChallenges.setDisable(true);
                roadsLanes.setDisable(true);
                roadsLength.setDisable(true);
                roadsWidth.setDisable(true);
                break;
            case "Commercial":
                projectBudget.setPromptText("500000");
                endDate = startDate.endDate(18);
                projectEndDate.setPromptText(endDate.toString());

                commercialFloors.setDisable(false);
                commercialUse.setDisable(false);

                residentialKitchens.setDisable(true);
                residentialBathrooms.setDisable(true);
                residentialPlumbing.setDisable(true);
                industrialType.setDisable(true);
                roadsBridges.setDisable(true);
                roadsTunnels.setDisable(true);
                roadsChallenges.setDisable(true);
                roadsLanes.setDisable(true);
                roadsLength.setDisable(true);
                roadsWidth.setDisable(true);
                break;
            case "Industrial":
                projectBudget.setPromptText("2000000");
                endDate = startDate.endDate(30);
                projectEndDate.setPromptText(endDate.toString());

                industrialType.setDisable(false);

                residentialKitchens.setDisable(true);
                residentialBathrooms.setDisable(true);
                residentialPlumbing.setDisable(true);
                commercialFloors.setDisable(true);
                commercialUse.setDisable(true);
                roadsBridges.setDisable(true);
                roadsTunnels.setDisable(true);
                roadsChallenges.setDisable(true);
                roadsLanes.setDisable(true);
                roadsLength.setDisable(true);
                roadsWidth.setDisable(true);
                break;
            case "Roads":
                projectBudget.setPromptText("1000000");
                endDate = startDate.endDate(18);
                projectEndDate.setPromptText(endDate.toString());

                roadsBridges.setDisable(false);
                roadsTunnels.setDisable(false);
                roadsChallenges.setDisable(false);
                roadsLanes.setDisable(false);
                roadsLength.setDisable(false);
                roadsWidth.setDisable(false);

                residentialKitchens.setDisable(true);
                residentialBathrooms.setDisable(true);
                residentialPlumbing.setDisable(true);
                commercialFloors.setDisable(true);
                commercialUse.setDisable(true);
                industrialType.setDisable(true);
                break;
        }
    }

    /**
     * Modifies Title's label based on the project's Title input.
     *
     * @param e an ActionEvent with setTitle(), in this case a TextField
     */
    public void setTitle(ActionEvent e) {
        if (!projectTitle.getText().isEmpty())
            labelTitle.setText(projectTitle.getText());
    }

    /**
     * Sets project's build. 'New Build' / 'Renovation' are the available options.
     *
     * @param e an ActionEvent with setBuild(), in this case a ComboBox
     */
    public void setBuild(ActionEvent e) {
        String choice = projectBuild.getValue();
        switch (choice) {
            case "New Build":
                this.build = false;
                break;
            case "Renovation":
                this.build = true;
                break;
        }
    }

    /**
     * Creates & Saves new project. Contains various input checks and per type branches.
     */
    public void createProject() {
        boolean mistake = false;
        String title = "";
        String customer = "";
        String start;
        String end;
        double budget = 0;
        double size = 0;

        //extracts Title - Sergiu
        //checks empty inputs - Sergiu
        if (projectTitle.getText().isEmpty()) {
            //uses Style to border the error - Sergiu
            projectTitle.setStyle("-fx-border-color:red; -fx-border-width:2px");
            mistake = true;
            //pops-up ERROR alert - Sergiu
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Title is missing!",
                    ButtonType.CLOSE);
            alert.setTitle("MISSING INPUT");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        } else {
            title = projectTitle.getText();
            //resets Style if error corrected - Sergiu
            projectTitle.setStyle("");
        }

        //extracts Customer - Sergiu
        //checks empty inputs - Sergiu
        if (projectCustomer.getText().isEmpty()) {
            //uses Style to border the error - Sergiu
            projectCustomer.setStyle("-fx-border-color:red; -fx-border-width:2px");
            mistake = true;
            //pops-up ERROR alert - Sergiu
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Customer is missing!",
                    ButtonType.CLOSE);
            alert.setTitle("MISSING INPUT");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        } else {
            customer = projectCustomer.getText();
            //resets Style if error corrected - Sergiu
            projectCustomer.setStyle("");
        }

        //extracts Budget - Sergiu
        try {
            //if empty autocompletes with default - Sergiu
            if (projectBudget.getText().isEmpty()) {
                budget = 100000;
            } else {
                budget = Double.parseDouble(projectBudget.getText());
            }
            //resets Style if error corrected - Sergiu
            projectBudget.setStyle("");
        } catch (Exception e) {
            //uses Style to border the error - Sergiu
            projectBudget.setStyle("-fx-border-color:red; -fx-border-width:2px");
            mistake = true;
            //pops-up ERROR alert - Sergiu
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Budget input is not a number(double)!",
                    ButtonType.CLOSE);
            alert.setTitle("INVALID INPUT");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        }

        //extracts Size - Sergiu
        try {
            size = Double.parseDouble(projectSize.getText());
            //resets Style if error corrected - Sergiu
            projectSize.setStyle("");
        } catch (Exception e) {
            //uses Style to border the error - Sergiu
            projectSize.setStyle("-fx-border-color:red; -fx-border-width:2px");
            mistake = true;
            //pops-up ERROR alert - Sergiu
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Size input is not a number(double)!",
                    ButtonType.CLOSE);
            alert.setTitle("INVALID INPUT");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        }

        //extracts StartDate - Sergiu
        //if empty autocompletes with default - Sergiu
        if (projectStartDate.getValue() == null) {
            start = String.valueOf(java.time.LocalDate.now());
        } else {
            start = String.valueOf(projectStartDate.getValue());
        }

        //switches to per project-type input - Sergiu
        String type = projectType.getValue();
        switch (type) {
            //residential branch - Sergiu
            case "Residential":
                int kitchens = 0;
                int bathrooms = 0;
                int plumbing = 0;

                //extracts Kitchens - Sergiu
                try {
                    //if empty autocompletes with default - Sergiu
                    if (residentialKitchens.getText().isEmpty()) {
                        kitchens = 1;
                    } else {
                        kitchens = Integer.parseInt(residentialKitchens.getText());
                    }
                    //resets Style if error corrected - Sergiu
                    residentialKitchens.setStyle("");
                } catch (Exception e) {
                    //uses Style to border the error - Sergiu
                    residentialKitchens.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Kitchens input is not a number(int)!",
                            ButtonType.CLOSE);
                    alert.setTitle("INVALID INPUT");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //extracts Bathrooms - Sergiu
                try {
                    //if empty autocompletes with default - Sergiu
                    if (residentialBathrooms.getText().isEmpty()) {
                        bathrooms = 1;
                    } else {
                        bathrooms = Integer.parseInt(residentialBathrooms.getText());
                    }
                    //resets Style if error corrected - Sergiu
                    residentialBathrooms.setStyle("");
                } catch (Exception e) {
                    //uses Style to border the error - Sergiu
                    residentialBathrooms.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Bathrooms input is not a number(int)!",
                            ButtonType.CLOSE);
                    alert.setTitle("INVALID INPUT");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //extracts Other Plumbing - Sergiu
                try {
                    //if empty autocompletes with default - Sergiu
                    if (residentialPlumbing.getText().isEmpty()) {
                        plumbing = 1;
                    } else {
                        plumbing = Integer.parseInt(residentialPlumbing.getText());
                    }
                    //resets Style if error corrected - Sergiu
                    residentialPlumbing.setStyle("");
                } catch (Exception e) {
                    //uses Style to border the error - Sergiu
                    residentialPlumbing.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Plumbing input is not a number(int)!",
                            ButtonType.CLOSE);
                    alert.setTitle("INVALID INPUT");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        break;
                    }
                }

                //extracts EndDate - Sergiu
                //if empty autocompletes with default - Sergiu
                if (projectEndDate.getValue() == null) {
                    MyDate temp = new MyDate(start);
                    temp = temp.endDate(9);
                    end = temp.toStringDate();
                } else {
                    end = String.valueOf(projectEndDate.getValue());
                }

                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Residential class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        Residential residential = new Residential(budget, start, end, title, customer, kitchens, bathrooms, plumbing, this.build, size);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Project has been successfully added!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        break;
                    }
                }
                break;
            //commercial branch - Sergiu
            case "Commercial":
                int floors = 0;
                String use;

                //extracts No. Floors - Sergiu
                try {
                    //if empty autocompletes with default - Sergiu
                    if (commercialFloors.getText().isEmpty()) {
                        floors = 1;
                    } else {
                        floors = Integer.parseInt(commercialFloors.getText());
                    }
                    //resets Style if error corrected - Sergiu
                    commercialFloors.setStyle("");
                } catch (Exception e) {
                    //uses Style to border the error - Sergiu
                    commercialFloors.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "No. Floors input is not a number(int)!",
                            ButtonType.CLOSE);
                    alert.setTitle("INVALID INPUT");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //extracts Intended Use - Sergiu
                //if empty autocompletes with default - Sergiu
                if (commercialUse.getText().isEmpty()) {
                    use = "Unspecified";
                } else {
                    use = commercialUse.getText();
                }

                //extracts EndDate - Sergiu
                //if empty autocompletes with default - Sergiu
                if (projectEndDate.getValue() == null) {
                    MyDate temp = new MyDate(start);
                    temp = temp.endDate(18);
                    end = temp.toStringDate();
                } else {
                    end = String.valueOf(projectEndDate.getValue());
                }

                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Commercial class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        Commercial commercial = new Commercial(budget, start, end, floors, size, use, title, customer, this.build);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Project has been successfully added!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        break;
                    }
                }
                break;
            //industrial branch - Sergiu
            case "Industrial":
                String facilityType;

                //extracts Intended Use - Sergiu
                //if empty autocompletes with default - Sergiu
                if (industrialType.getText().isEmpty()) {
                    facilityType = "Unspecified";
                } else {
                    facilityType = industrialType.getText();
                }

                //extracts EndDate - Sergiu
                //if empty autocompletes with default - Sergiu
                if (projectEndDate.getValue() == null) {
                    MyDate temp = new MyDate(start);
                    temp = temp.endDate(30);
                    end = temp.toStringDate();
                } else {
                    end = String.valueOf(projectEndDate.getValue());
                }

                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Industrial class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        Industrial industrial = new Industrial(budget, start, end, title, customer, size, facilityType, this.build);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Project has been successfully added!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        break;
                    }
                }
                break;
            //road construction branch - Sergiu
            case "Roads":
                int lanes = 0;
                double length = 0;
                double width = 0;

                //extracts No. Lanes - Sergiu
                try {
                    //if empty autocompletes with default - Sergiu
                    if (!roadsLanes.getText().isEmpty())
                        lanes = Integer.parseInt(roadsLanes.getText());
                    //resets Style if error corrected - Sergiu
                    roadsLanes.setStyle("");
                } catch (Exception e) {
                    //uses Style to border the error - Sergiu
                    roadsLanes.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "No. Lanes input is not a number(int)!",
                            ButtonType.CLOSE);
                    alert.setTitle("INVALID INPUT");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //extracts Length - Sergiu
                try {
                    //if empty autocompletes with default - Sergiu
                    if (!roadsLength.getText().isEmpty())
                        length = Double.parseDouble(roadsLength.getText());
                    //resets Style if error corrected - Sergiu
                    roadsLength.setStyle("");
                } catch (Exception e) {
                    //uses Style to border the error - Sergiu
                    roadsLength.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Length input is not a number(double)!",
                            ButtonType.CLOSE);
                    alert.setTitle("INVALID INPUT");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //extracts Width - Sergiu
                try {
                    //if empty autocompletes with default - Sergiu
                    if (!roadsWidth.getText().isEmpty())
                        width = Double.parseDouble(roadsWidth.getText());
                    //resets Style if error corrected - Sergiu
                    roadsWidth.setStyle("");
                } catch (Exception e) {
                    //uses Style to border the error - Sergiu
                    roadsWidth.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Width input is not a number(double)!",
                            ButtonType.CLOSE);
                    alert.setTitle("INVALID INPUT");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //extracts EndDate - Sergiu
                //if empty autocompletes with default - Sergiu
                if (projectEndDate.getValue() == null) {
                    MyDate temp = new MyDate(start);
                    temp = temp.endDate(30);
                    end = temp.toStringDate();
                } else {
                    end = String.valueOf(projectEndDate.getValue());
                }
                System.out.println(roadsBridges.isSelected());
                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Industrial class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        RoadConstruction roadConstruction = new RoadConstruction(budget, start, end, title, customer, size, this.build,
                                roadsBridges.isSelected(), roadsTunnels.isSelected(), length, width, roadsChallenges.isSelected(), lanes);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "Project has been successfully added!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            break;
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        break;
                    }
                }
                break;
        }
    }
}
