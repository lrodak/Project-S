package pl.rr.project.s.gui.games.futureFortune;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(250, 200);

        setTitle("Future Fortune");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel clicks = new JLabel("Text-Only Label");
    }

    public static void main() {

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
