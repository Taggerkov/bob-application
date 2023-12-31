package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;

/**
 * Controllers that takes care of Project creation.
 *
 * @author Sergiu Chirap
 * @version 2.0
 */
public class NewProjectController {
    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;
    private String type;
    private boolean build;
    @FXML
    private Button quickNewProject, quickViewProject, quickAnalytics, quickPublishWeb, quickSettings, quickCancel, quickConfirm;
    @FXML
    private Label labelTitle;
    @FXML
    private TextField projectTitle, projectCustomer, projectBudget, projectSize, residentialKitchens, residentialBathrooms, residentialPlumbing, commercialFloors, commercialUse, industrialType, roadsLanes, roadsLength, roadsWidth;
    @FXML
    private DatePicker projectStartDate, projectEndDate;
    @FXML
    private CheckBox roadsBridges, roadsTunnels, roadsChallenges;
    @FXML
    private ComboBox<String> projectType, projectBuild;
    @FXML
    private MenuItem menuNew, menuCancel, menuSettings, menuConfirm, menuReset, menuQuit;

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

        //sets ComboBoxes - Sergiu
        projectType.getItems().setAll("Residential", "Commercial", "Industrial", "Roads");
        projectType.setValue("Residential");
        projectBuild.getItems().setAll("New Build", "Renovation");

        //sets StartDate preview(current) - Sergiu
        MyDate startDate = new MyDate(String.valueOf(LocalDate.now()));
        projectStartDate.setPromptText(startDate.toString());

        //sets default(Residential) type - Sergiu
        this.type = "Residential";
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
     * Resets all inputs.
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
        projectEndDate.setStyle(null);
        projectEndDate.setStyle("");
        projectBuild.setValue("New Build");
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
        if (e.getSource() == quickNewProject || e.getSource() == menuNew || e.getSource() == menuReset) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CLEAR NEW PROJECT?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
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
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("BrowseProject");
            }
        } else if (e.getSource() == quickAnalytics) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
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
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("PublishWeb");
            }
        } else if (e.getSource() == quickSettings || e.getSource() == menuSettings) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Settings");
            }
        } else if (e.getSource() == quickCancel || e.getSource() == menuCancel) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CANCEL NEW PROJECT?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Welcome");
            }
        } else if (e.getSource() == quickConfirm || e.getSource() == menuConfirm) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be saved!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CONFIRM NEW PROJECT?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                createProject();
            }
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
     * Modifies enabled inputs based on project type.
     *
     * @param e an ActionEvent which states project type.
     */
    public void setType(ActionEvent e) {
        //extracts the chosen type from ComboBox - Sergiu
        this.type = projectType.getValue();
        MyDate endDate;
        MyDate startDate = new MyDate(String.valueOf(LocalDate.now()));
        //sets, disables & enables inputs based on extracted type - Sergiu
        switch (this.type) {
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
     * @param e an ActionEvent which states project title.
     */
    public void setTitle(ActionEvent e) {
        String title = projectTitle.getText();
        if (!title.isEmpty()) {
            //checks if title is already taken - Sergiu
            if (!checkTitle(title)) {
                //checks input max length - Sergiu
                if (title.length() > 17) {
                    //uses Style to border the error - Sergiu
                    projectTitle.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Max. 17 characters but used " + title.length() + " instead.",
                            ButtonType.CLOSE);
                    alert.setTitle("ILLEGAL INPUT");
                    alert.setHeaderText("Title is too large!");
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                } else {
                    labelTitle.setText(title);
                    //resets Style if error corrected - Sergiu
                    projectTitle.setStyle("");
                }
            } else {
                //uses Style to border the error - Sergiu
                projectTitle.setStyle("-fx-border-color:red; -fx-border-width:2px");
                //pops-up ERROR alert - Sergiu
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Title is already taken!",
                        ButtonType.CLOSE);
                alert.setTitle("ILLEGAL INPUT");
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

    /**
     * Sets EndDate prompt text based on picked date and selected type.
     *
     * @param e a ActionEvent which states project end start date.
     */
    public void setEndDate(ActionEvent e) {
        if (!(projectStartDate.getValue() == null)) {
            MyDate temp = new MyDate(String.valueOf(projectStartDate.getValue()));
            switch (this.type) {
                case "Residential":
                    temp = temp.endDate(9);
                    projectEndDate.setPromptText(temp.toString());
                    break;
                case "Commercial":
                    temp = temp.endDate(18);
                    projectEndDate.setPromptText(temp.toString());
                    break;
                case "Industrial":
                    temp = temp.endDate(30);
                    projectEndDate.setPromptText(temp.toString());
                    break;
                case "Roads":
                    temp = temp.endDate(18);
                    projectEndDate.setPromptText(temp.toString());
                    break;
            }
        }
    }

    /**
     * Sets project's build. 'New Build' / 'Renovation' are the available options.
     *
     * @param e an ActionEvent which states project build.
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
     * Creates a project with the input or default data.
     */
    public void createProject() {
        boolean mistake = false;
        String title;
        String customer;
        String start;
        String end;
        double budget = 0;
        double size = 0;

        //extracts Title - Sergiu
        title = projectTitle.getText();
        //checks empty inputs - Sergiu
        if (title.isEmpty()) {
            //uses Style to border the error - Sergiu
            projectTitle.setStyle("-fx-border-color:red; -fx-border-width:2px");
            mistake = true;
            //pops-up ERROR alert - Sergiu
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Title is missing!",
                    ButtonType.CLOSE);
            alert.setTitle("MISSING INPUT");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        } else {
            //checks if title is already taken - Sergiu
            if (!checkTitle(title)) {
                //checks input max length - Sergiu
                if (title.length() > 17) {
                    //uses Style to border the error - Sergiu
                    projectTitle.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up ERROR alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Max. 17 characters but used " + title.length() + " instead.",
                            ButtonType.CLOSE);
                    alert.setTitle("ILLEGAL INPUT");
                    alert.setHeaderText("Title is too large!");
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                } else {
                    labelTitle.setText(title);
                    //resets Style if error corrected - Sergiu
                    projectTitle.setStyle("");
                }
            } else {
                //uses Style to border the error - Sergiu
                projectTitle.setStyle("-fx-border-color:red; -fx-border-width:2px");
                mistake = true;
                //pops-up ERROR alert - Sergiu
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Title is already taken!",
                        ButtonType.CLOSE);
                alert.setTitle("ILLEGAL INPUT");
                alert.setHeaderText(null);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CLOSE) {
                    alert.close();
                }
            }
        }

        //extracts Customer - Sergiu
        customer = projectCustomer.getText();
        //checks empty inputs - Sergiu
        if (customer.isEmpty()) {
            //uses Style to border the error - Sergiu
            projectCustomer.setStyle("-fx-border-color:red; -fx-border-width:2px");
            mistake = true;
            //pops-up ERROR alert - Sergiu
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Customer is missing!",
                    ButtonType.CLOSE);
            alert.setTitle("MISSING INPUT");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        } else {
            //checks input max length - Sergiu
            if (customer.length() > 21) {
                //uses Style to border the error - Sergiu
                projectCustomer.setStyle("-fx-border-color:red; -fx-border-width:2px");
                mistake = true;
                //pops-up ERROR alert - Sergiu
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Max. 21 characters but used " + customer.length() + " instead.",
                        ButtonType.CLOSE);
                alert.setTitle("ILLEGAL INPUT");
                alert.setHeaderText("Customer is too large!");
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CLOSE) {
                    alert.close();
                }
            } else {
                //resets Style if error corrected - Sergiu
                projectCustomer.setStyle("");
            }
        }

        //extracts Budget - Sergiu
        try {
            //if empty autocompletes with default - Sergiu
            if (projectBudget.getText().isEmpty()) {
                budget = Double.parseDouble(projectBudget.getPromptText());
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
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
        }

        //extracts StartDate - Sergiu
        //if empty autocompletes with default - Sergiu
        if (projectStartDate.getValue() == null) {
            start = String.valueOf(LocalDate.now());
        } else {
            start = String.valueOf(projectStartDate.getValue());
            //checks isBefore for EndDate
            if (!(projectEndDate.getValue() == null)) {
                if (!new MyDate(start).isBefore(new MyDate(String.valueOf(projectEndDate.getValue())))) {
                    //uses Style to border the error - Sergiu
                    projectEndDate.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    mistake = true;
                    //pops-up isBefore alert - Sergiu
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "End Date is before Start Date!",
                            ButtonType.CLOSE);
                    alert.setTitle("ILLEGAL INPUT");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                } else {
                    //resets Style if error corrected - Sergiu
                    projectEndDate.setStyle("");
                }
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
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                alert.close();
            }
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
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
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
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
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
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //extracts EndDate - Sergiu
                //if empty autocompletes with default - Sergiu
                if (projectEndDate.getValue() == null) {
                    MyDate temp = new MyDate(start);
                    temp = new MyDate(start);
                    temp = temp.endDate(9);
                    end = temp.toStringDate();
                } else {
                    end = String.valueOf(projectEndDate.getValue());
                }

                //checks isBefore - Sergiu
                if (new MyDate(start).isBefore(new MyDate(end))) {
                    //resets Style if error corrected - Sergiu
                    projectEndDate.setStyle("");
                } else {
                    //uses Style to border the error - Sergiu
                    mistake = true;
                    projectEndDate.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "End Date is before Start Date!",
                            ButtonType.CLOSE);
                    alert.setTitle("ILLEGAL INPUT");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Residential class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        Residential residential = new Residential(budget, start, end, title, customer, size, this.build, kitchens, bathrooms, plumbing, "Local");
                        //saves new project calling sub-function - Sergiu
                        saveProject(residential);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/created.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "CREATED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT CREATED");
                        alert.setHeaderText("Project has been successfully added!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/created.gif"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            handler.openView("Welcome");
                        }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            reset();
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
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
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
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

                //checks isBefore - Sergiu
                if (new MyDate(start).isBefore(new MyDate(end))) {
                    //resets Style if error corrected - Sergiu
                    projectEndDate.setStyle("");
                } else {
                    //uses Style to border the error - Sergiu
                    mistake = true;
                    projectEndDate.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "End Date is before Start Date!",
                            ButtonType.CLOSE);
                    alert.setTitle("ILLEGAL INPUT");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Commercial class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        Commercial commercial = new Commercial(budget, start, end, title, customer, size, floors, use, this.build, "Local");
                        //saves new project calling sub-function - Sergiu
                        saveProject(commercial);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/created.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "CREATED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT CREATED");
                        alert.setHeaderText("Project has been successfully added!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/created.gif"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            handler.openView("Welcome");
                        }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            reset();
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }
                break;
            //industrial branch - Sergiu
            case "Industrial":
                String facilityType;

                //extracts Industrial Type - Sergiu
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

                //checks isBefore - Sergiu
                if (new MyDate(start).isBefore(new MyDate(end))) {
                    //resets Style if error corrected - Sergiu
                    projectEndDate.setStyle("");
                } else {
                    //uses Style to border the error - Sergiu
                    mistake = true;
                    projectEndDate.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "End Date is before Start Date!",
                            ButtonType.CLOSE);
                    alert.setTitle("ILLEGAL INPUT");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Industrial class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        Industrial industrial = new Industrial(budget, start, end, title, customer, size, this.build, facilityType, "Local");
                        //saves new project calling sub-function - Sergiu
                        saveProject(industrial);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/created.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "CREATED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT CREATED");
                        alert.setHeaderText("Project has been successfully added!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/created.gif"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            handler.openView("Welcome");
                        }
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            reset();
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
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
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
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
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
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
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
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

                //checks isBefore - Sergiu
                if (new MyDate(start).isBefore(new MyDate(end))) {
                    //resets Style if error corrected - Sergiu
                    projectEndDate.setStyle("");
                } else {
                    //uses Style to border the error - Sergiu
                    mistake = true;
                    projectEndDate.setStyle("-fx-border-color:red; -fx-border-width:2px");
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "End Date is before Start Date!",
                            ButtonType.CLOSE);
                    alert.setTitle("ILLEGAL INPUT");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }

                //keeps track if mistakes were made - Sergiu
                if (!mistake) {
                    //creates Road Construction class with the Full-Constructor - Sergiu
                    try {
                        //inputs extracted data into Full-Constructor - Sergiu
                        RoadConstruction roadConstruction = new RoadConstruction(budget, start, end, title, customer, size, this.build, lanes,
                                length, width, roadsChallenges.isSelected(), roadsBridges.isSelected(), roadsTunnels.isSelected(), "Local");
                        //saves new project calling sub-function - Sergiu
                        saveProject(roadConstruction);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/created.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "CREATED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT CREATED");
                        alert.setHeaderText("Project has been successfully added!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/created.gif"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            handler.openView("Welcome");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Alert alert = new Alert(Alert.AlertType.ERROR,
                                "Unknown Exception Found!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT NOT SAVED");
                        alert.setHeaderText(null);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.CLOSE) {
                            reset();
                        }
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "Solve the mistakes and try again.",
                            ButtonType.CLOSE);
                    alert.setTitle("PROJECT NOT SAVED");
                    alert.setHeaderText(null);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.CLOSE) {
                        alert.close();
                    }
                }
                break;
        }
    }

    /**
     * Saves the projects created by the Controller into the binary file. This is done by linking this class with the ProjectManager.
     * This function deletes the old project from the list and adds the new as last.
     */
    private void saveProject(Project project) {
        try {
            //checks if the file is empty
            ProjectList allProjects = manager.readAllProjects();
            if (allProjects == null) {
                allProjects = new ProjectList();
                allProjects.add(project);
                manager.saveProjects(allProjects);
            } else {
                allProjects.add(project);
                manager.saveProjects(allProjects);
            }
            //saving error pop-up
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Unable to save to file!",
                    ButtonType.CLOSE);
            alert.setTitle("WRITING ERROR");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                reset();
            }
        }
    }

    /**
     * Checks if title is already present in the ProjectList.
     *
     * @param title the title that is wanted to check.
     * @return a boolean which states 'true' if the title is already taken.
     */
    private boolean checkTitle(String title) {
        boolean check = false;
        try {
            //checks if the file is empty
            ProjectList allProjects = manager.readAllProjects();
            if (!(allProjects == null) && !(manager.getProject(title) == null)) {
                check = true;
            }
            //reading error pop-up
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Unable to check the title!",
                    ButtonType.CLOSE);
            alert.setTitle("READING ERROR");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                reset();
            }
        }
        return check;
    }
}