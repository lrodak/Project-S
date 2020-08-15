package pl.rr.project.s.gui.games.futureFortune;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import pl.rr.project.s.gui.scenes.SceneNames;

import java.io.IOException;

public class FutureFortuneController extends FutureFortuneMethods {
    @FXML
    private Label progress;
    @FXML
    private ProgressBar loadingBar;

    @FXML
    public void initialize() throws InterruptedException {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 101; i++) {
                    if (i == 0) {
                        progress.setText("Checking...");
                    } else if (i == 50){
                        progress.setText("Starting...");
                    }
                    loadingBar.setProgress(i);
                }
                progress.setText("Ready");
                Application.main();
            }
        });

    }

    @FXML
    public void goBackToMenu(MouseEvent mouseEvent) throws IOException {
        getSceneUtils().goToScene(SceneNames.MENU_SCENE, null, mouseEvent);
    }
}
