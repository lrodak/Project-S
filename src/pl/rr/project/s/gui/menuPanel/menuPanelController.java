package pl.rr.project.s.gui.menuPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.gui.loginPanel.loginPanelMethods;

import java.io.IOException;

public class menuPanelController extends loginPanelMethods {

    @FXML
    private Button playButton;

    @FXML
    public void goToProfile(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/profilePanel.fxml", null, mouseEvent);
    }

    @FXML
    public void onMouseCarried(MouseEvent mouseEvent) {
        playButton.setTooltip(new Tooltip("Tooltip for Button"));
    }

    @FXML
    public void logout(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/loginPanel.fxml", null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }
}
