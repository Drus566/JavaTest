package graphics.example.transformations;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

class Shearing extends JPanel {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        AffineTransform tx1 = new AffineTransform();
        tx1.translate(50, 90);

        g2d.setTransform(tx1);
        g2d.setPaint(Color.green);
        g2d.drawRect(0, 0, 160, 50);

        AffineTransform tx2 = new AffineTransform();
        tx2.translate(50, 90);
        tx2.shear(0, 1);

        g2d.setTransform(tx2);
        g2d.setPaint(Color.blue);

        g2d.draw(new Rectangle(0,0,80,50));

        AffineTransform tx3 = new AffineTransform();
        tx3.translate(130, 10);
        tx3.shear(-1, 1);

        g2d.setTransform(tx3);
        g2d.setPaint(Color.red);
        g2d.drawRect(0,0,80,50);

        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class ShearingEx extends JFrame {
    public ShearingEx() {
        initUI();
    }

    private void initUI() {
        setTitle("Rotation");

        add(new Shearing());
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShearingEx ex = new ShearingEx();
                ex.setVisible(true);
            }
        });
    }
}
