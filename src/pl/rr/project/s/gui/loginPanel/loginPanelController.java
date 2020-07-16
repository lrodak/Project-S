package pl.rr.project.s.gui.loginPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class loginPanelController extends loginPanelMethods {

    @FXML
    public void goToMenu(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/menuPanel.fxml", null, mouseEvent);
    }

    @FXML
    public void goToRegister(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/registerPanel.fxml",null,mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }

}
