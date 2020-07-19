package pl.rr.project.s;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;


//universal methods for multi-purpose
public class Utils {

    public void goToScene(Scenes sceneName, Stage stage, MouseEvent event) throws IOException {
        Parent root = null;
        double x = 100;
        double y = 100;

        switch (sceneName) {
            case LOGIN_SCENE:
                x = Settings.LoginPanelWith;
                y = Settings.LoginPanelHigh;
                root = FXMLLoader.load(getClass().getResource("/fxml/loginPanel.fxml"));
                if (stage != null) {
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setResizable(false);
                }
                break;
            case REGISTER_SCENE:
                x = Settings.RegisterPanelWith;
                y = Settings.RegisterPanelHigh;
                root = FXMLLoader.load(getClass().getResource("/fxml/registerPanel.fxml"));
                break;
            case MENU_SCENE:
                x = Settings.MenuPanelWith;
                y = Settings.MenuPanelHigh;
                root = FXMLLoader.load(getClass().getResource("/fxml/menuPanel.fxml"));
                break;
            case PROFILE_SCENE:
                x = Settings.ProfilePanelWith;
                y = Settings.ProfilePanelHigh;
                root = FXMLLoader.load(getClass().getResource("/fxml/profilePanel.fxml"));
                break;
        }
        Scene scene = new Scene(root, x, y);

        Stage window;
        if (stage != null) {
            window = stage;
//            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        } else if (event != null) {
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else {
            throw new IOException();
        }

        //Stage moving by mouse drag
        final double[] xOffset = {0};
        final double[] yOffset = {0};

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset[0] = event.getSceneX();
                yOffset[0] = event.getSceneY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset[0]);
                window.setY(event.getScreenY() - yOffset[0]);
            }
        });

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
