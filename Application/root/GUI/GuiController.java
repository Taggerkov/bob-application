package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class GuiController
{

    @FXML
    private TabPane tabPane;

    @FXML
    private Button newProject;

    @FXML
    private Button viewProjectButton;

    @FXML
    private Button analyticsButton;

    @FXML
    private Button publishWebButton;
    private void switchToTab(String tabId) {
        for (Tab tab : tabPane.getTabs()) {
            if (tab.getId() != null && tab.getId().equals(tabId)) {
                tabPane.getSelectionModel().select(tab);
                break;
            }
        }
    }

    @FXML
    private void handleNewProjectButtonClick() {
        switchToTab("newProjectTab");
    }

    @FXML
    private void handleViewProjectButtonClick() {
        switchToTab("viewProjectTab");
    }

    @FXML
    private void handleAnalyticsButtonClick() {
        switchToTab("analyticsTab");
    }

    @FXML
    private void handlePublishWebButtonClick() {
        switchToTab("publishWebTab");
    }

    @FXML
    private void handleSettingsButtonClick() {
        switchToTab("settingsTab");
    }

    @FXML
    private void handleCancelButtonPublishClick() {
        switchToTab("welcomeTab");
    }

    @FXML
    private void handleConfirmButtonPublishClick() {
        switchToTab("welcomeTab");
    }



}
