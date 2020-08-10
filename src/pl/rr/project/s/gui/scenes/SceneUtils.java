package pl.rr.project.s.gui.scenes;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.rr.project.s.Settings;
import pl.rr.project.s.UserEnvironmental;

import java.io.IOException;

public class SceneUtils {
    public void goToScene(SceneNames sceneName, Stage primaryStage, MouseEvent event) throws IOException {
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
        if (sceneName.equals(SceneNames.MENU_SCENE) && !UserEnvironmental.INIT_MENU) {
            window.centerOnScreen();
            UserEnvironmental.INIT_MENU = true;
        } else if (sceneName.equals(SceneNames.LOGIN_SCENE) && !UserEnvironmental.INIT_LOGIN) {
            window.centerOnScreen();
            UserEnvironmental.INIT_LOGIN = true;
        }

        window.show();
    }

    /**
     * Set scene url and size
     */
    private Scene setUsingScene(SceneNames sceneName, Stage window) throws IOException {
        Parent root = null;
        double x = 100;
        double y = 100;

        switch (sceneName) {
            case LOGIN_SCENE:
                x = Settings.LoginPanelWith;
                y = Settings.LoginPanelHigh;
//                x = ApplicationSettings.setSettings("LoginPanelWith");
//                y = ApplicationSettings.setSettings("LoginPanelHigh");
                root = FXMLLoader.load(getClass().getResource("/pl/rr/project/s/gui/loginPanel/loginPanel.fxml"));
                break;
            case REGISTER_SCENE:
                x = Settings.RegisterPanelWith;
                y = Settings.RegisterPanelHigh;
//                x = ApplicationSettings.setSettings("RegisterPanelWith");
//                y = ApplicationSettings.setSettings("RegisterPanelHigh");
                root = FXMLLoader.load(getClass().getResource("/pl/rr/project/s/gui/registerPanel/registerPanel.fxml"));
                break;
            case MENU_SCENE:
                x = Settings.MenuPanelWith;
                y = Settings.MenuPanelHigh;
                root = FXMLLoader.load(getClass().getResource("/pl/rr/project/s/gui/menuPanel/menuPanel.fxml"));
                break;
            case PROFILE_SCENE:
                x = Settings.ProfilePanelWith;
                y = Settings.ProfilePanelHigh;
                root = FXMLLoader.load(getClass().getResource("/pl/rr/project/s/gui/profilePanel/profilePanel.fxml"));
                break;
            case MINECRAFT_SCENE:
                x = Settings.MinecraftPanelWith;
                y = Settings.MinecraftPanelHigh;
                root = FXMLLoader.load(getClass().getResource("/pl/rr/project/s/gui/games/minecraft/minecraftPanel.fxml"));
                window.initStyle(StageStyle.DECORATED);
                break;
            case DINO_SCENE:
                x = Settings.DinoPanelWith;
                y = Settings.DinoPanelHigh;
                root = FXMLLoader.load(getClass().getResource("/pl/rr/project/s/gui/games/dino/dinoPanel.fxml"));
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
}
