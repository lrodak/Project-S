package pl.rr.project.s.gui.profilePanel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.rr.project.s.gui.menuPanel.menuPanelMethods;

import java.io.IOException;

public class profilePanelController {
    public profilePanelController() {
        profilePanelMethods profileMethods = new profilePanelMethods();
    }

    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/menuPanel.fxml"));
        Scene scene = new Scene(root);

        Stage window;
        window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
