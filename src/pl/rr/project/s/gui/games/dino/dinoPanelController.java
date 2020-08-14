package pl.rr.project.s.gui.games.dino;

import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;
import pl.rr.project.s.gui.profilePanel.ProfilePanelMethods;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class dinoPanelController extends ProfilePanelMethods {

    @FXML
    private Button startButton;
    @FXML
    private Ellipse circle;
    @FXML
    private Pane dinoPane;
    @FXML
    private Ellipse player;

    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }

    public void jump(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
                TranslateTransition dd =
                        new TranslateTransition(Duration.seconds(5), player);

               dd.setFromY( dinoPane.getPrefHeight() );
               dd.setToY(- dinoPane.getPrefHeight() );
               dd.setCycleCount( Timeline.INDEFINITE );
               dd.play();

        }

    }
    @FXML
    public void startAnimation(MouseEvent mouseEvent) throws IOException {
        TranslateTransition tt =
                new TranslateTransition(Duration.seconds(5), circle);

        tt.setFromX( dinoPane.getPrefWidth() );
        tt.setToX(- dinoPane.getPrefWidth() );
        tt.setCycleCount( Timeline.INDEFINITE );
        tt.play();
    }

}

