package pl.rr.project.s.gui.loginPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class loginPanelController extends loginPanelMethods {

    @FXML
     private javafx.scene.control.TextField username_ID;
    @FXML
     private PasswordField password_ID;
    @FXML
    private Label invalid;

    @FXML
    public void login(MouseEvent mouseEvent) throws IOException {

        if(username_ID.getText().isEmpty() || password_ID.getText().isEmpty())
        {
            invalid.setVisible(true);
        }
        else
        {
            goToScene("/fxml/menuPanel.fxml", null, mouseEvent);
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
