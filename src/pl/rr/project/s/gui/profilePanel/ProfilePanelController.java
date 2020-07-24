package pl.rr.project.s.gui.profilePanel;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.gui.scenes.GoToScene;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class ProfilePanelController extends ProfilePanelMethods {
    GoToScene goToScene = new GoToScene();

    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        goToScene.goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }
}
