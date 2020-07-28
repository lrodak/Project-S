package pl.rr.project.s.gui.profilePanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class ProfilePanelController extends ProfilePanelMethods {

    @FXML
    private TextField username1;
    @FXML
    private ImageView avatar1;
    @FXML
    private Label description1;
    @FXML
    private TextField description2;
    @FXML
    private Button savedescription1;
    @FXML
    private VBox descriptionchangepanel;


    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    public void changeDescription(MouseEvent event) {
        descriptionchangepanel.setVisible(true);
    }

    @FXML
    public void saveDescription(MouseEvent event) {
        description1.setText(description2.getText());
        UserEnvironmental.DESCRIPTION = description1.getText();
        descriptionchangepanel.setVisible(false);
    }

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //change avatar
                setAvatar(avatar1,300,100);

                username1.setText(UserEnvironmental.USERNAME);
                description1.setText((UserEnvironmental.DESCRIPTION));
            }
        });
    }

}
