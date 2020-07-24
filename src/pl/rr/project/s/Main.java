package pl.rr.project.s;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.rr.project.s.gui.scenes.GoToScene;
import pl.rr.project.s.gui.scenes.SceneNames;


public class Main extends Application {

    public static Object autoLoginObject;


    @Override
    public void start(Stage primaryStage) throws Exception {
        GoToScene goToScene = new GoToScene();
        goToScene.goToScene(SceneNames.LOGIN_SCENE, primaryStage, null);
    }


    public static void main(String[] args) {
        launch(args);

        String[] autoLoginObject = new String[2];
        autoLoginObject[0] = "Login";
        autoLoginObject[1] = "Haslo";
    }
}
