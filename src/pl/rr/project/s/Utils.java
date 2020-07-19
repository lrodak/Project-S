package pl.rr.project.s;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;


//universal methods for multi-purpose
public class Utils<daysOfWeek, items> {

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







    public void savePassword() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Passy.data"));
            outputStream.writeObject(Main.autoLoginObject);
        } catch (IOException ex) {
            System.out.println("Saving error");
            ex.printStackTrace();
        }
    }

    public void readPassword() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Passy.data"));
            Object autoLoginObject = inputStream.readObject();
        } catch (Exception ex) {
            System.out.println("Reading error");
            ex.printStackTrace();
        }
    }

}
