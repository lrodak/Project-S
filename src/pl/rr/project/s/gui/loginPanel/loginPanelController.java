package pl.rr.project.s.gui.loginPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.UserEnvironmental;

import java.io.IOException;

public class loginPanelController extends loginPanelMethods {

    @FXML
    private javafx.scene.control.TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label invalidText;
    @FXML
    private Label registrationCompleteText;


    @FXML
    public void login(MouseEvent mouseEvent) throws IOException {

        if(username.getText().isEmpty() || password.getText().isEmpty())
        {
            invalidText.setVisible(true);
        }
        else
        {
            UserEnvironmental.USERNAME= username.getText();
            UserEnvironmental.REGISTRATION_COMPLETE = false;
            goToScene("/fxml/menuPanel.fxml", null, mouseEvent);
        }
    }

    @FXML
    public void registrationComplete() //active on mouse entered
    {
        if(UserEnvironmental.REGISTRATION_COMPLETE)
        {
            registrationCompleteText.setVisible(true);
            username.setText(UserEnvironmental.TMPUSERNAME);
            password.requestFocus();
        }
        else if(registrationCompleteText.isVisible())
        {
            registrationCompleteText.setVisible(false);
        }
    }


    @FXML
    public void goToRegister(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/registerPanel.fxml",null,mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }

}
