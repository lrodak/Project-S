package pl.rr.project.s.gui.menuPanel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.rr.project.s.gui.loginPanel.loginPanelMethods;

import java.io.IOException;

public class menuPanelController {
    public menuPanelController() {
        menuPanelMethods menuMethods = new menuPanelMethods();
    }

    @FXML
    private Button playButton;

    @FXML
    public void goToProfile(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/profilePanel.fxml"));
        Scene scene = new Scene(root);

        Stage window;
        window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void onMouseCarried(MouseEvent mouseEvent) {
        playButton.setTooltip(new Tooltip("Tooltip for Button"));
    }

    @FXML
    public void logout(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginPanel.fxml"));
        Scene scene = new Scene(root);

        Stage window;
        window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
