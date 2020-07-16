package pl.rr.project.s.gui.registerPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class registerPanelController extends registerPanelMethods{

    @FXML
    public void goLoginPanel(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/menuPanel.fxml", null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }
}
