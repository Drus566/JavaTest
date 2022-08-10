package graphics.example;

/*
Line joins are decorations applied at the intersection of two path segments and at the intersection of the endpoints of a subpath.


    JOIN_BEVEL — joins path segments by connecting the outer corners of their wide outlines with a straight segment.
    JOIN_MITER — joins path segments by extending their outside edges until they meet.
    JOIN_ROUND — joins path segments by rounding off the corner at a radius of half the line width.

 */

import javax.swing.*;
import java.awt.*;

class Join extends JPanel {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.drawRect(15,15,80,50);

        BasicStroke bs2 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs2);
        g2d.drawRect(125,15,80,50);

        BasicStroke bs3 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs3);
        g2d.drawRect(235,15,80,50);

        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class JoinsEx extends JFrame {
    public JoinsEx() {
        initUI();
    }

    private void initUI() {
        add(new Join());

        setTitle("Joins");
        setSize(340, 110);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JoinsEx ex = new JoinsEx();
                ex.setVisible(true);
            }
        });
    }
}
