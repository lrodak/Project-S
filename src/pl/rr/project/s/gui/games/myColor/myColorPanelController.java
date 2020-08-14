package pl.rr.project.s.gui.games.myColor;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class myColorPanelController extends myColorPanelMethods
{
    @FXML
    public void startGame() {
        if(Desktop.isDesktopSupported()) {

            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI("https://diabe77.itch.io/mycolor"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
       }
    }

    @FXML
    public void goToMenu(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }


}
