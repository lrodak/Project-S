package pl.rr.project.s.gui.games.dino;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.gui.profilePanel.ProfilePanelMethods;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class dinoPanelController extends ProfilePanelMethods {

    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }
}

