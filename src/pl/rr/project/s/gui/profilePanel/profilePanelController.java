package pl.rr.project.s.gui.profilePanel;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class profilePanelController extends profilePanelMethods{

    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/menuPanel.fxml", null, mouseEvent);
    }
}
