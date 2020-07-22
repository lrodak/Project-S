package pl.rr.project.s;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static Object autoLoginObject;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Utils utils = new Utils();
        utils.goToScene(Scenes.LOGIN_SCENE, primaryStage, null);
    }


    public static void main(String[] args) {
        launch(args);

        String[] autoLoginObject = new String[2];
        autoLoginObject[0] = "Login";
        autoLoginObject[1] = "Haslo";
    }
}
