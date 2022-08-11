package graphics.example.transformations;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

class Scaling extends JPanel {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(new Color(150, 150, 150));
        g2d.fillRect(20,20,80,50);

        AffineTransform tx1 = new AffineTransform();
        tx1.translate(110,22);
        tx1.scale(0.5,0.5);

        g2d.setTransform(tx1);
        g2d.fillRect(0,0,80,50);

        AffineTransform tx2 = new AffineTransform();
        tx2.translate(170, 20);
        tx2.scale(1.5,1.5);

        g2d.setTransform(tx2);
        g2d.fillRect(0,0,80,50);

        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class ScalingEx extends JFrame {
    public ScalingEx() {
        initUI();
    }

    private void initUI() {
        setTitle("Rotation");

        add(new Scaling());
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScalingEx ex = new ScalingEx();
                ex.setVisible(true);
            }
        });
    }
}
