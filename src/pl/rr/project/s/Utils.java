package pl.rr.project.s;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

//universal methods for multi-purpose
public class Utils {

    public void goToScene(String sceneName, Stage stage, MouseEvent event) throws IOException {
        Parent root = null;

        root = FXMLLoader.load(getClass().getResource(sceneName));
        Scene scene = new Scene(root);

        Stage window;
        if (stage != null) {
            window = stage;
//            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        } else if (event != null) {
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else {
            throw new IOException();
        }

        window.setScene(scene);
        window.show();
    }
}
