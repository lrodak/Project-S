package pl.rr.project.s.gui.registerPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.UserEnvironmental;

import java.io.IOException;

public class registerPanelController extends registerPanelMethods{

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
    public void register(MouseEvent mouseEvent) throws IOException
    {
        invalidUserText.setVisible(false);
        invalidPassText.setVisible(false);
        invalidGenText.setVisible(false);
        UserEnvironmental.REGISTRATION_COMPLETE = false;

        if(username.getText().isEmpty())
        {
            invalidUserText.setVisible(true);
        }
        if(password.getText().isEmpty())
        {
            invalidPassText.setVisible(true);
        }
        if(!maleGender.isSelected() && !femaleGender.isSelected())
        {
            invalidGenText.setVisible(true);
        }

        //Register complete
        if(!username.getText().isEmpty() && !password.getText().isEmpty() && (maleGender.isSelected() || femaleGender.isSelected()))
        {
            if(maleGender.isSelected())
            {
                UserEnvironmental.GENDER = "Male";
            }
            if(femaleGender.isSelected())
            {
                UserEnvironmental.GENDER = "Female";
            }

            UserEnvironmental.TMPUSERNAME = username.getText();
            UserEnvironmental.REGISTRATION_COMPLETE = true;
            goToScene("/fxml/loginPanel.fxml", null, mouseEvent);

        }

    }

    @FXML
    public void choiceGenderMale()
    {
        femaleGender.setSelected(false);
    }

    @FXML
    public void choiceGenderFemale()
    {
        maleGender.setSelected(false);
    }

    @FXML
    public void backToLogin(MouseEvent mouseEvent) throws IOException {
        UserEnvironmental.REGISTRATION_COMPLETE = false;
        goToScene("/fxml/loginPanel.fxml", null, mouseEvent);
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }
}
