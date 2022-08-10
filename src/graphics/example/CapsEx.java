package graphics.example;

/*

    CAP_BUTT — ends unclosed subpaths and dash segments with no added decoration.
    CAP_ROUND — ends unclosed subpaths and dash segments with a round decoration that has a radius equal to half of the width of the pen.
    CAP_SQUARE — ends unclosed subpaths and dash segments with a square projection that extends beyond the end of the segment to a distance equal to half of the line width.

 */

import javax.swing.*;
import java.awt.*;

class Caps extends JPanel {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.drawLine(20, 30,250,30);

        BasicStroke bs2 = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs2);
        g2d.drawLine(20,80,250,80);

        BasicStroke bs3 = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs3);
        g2d.drawLine(20,130,250,130);

        BasicStroke bs4 = new BasicStroke();
        g2d.setStroke(bs4);

        g2d.drawLine(20,20,20,140);
        g2d.drawLine(250,20,250,140);
        g2d.drawLine(254,20,254,140);

        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
public class CapsEx extends JFrame {
    public CapsEx() {
        initUI();
    }

    private void initUI() {
        add(new Caps());

        setTitle("Caps");
        setSize(280, 270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CapsEx ex = new CapsEx();
                ex.setVisible(true);
            }
        });
    }
}
