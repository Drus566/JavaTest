package graphics;

import javax.swing.*;
import java.awt.*;

public class DrawGradients extends JPanel {
    private void doDrawing(Graphics g) {
        var g2d = (Graphics2D) g;
        var gp1 = new GradientPaint(5, 5, Color.RED, 20, 20, Color.black, true);

        g2d.setPaint(gp1);
        g2d.fillRect(20,20,300,40);

        var gp2 = new GradientPaint(5,25,Color.yellow,20,2,Color.black, true);
        g2d.setPaint(gp2);
        g2d.fillRect(20,80,300,40);

        var gp3 = new GradientPaint(5,25,Color.green,2,2,Color.black, true);
        g2d.setPaint(gp3);
        g2d.fillRect(20, 140, 300, 40);

        var gp4 = new GradientPaint(25,25, Color.blue, 15,25,Color.black, true);
        g2d.setPaint(gp4);
        g2d.fillRect(20,200,300,40);

        var gp5 = new GradientPaint(0,0,Color.orange,0,20,Color.black, true);
        g2d.setPaint(gp5);
        g2d.fillRect(20,260,300,40);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
