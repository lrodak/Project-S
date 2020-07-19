package pl.rr.project.s.gui.profilePanel;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.Scenes;

import java.io.IOException;

public class ProfilePanelController extends ProfilePanelMethods {

    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        goToScene(Scenes.MENU_SCENE, null, mouseEvent);
    }
}
