package pl.rr.project.s.gui.registerPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class registerPanelController extends registerPanelMethods{

    @FXML
    private javafx.scene.control.TextField username_ID;
    @FXML
    private PasswordField password_ID;
    @FXML
    private Label invalid;

    @FXML
    public void register(MouseEvent mouseEvent) throws IOException
    {
        if(username_ID.getText().isEmpty() || password_ID.getText().isEmpty())
        {
            invalid.setVisible(true);
        }
        else
        {
            goToScene("/fxml/loginPanel.fxml", null, mouseEvent);
        }

    }



    @FXML
    public void goLoginPanel(MouseEvent mouseEvent) throws IOException {
        goToScene("/fxml/loginPanel.fxml", null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }
}
