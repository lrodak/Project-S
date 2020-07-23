package pl.rr.project.s.gui.menuPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
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
    private Button gotoProfileButton;
    @FXML
    private ImageView image;
    @FXML
    private Label nick;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (UserEnvironmental.IMAGE_CHOSEN==0){
                    image.setImage(UserEnvironmental.ADMIN_IMAGE);
                }
                else image.setImage(UserEnvironmental.WHITE_SOMETHING);

                nick.setText(UserEnvironmental.USERNAME);
            }
        });
    }

    @FXML
    public void goToProfile(MouseEvent mouseEvent) throws IOException {
        goToScene(Scenes.PROFILE_SCENE, null, mouseEvent);
    }

    @FXML
    public void onMouseCarried(MouseEvent mouseEvent) {
        gotoProfileButton.setTooltip(new Tooltip("View my profile"));
        gotoProfileButton.setCursor(Cursor.HAND);
    }


    @FXML
    public void logout(MouseEvent mouseEvent) throws IOException {
        UserEnvironmental.INIT_LOGIN=false;
        UserEnvironmental.INIT_MENU=false;
        goToScene(Scenes.LOGIN_SCENE, null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }
}
