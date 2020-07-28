package pl.rr.project.s.gui.registerPanel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.ApplicationSettings;
import pl.rr.project.s.UserEnvironmental;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;
import java.util.Locale;

public class RegisterPanelController extends RegisterPanelMethods {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Button registerButton;
    @FXML
    private Button backButton;
    @FXML
    private javafx.scene.control.TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label invalidUserText;
    @FXML
    private Label invalidPassText;
    @FXML
    private Label invalidGenText;
    @FXML
    private RadioButton maleGender;
    @FXML
    private RadioButton femaleGender;
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
                EventHandler<ActionEvent> event =
                        new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e)
                            {
                                //Change language
                                UserEnvironmental.locale = new Locale(languageComboBox.getValue());
                                setLabels();
                            }
                        };
                languageComboBox.setOnAction(event);
            }
        });
    }

    @FXML
    public void register(MouseEvent mouseEvent) throws IOException
    {
        invalidUserText.setVisible(false);
        invalidPassText.setVisible(false);
        invalidGenText.setVisible(false);
        UserEnvironmental.REGISTRATION_COMPLETE = false;

        if(username.getText().isEmpty()) {
            invalidUserText.setVisible(true);
        }
        if(password.getText().isEmpty()) {
            invalidPassText.setVisible(true);
        }
        if(!maleGender.isSelected() && !femaleGender.isSelected()) {
            invalidGenText.setVisible(true);
        }

        //Register complete
        if(!username.getText().isEmpty() && !password.getText().isEmpty() && (maleGender.isSelected() || femaleGender.isSelected())) {
            if(maleGender.isSelected()) {
                UserEnvironmental.GENDER = "Male";
            }
            if(femaleGender.isSelected()) {
                UserEnvironmental.GENDER = "Female";
            }

            UserEnvironmental.USERNAME = username.getText();
            UserEnvironmental.REGISTRATION_COMPLETE = true;
            UserEnvironmental.userList.add(username.getText());
            getSceneUtils().goToScene(SceneNames.LOGIN_SCENE, null, mouseEvent);
        }
    }

    @FXML
    public void choiceGenderMale() {
        femaleGender.setSelected(false);
    }

    @FXML
    public void choiceGenderFemale() {
        maleGender.setSelected(false);
    }

    @FXML
    public void backToLogin(MouseEvent mouseEvent) throws IOException {
        UserEnvironmental.REGISTRATION_COMPLETE = false;
        getSceneUtils().goToScene(SceneNames.LOGIN_SCENE, null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    public void setLabels() {
        usernameLabel.setText(ApplicationSettings.getMessage("USERNAME"));
        passwordLabel.setText(ApplicationSettings.getMessage("PASSWORD"));
        genderLabel.setText(ApplicationSettings.getMessage("GENDER"));
        maleGender.setText(ApplicationSettings.getMessage("MALE"));
        femaleGender.setText(ApplicationSettings.getMessage("FEMALE"));
        registerButton.setText(ApplicationSettings.getMessage("REGISTER"));
        backButton.setText(ApplicationSettings.getMessage("BACK"));
        invalidUserText.setText(ApplicationSettings.getMessage("INVALID_USERNAME"));
        invalidPassText.setText(ApplicationSettings.getMessage("INVALID_PASSWORD"));
        invalidGenText.setText(ApplicationSettings.getMessage("INVALID_GENDER"));
    }
}
