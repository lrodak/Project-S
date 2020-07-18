package pl.rr.project.s.gui.registerPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class registerPanelController extends registerPanelMethods{

    @FXML
    private javafx.scene.control.TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Label invalidUser;
    @FXML
    private Label invalidPass;
    @FXML
    private Label invalidGen;

    @FXML
    private RadioButton maleGender;
    @FXML
    private RadioButton femaleGender;

    @FXML
    public void register(MouseEvent mouseEvent) throws IOException
    {
        invalidUser.setVisible(false);
        invalidPass.setVisible(false);
        invalidGen.setVisible(false);

        if(username.getText().isEmpty())
        {
            invalidUser.setVisible(true);
        }
        if(password.getText().isEmpty())
        {
            invalidPass.setVisible(true);
        }
        if(!maleGender.isSelected() && !femaleGender.isSelected())
        {
            invalidGen.setVisible(true);
        }

        if(!username.getText().isEmpty() && !password.getText().isEmpty() && (maleGender.isSelected() || femaleGender.isSelected()))
        {
            goToScene("/fxml/loginPanel.fxml", null, mouseEvent);
        }

    }

    public void choiceGenderMale()
    {
        femaleGender.setSelected(false);
    }
    public void choiceGenderFemale()
    {
        maleGender.setSelected(false);
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
