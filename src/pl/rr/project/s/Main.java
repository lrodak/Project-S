package pl.rr.project.s;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.rr.project.s.gui.scenes.SceneNames;
import pl.rr.project.s.gui.scenes.SceneUtils;


public class Main extends Application {

//    public static Object autoLoginObject;
    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneUtils sceneUtils = new SceneUtils();
        sceneUtils.goToScene(SceneNames.LOGIN_SCENE, primaryStage, null);
    }


    public static void main(String[] args) {
        launch(args);
//        System.out.println(Main.applicationSettings("windowSizeX"));
//        System.out.println(Main.applicationSettings("windowSizeY"));
//        String[] autoLoginObject = new String[2];
//        autoLoginObject[0] = "Login";
//        autoLoginObject[1] = "Haslo";
    }


}
