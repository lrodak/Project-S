package pl.rr.project.s.gui.menuPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.ApplicationSettings;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.loginPanel.LoginPanelMethods;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class MenuPanelController extends LoginPanelMethods {

    @FXML
    private Button gotoProfileButton;
    @FXML
    private Button logoutButton;
    @FXML
    private ImageView image;
    @FXML
    private ImageView dinoImage;
    @FXML
    private Label nick;
    @FXML
    private Label descriptionField;
    @FXML
    private Button gotoDinoButton;
    @FXML
    private Button gotoMinecraftButton;
    @FXML
    private Label versionField;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //change avatar
                setAvatar(image,200,86);
//                dinoImage.setImage(UserEnvironmental.DINO_IMAGE);
                nick.setText(UserEnvironmental.USERNAME);
                descriptionField.setText((UserEnvironmental.DESCRIPTION));

                logoutButton.setText(ApplicationSettings.getMessage("LOGOUT"));
                versionField.setText(ApplicationSettings.getMessage("VERSION"));
            }
        });
    }

    @FXML
    public void goToProfile(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.PROFILE_SCENE, null, mouseEvent);
    }

    @FXML
    public void goToDino(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.DINO_SCENE, null, mouseEvent);
    }
    @FXML
    public void goToMyColor(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.MYCOLOR_SCENE, null, mouseEvent);
    }
    @FXML
    public void goToFutureFortune(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.FUTUREFORTUNE_SCENE, null, mouseEvent);
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
        UserEnvironmental.FIRST_RANDOM_AVATAR = true;
        getSceneUtils().goToScene(SceneNames.LOGIN_SCENE, null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }

}
