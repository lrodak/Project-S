package pl.rr.project.s.gui.loginPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.scenes.GoToScene;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class LoginPanelController extends LoginPanelMethods {

    @FXML
    private javafx.scene.control.TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label invalidText;
    @FXML
    private Label registrationCompleteText;
    @FXML
    private CheckBox RememberPasswordBox;
    GoToScene goToScene = new GoToScene();

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                RememberPasswordBox.setSelected(UserEnvironmental.REMEMBER_PASSWORD);

                if (UserEnvironmental.REGISTRATION_COMPLETE) {
                    registrationCompleteText.setVisible(true);
                    username.setText(UserEnvironmental.USERNAME);
                    password.requestFocus();
                } else if (registrationCompleteText.isVisible()) {
                    registrationCompleteText.setVisible(false);
                }
            }
        });
    }

    /**
     * Just normal login
     */
    @FXML
    public void login(MouseEvent mouseEvent) throws IOException {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            invalidText.setVisible(true);
        } else if (checkLogin(username.getText())) {
            UserEnvironmental.REGISTRATION_COMPLETE = false;
            goToScene.goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
        } else {
            invalidText.setVisible(true);
        }
    }

    @FXML
    public void autoLogin(MouseEvent mouseEvent) throws IOException {
        username.setText("admin");
        password.setText("admin");
        UserEnvironmental.GENDER = "Male";
        login(mouseEvent);
    }

    @FXML
    public void checkRememberPassword() {
        UserEnvironmental.REMEMBER_PASSWORD = RememberPasswordBox.isSelected();
    }

    @FXML
    public void goToRegister(MouseEvent mouseEvent) throws IOException {
        goToScene.goToScene(SceneNames.REGISTER_SCENE, null, mouseEvent);
    }

    @FXML
    public void exitApplication() {
        Platform.exit();
    }
}
