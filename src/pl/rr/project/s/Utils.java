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

    public void goToScene(Scenes sceneName, Stage primaryStage, MouseEvent event) throws IOException {
        Stage window;
        if (primaryStage != null) {
            window = primaryStage;
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setResizable(false);
        } else if (event != null) {
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else {
            throw new IOException();
        }

        window.setScene(setUsingScene(sceneName, window));

        // center on screen
        if (sceneName.equals(Scenes.MENU_SCENE) && !UserEnvironmental.INIT_MENU) {
            window.centerOnScreen();
            UserEnvironmental.INIT_MENU = true;
        }else if (sceneName.equals(Scenes.LOGIN_SCENE) && !UserEnvironmental.INIT_LOGIN){
            window.centerOnScreen();
            UserEnvironmental.INIT_LOGIN = true;
        }

        window.show();
    }

    /**
     * Set scene url and size
     */
    private Scene setUsingScene(Scenes sceneName, Stage window) throws IOException {
        Parent root = null;
        double x = 100;
        double y = 100;

        switch (sceneName) {
            case LOGIN_SCENE:
                x = Settings.LoginPanelWith;
                y = Settings.LoginPanelHigh;
                root = FXMLLoader.load(getClass().getResource("/fxml/loginPanel.fxml"));
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

        Scene currentScene = new Scene(root, x, y);

//        Stage moving by mouse drag
        final double[] xOffset = {0};
        final double[] yOffset = {0};
        currentScene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset[0] = event.getSceneX();
                yOffset[0] = event.getSceneY();
            }
        });
        currentScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset[0]);
                window.setY(event.getScreenY() - yOffset[0]);
            }
        });

        return currentScene;
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
