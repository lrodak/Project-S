package pl.rr.project.s.gui.menuPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.Scenes;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.loginPanel.LoginPanelMethods;

import java.io.IOException;

public class MenuPanelController extends LoginPanelMethods {

    @FXML
    private Button playButton;
    @FXML
    private ImageView image;
    @FXML
    private Label nick;

    @FXML
    public void goToProfile(MouseEvent mouseEvent) throws IOException {
        goToScene(Scenes.PROFILE_SCENE, null, mouseEvent);
    }

    @FXML
    public void onMouseCarried(MouseEvent mouseEvent) {
        playButton.setTooltip(new Tooltip("Tooltip for Button"));
    }

    @FXML
    public void logout(MouseEvent mouseEvent) throws IOException {
        goToScene(Scenes.LOGIN_SCENE, null, mouseEvent);
    }
    @FXML
    public void refresh(MouseEvent event){
        image.setImage(UserEnvironmental.ADMIN_IMAGE);
        nick.setText(UserEnvironmental.USERNAME);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }
}
