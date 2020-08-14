package pl.rr.project.s.gui.loginPanel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.ApplicationSettings;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;
import java.util.Locale;

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
    private ComboBox<String> languageComboBox;

    @FXML
    public void initialize() {
        setLabels();
        //Language Combo Box
        languageComboBox.getItems().add("EN");
        languageComboBox.getItems().add("PL");
        languageComboBox.getSelectionModel().select(UserEnvironmental.locale.toString().toUpperCase());

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //Password checkBox remember
                rememberPasswordBox.setSelected(UserEnvironmental.REMEMBER_PASSWORD.equals("true"));

                EventHandler<ActionEvent> event =
                        new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                //Change language
                                UserEnvironmental.locale = new Locale(languageComboBox.getValue());
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
            getSceneUtils().goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
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
        if(rememberPasswordBox.isSelected())
               UserEnvironmental.REMEMBER_PASSWORD = "true";
        else
            UserEnvironmental.REMEMBER_PASSWORD = "false";
    }

    @FXML
    public void goToRegister(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.REGISTER_SCENE, null, mouseEvent);
    }

    @FXML
    public void exitApplication() {
        Platform.exit();
    }

    @FXML
    public void setLabels() {
        usernameLabel.setText(ApplicationSettings.getMessage("USERNAME"));
        passwordLabel.setText(ApplicationSettings.getMessage("PASSWORD"));
        rememberPasswordBox.setText(ApplicationSettings.getMessage("REMEMBER_PASSWORD"));
        loginButton.setText(ApplicationSettings.getMessage("LOGIN"));
        cancelButton.setText(ApplicationSettings.getMessage("CANCEL"));
        CreateAccountButton.setText(ApplicationSettings.getMessage("CREATE_ACCOUNT"));
        registrationCompleteText.setText(ApplicationSettings.getMessage("REGISTRATION_COMPLETE"));
        invalidText.setText(ApplicationSettings.getMessage("INVALID_USERNAME_PASSWORD"));
    }

    public void key(KeyEvent keyEvent){
        System.out.println(keyEvent);
    }
}
