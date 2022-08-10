package graphics;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new App();
            ex.setVisible(true);
        });
    }

    App() {
        initUI();
    }

    private void initUI() {
        var drawPanel = new DrawImage();
//        drawPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        add(drawPanel);

        setSize(350, 250);
        setTitle("Points");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

