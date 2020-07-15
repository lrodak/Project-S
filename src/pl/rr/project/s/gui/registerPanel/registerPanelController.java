package pl.rr.project.s.gui.registerPanel;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.rr.project.s.gui.profilePanel.profilePanelMethods;

import java.io.IOException;

public class registerPanelController {
    public registerPanelController() {
        registerPanelMethods registerMethods = new registerPanelMethods();
    }

    @FXML
    public void goLoginPanel(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginPanel.fxml"));
        Scene scene = new Scene(root);
        Stage window;
        window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        Platform.exit();
    }
}
