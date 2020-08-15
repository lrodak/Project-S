package pl.rr.project.s.gui.games.futureFortune;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public Application() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        //setSize(250, 200);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);

        setTitle("Future Fortune");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //add menu name
        JLabel menuLabel = new JLabel("Future Fortune");
//        menuLabel.setBounds(40,40,JLabel.CENTER, JLabel.CENTER);
        menuLabel.setSize(100,40);
        menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        menuLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//        menuLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(menuLabel);

        var initialText = "Golden Coins";
        var area = new JTextArea(initialText, 8, 50);
//        this.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        JButton btn1 = new JButton("One");
        JButton btn2 = new JButton("Two");
        JButton btn3 = new JButton("Three");
        JButton btn4 = new JButton("Four");
        JButton btn5 = new JButton("Five");
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(area);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setPreferredSize(new Dimension(400, 100));
        panel.setMaximumSize(new Dimension(400, 100));
        panel.setBorder(BorderFactory.createTitledBorder("demo"));
        this.getContentPane().add(panel);
    }

    public static void main() {

        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
