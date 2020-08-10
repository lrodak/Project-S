package pl.rr.project.s.gui.games.futureFortune;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class FutureFortuneController extends FutureFortuneMethods{
    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }
}
