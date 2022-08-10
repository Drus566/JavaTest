package graphics.example;

import javax.swing.*;
import java.awt.*;

class Line extends JPanel {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawLine(30,30,200,30);
        g2d.drawLine(200,30,30,200);
        g2d.drawLine(30,200,200,200);
        g2d.drawLine(200,200,30,30);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class LineEx extends JFrame {
    public LineEx() {
        initUI();
    }

    private void initUI() {
        add(new Line());

        setTitle("Lines");
        setSize(350,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LineEx ex = new LineEx();
                ex.setVisible(true);
            }
        });
    }
}
