package pl.rr.project.s.gui.loginPanel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.scenes.GoToScene;
import pl.rr.project.s.gui.scenes.SceneNames;
import pl.rr.project.s.language.ChangeLanguage;
import pl.rr.project.s.language.CurrentLanguage;

import java.io.IOException;

public class LoginPanelController extends LoginPanelMethods {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private CheckBox rememberPasswordBox;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button CreateAccountButton;
    @FXML
    private javafx.scene.control.TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label invalidText;
    @FXML
    private Label registrationCompleteText;
    @FXML
    private ComboBox languageComboBox;
    GoToScene goToScene = new GoToScene();

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                setLabels();

                //Password checkBox remember
                rememberPasswordBox.setSelected(UserEnvironmental.REMEMBER_PASSWORD);

                //Language Combo Box
                languageComboBox.getItems().add("ENG");
                languageComboBox.getItems().add("PL");
                languageComboBox.getSelectionModel().select(UserEnvironmental.LANGUAGE);
                languageComboBox.getEditor().setCursor(Cursor.HAND);
                EventHandler<ActionEvent> event =
                        new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                //Change language
                                UserEnvironmental.LANGUAGE = languageComboBox.getValue().toString();
                                ChangeLanguage.changeLanguage(UserEnvironmental.LANGUAGE);
                                setLabels();
                            }
                        };
                languageComboBox.setOnAction(event);


                //Registration complete
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
        UserEnvironmental.REMEMBER_PASSWORD = rememberPasswordBox.isSelected();
    }

    @FXML
    public void goToRegister(MouseEvent mouseEvent) throws IOException {
        goToScene.goToScene(SceneNames.REGISTER_SCENE, null, mouseEvent);
    }

    @FXML
    public void exitApplication() {
        Platform.exit();
    }

    @FXML
    public void setLabels()
    {
        usernameLabel.setText(CurrentLanguage.USERNAME);
        passwordLabel.setText(CurrentLanguage.PASSWORD);
        rememberPasswordBox.setText(CurrentLanguage.REMEMBER_PASSWORD);
        loginButton.setText(CurrentLanguage.LOGIN);
        cancelButton.setText(CurrentLanguage.CANCEL);
        CreateAccountButton.setText(CurrentLanguage.CREATE_ACCOUNT);
    }
}
