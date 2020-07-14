package pl.rr.project.s;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginPanel.fxml"));
        primaryStage.setTitle("Project-S");
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
        primaryStage.setResizable(false);
        //komit2
    }


    public static void main(String[] args) {
        launch(args);
    }
}
