package pl.rr.project.s.gui.profilePanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.scenes.GoToScene;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class ProfilePanelController extends ProfilePanelMethods {
    GoToScene goToScene = new GoToScene();

    @FXML
    private TextField username1;
    @FXML
    private ImageView avatar1;
    @FXML
    private TextField description1;
    @FXML
    private Polygon goback1;
    @FXML
    private TextField myprofile1;


    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        goToScene.goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (UserEnvironmental.IMAGE_CHOSEN==0){
                    avatar1.setImage(UserEnvironmental.ADMIN_IMAGE);
                }
                else avatar1.setImage(UserEnvironmental.WHITE_SOMETHING);

                username1.setText(UserEnvironmental.USERNAME);
                description1.setText((UserEnvironmental.DESCRIPTION));
            }
        });
    }

}
