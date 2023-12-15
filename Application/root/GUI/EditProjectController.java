package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;

/**
 * Controller that takes care of Project modification.
 *
 * @author Sergiu Chirap
 * @version 2.5
 */
public class EditProjectController {
    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;
    private String title, type, customer, use, typeFacility, isPublished;
    private int kitchens, bathrooms, plumbing, floors, lanes;
    private double budget, size, length, width;
    private MyDate startDate, endDate;
    private boolean build, isActive, bridges, tunnels, geoChallenges;
    @FXML
    private Button quickNewProject, quickViewProject, quickAnalytics, quickPublishWeb, quickSettings, quickReturn, quickSave, quickArchive, quickDelete;
    @FXML
    private Label labelTitle, labelCustomer;
    @FXML
    private TextField projectBuild, projectTitle, projectCustomer, projectBudget, projectSize, residentialKitchens, residentialBathrooms, residentialPlumbing, commercialFloors, commercialUse, industrialType, roadsLanes, roadsLength, roadsWidth;
    @FXML
    private DatePicker projectStartDate, projectEndDate;
    @FXML
    private CheckBox roadsBridges, roadsTunnels, roadsChallenges;
    @FXML
    private HBox inputResidential, inputCommercial, inputIndustrial, inputRoads;
    @FXML
    private ComboBox<String> projectPublished;
    @FXML
    private MenuItem menuNew, menuSave, menuReturn, menuSettings, menuQuit, menuArchive, menuDelete;

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
     * Loads and prepares display based on chosen project.
     *
     * @param title a String stating projects title.
     */
    public void loadProject(String title) {
        this.title = title;
        Project project = manager.getProject(this.title);
        labelTitle.setText(this.title);
        projectTitle.setPromptText(this.title);

        this.type = project.getType();

        this.customer = project.getCustomer();
        labelCustomer.setText("-" + this.customer + "-");
        projectCustomer.setPromptText(this.customer);


        this.isPublished = project.getIsPublished();
        if (isPublished.equals("Online")) {
            projectPublished.getItems().setAll("Online", "Local");
        } else if (isPublished.equals("Publish")) {
            projectPublished.getItems().setAll("Publish", "Local");
            projectPublished.setPromptText("Publish");
        } else {
            projectPublished.getItems().setAll("Local", "Publish");
        }
        projectPublished.setValue(this.isPublished);
        projectPublished.setPromptText(this.isPublished);

        this.isActive = project.isActive();
        if (!this.isActive) quickArchive.setVisible(false);

        this.budget = project.getBudget();
        projectBudget.setPromptText(String.valueOf(this.budget));
        this.startDate = project.getStartDate();
        projectStartDate.setPromptText(this.startDate.toString());

        this.endDate = project.getEndDate();
        projectEndDate.setPromptText(this.endDate.toString());

        this.size = project.getSize();
        projectSize.setPromptText(String.valueOf(this.size));

        this.build = project.isRenovation();
        if (!this.build) {
            projectBuild.setText("New Build");
        } else projectBuild.setText("Renovation");
        projectBuild.setEditable(false);

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

        inputResidential.setVisible(false);
        inputCommercial.setVisible(false);
        inputIndustrial.setVisible(false);
        inputRoads.setVisible(false);

        switch (this.type) {
            case "Residential":
                inputResidential.setVisible(true);
                Residential residential = (Residential) manager.getProject(this.title);

                this.kitchens = residential.getNoOfKitchens();
                residentialKitchens.setPromptText(String.valueOf(this.kitchens));

                this.bathrooms = residential.getNoOfBathrooms();
                residentialBathrooms.setPromptText(String.valueOf(this.bathrooms));

                this.plumbing = residential.getRoomsWPlumbing();
                residentialPlumbing.setPromptText(String.valueOf(this.plumbing));

                residentialKitchens.setText("");
                residentialBathrooms.setText("");
                residentialPlumbing.setText("");
                residentialKitchens.setStyle("");
                residentialBathrooms.setStyle("");
                residentialPlumbing.setStyle("");
                break;
            case "Commercial":
                inputCommercial.setVisible(true);
                Commercial commercial = (Commercial) manager.getProject(this.title);

                this.floors = commercial.getNoOfFloors();
                commercialFloors.setPromptText(String.valueOf(this.floors));

                this.use = commercial.getIntendedUse();
                commercialUse.setPromptText(this.use);

                commercialFloors.setText("");
                commercialUse.setText("");
                commercialFloors.setStyle("");
                break;
            case "Industrial":
                inputIndustrial.setVisible(true);
                Industrial industrial = (Industrial) manager.getProject(this.title);

                this.typeFacility = industrial.getTypeOfFacility();
                industrialType.setPromptText(this.typeFacility);

                industrialType.setText("");
                break;
            case "Roads":
                inputRoads.setVisible(true);
                RoadConstruction roads = (RoadConstruction) manager.getProject(this.title);

                this.lanes = roads.getNoOfLanes();
                roadsLanes.setPromptText(String.valueOf(this.lanes));

                this.length = roads.getLength();
                roadsLength.setPromptText(String.valueOf(this.length));

                this.width = roads.getWidth();
                roadsWidth.setPromptText(String.valueOf(this.width));

                roadsBridges.setSelected(false);
                roadsTunnels.setSelected(false);
                roadsChallenges.setSelected(false);
                roadsLanes.setText("");
                roadsLength.setText("");
                roadsWidth.setText("");
                roadsLanes.setStyle("");
                roadsLength.setStyle("");
                roadsWidth.setStyle("");

                this.bridges = roads.getHasBridges();
                roadsBridges.setSelected(this.bridges);
                if (this.bridges) roadsBridges.selectedProperty();

                this.tunnels = roads.getHasTunnels();
                roadsTunnels.setSelected(this.tunnels);
                if (this.tunnels) roadsTunnels.selectedProperty();

                this.geoChallenges = roads.getHasGeoChallenge();
                roadsChallenges.setSelected(this.geoChallenges);
                if (this.geoChallenges) roadsChallenges.selectedProperty();
                roadsChallenges.selectedProperty();
        }
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
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE EDIT PROJECT?");
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
            alert.setTitle("LEAVE EDIT PROJECT?");
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
            alert.setTitle("LEAVE EDIT PROJECT?");
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
            alert.setTitle("LEAVE EDIT PROJECT?");
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
            alert.setTitle("LEAVE EDIT PROJECT?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Settings");
            }
        } else if (e.getSource() == quickReturn || e.getSource() == menuReturn) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CANCEL CHANGES?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("BrowseProject");
            }
        } else if (e.getSource() == quickSave || e.getSource() == menuSave) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be saved!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CONFIRM CHANGES?");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                saveProject();
            }
        } else if (e.getSource() == quickArchive || e.getSource() == menuArchive) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Modify later to reactivate.",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CONFIRM ACTION?");
            alert.setHeaderText("Project will be archived!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                archiveProject();
            }
        } else if (e.getSource() == quickDelete || e.getSource() == menuDelete) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "This action is not reversible.",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CONFIRM ACTION?");
            alert.setHeaderText("Project will be deleted!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                deleteProject();
                handler.openView("BrowseProject");
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
     * Sets the project as archived.
     */
    public void archiveProject() {
        try {
            ProjectList allProjects = manager.readAllProjects();
            //extracts project index - Sergiu
            int index = 0;
            for (int i = 0; i < allProjects.size(); i++) {
                if (allProjects.getTitle(i).equals(this.title)) {
                    index = i;
                    break;
                }
            }
            Project project = allProjects.get(index);
            project.setActive(false);
            allProjects.set(index, project);
            manager.saveProjects(allProjects);

            //pops-up confirmation alert
            ImageView imageView = new ImageView((new Image("file:Application/root/Utils/status.gif", 75, 75, true, true)));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "ARCHIVED!",
                    ButtonType.CLOSE);
            alert.setTitle("PROJECT ARCHIVED");
            alert.setHeaderText("Project has been successfully archived!");
            alert.setGraphic(imageView);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/status.gif"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                handler.openView("Welcome");
            }
            //saving error pop-up
        } catch (Exception k) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Unable to save to file!",
                    ButtonType.CLOSE);
            alert.setTitle("WRITING ERROR");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                loadProject(this.title);
            }
        }
    }

    /**
     * Deletes the project.
     */
    public void deleteProject() {
        try {
            ProjectList allProjects = manager.readAllProjects();
            //extracts project index - Sergiu
            int index = 0;
            for (int i = 0; i < allProjects.size(); i++) {
                if (allProjects.getTitle(i).equals(this.title)) {
                    index = i;
                    break;
                }
            }
            allProjects.delete(index);
            manager.saveProjects(allProjects);

            //pops-up confirmation alert
            ImageView imageView = new ImageView((new Image("file:Application/root/Utils/deleted.gif", 75, 75, true, true)));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "DELETED!",
                    ButtonType.CLOSE);
            alert.setTitle("PROJECT DELETED");
            alert.setHeaderText("Project has been successfully deleted!");
            alert.setGraphic(imageView);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/deleted.gif"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                handler.openView("Welcome");
            }
            //saving error pop-up
        } catch (Exception k) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Unable to save to file!",
                    ButtonType.CLOSE);
            alert.setTitle("WRITING ERROR");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("file:Application/root/Utils/logo.png"));
            alert.showAndWait();
            if (alert.getResult() == ButtonType.CLOSE) {
                loadProject(this.title);
            }
        }
    }

    /**
     * Modifies Title's label based on the project's Title input.
     *
     * @param e an ActionEvent stating projects title.
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
     * @param e a ActionEvent which states projects end date.
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
     * Sets projects published status.
     *
     * @param e an ActionEvent which states projects status.
     */
    public void setPublished(ActionEvent e) {
        this.isPublished = projectPublished.getValue();
        projectPublished.setPromptText(this.isPublished);
    }

    /**
     * Creates a project with the input or extracted data.
     */
    public void saveProject() {
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
            title = this.title;
            //resets Style if error corrected - Sergiu
            projectTitle.setStyle("");
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
            customer = this.customer;
            //resets Style if error corrected - Sergiu
            projectCustomer.setStyle("");
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
            //if empty keeps file settings - Sergiu
            if (projectBudget.getText().isEmpty()) {
                budget = this.budget;
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
        //if empty keeps file settings - Sergiu
        if (projectStartDate.getValue() == null) {
            start = this.startDate.toStringDate();
            //resets Style if error corrected - Sergiu
            projectStartDate.setStyle("");
        } else {
            start = String.valueOf(projectStartDate.getValue());
            //checks isBefore for EndDate - Sergiu
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
        //if empty keeps file settings - Sergiu
        if (projectSize.getText().isEmpty()) {
            size = this.size;
            //resets Style if error corrected - Sergiu
            projectSize.setStyle("");
        } else {
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
        }

        //switches to per project-type input - Sergiu
        switch (this.type) {
            //residential branch - Sergiu
            case "Residential":
                int kitchens = 0;
                int bathrooms = 0;
                int plumbing = 0;

                //extracts Kitchens - Sergiu
                try {
                    //if empty keeps file settings - Sergiu
                    if (residentialKitchens.getText().isEmpty()) {
                        kitchens = this.kitchens;
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
                    //if empty keeps file settings - Sergiu
                    if (residentialBathrooms.getText().isEmpty()) {
                        bathrooms = this.bathrooms;
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
                    //if empty keeps file settings - Sergiu
                    if (residentialPlumbing.getText().isEmpty()) {
                        plumbing = this.plumbing;
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
                //if empty keeps file settings - Sergiu
                if (projectEndDate.getValue() == null) {
                    end = this.endDate.toStringDate();
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
                        Residential residential = new Residential(budget, start, end, title, customer, size, this.build, kitchens, bathrooms, plumbing, this.isPublished);
                        //saves project calling sub-function - Sergiu
                        saveProject(residential);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/saved.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "SAVED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText("Project has been successfully saved!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/saved.gif"));
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
                            loadProject(this.title);
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
                    //if empty keeps file settings - Sergiu
                    if (commercialFloors.getText().isEmpty()) {
                        floors = this.floors;
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
                //if empty keeps file settings - Sergiu
                if (commercialUse.getText().isEmpty()) {
                    use = this.use;
                } else {
                    use = commercialUse.getText();
                }

                //extracts EndDate - Sergiu
                //if empty keeps file settings - Sergiu
                if (projectEndDate.getValue() == null) {
                    end = this.endDate.toStringDate();
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
                        Commercial commercial = new Commercial(budget, start, end, title, customer, size, floors, use, this.build, this.isPublished);
                        //saves project calling sub-function - Sergiu
                        saveProject(commercial);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/saved.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "SAVED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText("Project has been successfully saved!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/saved.gif"));
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
                            loadProject(this.title);
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
                //if empty keeps file settings - Sergiu
                if (industrialType.getText().isEmpty()) {
                    facilityType = this.typeFacility;
                } else {
                    facilityType = industrialType.getText();
                }

                //extracts EndDate - Sergiu
                //if empty keeps file settings - Sergiu
                if (projectEndDate.getValue() == null) {
                    end = this.endDate.toStringDate();
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
                        Industrial industrial = new Industrial(budget, start, end, title, customer, size, this.build, facilityType, this.isPublished);
                        //saves project calling sub-function - Sergiu
                        saveProject(industrial);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/saved.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "SAVED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText("Project has been successfully saved!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/saved.gif"));
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
                            loadProject(this.title);
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
                    //if empty keeps file settings - Sergiu
                    if (!roadsLanes.getText().isEmpty()) {
                        lanes = Integer.parseInt(roadsLanes.getText());
                    } else lanes = this.lanes;
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
                    //if empty keeps file settings - Sergiu
                    if (!roadsLength.getText().isEmpty()) {
                        length = Double.parseDouble(roadsLength.getText());
                    } else length = this.length;
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
                    //if empty keeps file settings - Sergiu
                    if (!roadsWidth.getText().isEmpty()) {
                        width = Double.parseDouble(roadsWidth.getText());
                    } else width = this.width;
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
                //if empty keeps file settings - Sergiu
                if (projectEndDate.getValue() == null) {
                    end = this.endDate.toStringDate();
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
                                length, width, roadsChallenges.isSelected(), roadsBridges.isSelected(), roadsTunnels.isSelected(), this.isPublished);
                        //saves project calling sub-function - Sergiu
                        saveProject(roadConstruction);

                        //final creation pop-ups - Sergiu
                        ImageView imageView = new ImageView((new Image("file:Application/root/Utils/saved.gif", 75, 75, true, true)));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                "SAVED!",
                                ButtonType.CLOSE);
                        alert.setTitle("PROJECT SAVED");
                        alert.setHeaderText("Project has been successfully saved!");
                        alert.setGraphic(imageView);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                        stage.getIcons().add(new Image("file:Application/root/Utils/saved.gif"));
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
                            loadProject(this.title);
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
            //checks if the file is empty - Sergiu
            ProjectList allProjects = manager.readAllProjects();
            //extracts project index - Sergiu
            int index = 0;
            for (int i = 0; i < allProjects.size(); i++) {
                if (allProjects.getTitle(i).equals(this.title)) {
                    index = i;
                    break;
                }
            }
            allProjects.delete(index);
            allProjects.add(project);
            manager.saveProjects(allProjects);
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
                loadProject(this.title);
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
                loadProject(this.title);
            }
        }
        return check;
    }
}