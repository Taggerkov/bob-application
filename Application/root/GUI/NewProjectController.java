package GUI;

import Model.MyDate;
import Model.ProjectManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class NewProjectController {
    private Scene target;
    private ProjectManager manager;
    private ViewHandler handler;
    private MyDate startDate;
    private MyDate endDate;
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
    private TextField projectTimeline;
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

    public void init(ViewHandler handler, Scene target, ProjectManager manager) {
        this.handler = handler;
        this.target = target;
        this.manager = manager;

        //sets ComboBoxes - Sergiu
        projectType.getItems().setAll("Residential", "Commercial", "Industrial", "Roads");
        projectBuild.getItems().setAll("New Build", "Renovation");

        //sets StartDate preview(current) - Sergiu
        this.startDate = new MyDate(String.valueOf(java.time.LocalDate.now()));
        projectStartDate.setPromptText(this.startDate.toString());

        //sets default(Residential) type - Sergiu
        projectBudget.setPromptText("100000");
        projectTimeline.setPromptText("9");
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
    }

    public void reset() {
    }

    public Scene getScene() {
        return target;
    }

    public void quickActions(ActionEvent e) {
        if (e.getSource() == quickNewProject) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("CLEAR NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("NewProject");
            }
        } else if (e.getSource() == quickViewProject) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("AllProjects");
            }
        } else if (e.getSource() == quickAnalytics) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Analytics");
            }
        } else if (e.getSource() == quickPublishWeb) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("PublishWeb");
            }
        } else if (e.getSource() == quickSettings) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Changes will be lost!",
                    ButtonType.YES, ButtonType.NO);
            alert.setTitle("LEAVE NEW PROJECT?");
            alert.setHeaderText(null);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                handler.openView("Settings");
            }
        } else if (e.getSource() == quickCancel) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
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
        //sets, disables & enables inputs based on extracted type - Sergiu
        switch (type) {
            case "Residential":
                projectBudget.setPromptText("100000");
                projectTimeline.setPromptText("9");
                this.endDate = startDate.endDate(9);
                projectEndDate.setPromptText(this.endDate.toString());

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
                projectTimeline.setPromptText("18");
                this.endDate = startDate.endDate(18);
                projectEndDate.setPromptText(this.endDate.toString());

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
                projectTimeline.setPromptText("30");
                this.endDate = startDate.endDate(30);
                projectEndDate.setPromptText(this.endDate.toString());

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
                projectTimeline.setPromptText("18");
                this.endDate = startDate.endDate(18);
                projectEndDate.setPromptText(this.endDate.toString());

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

    public void setTitle(ActionEvent e) {
        labelTitle.setText(projectTitle.getText());
    }

    public void createProject(){

    }
}
