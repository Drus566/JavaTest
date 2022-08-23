package graphics.makarov;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class Func extends JPanel {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(150, 150, 150));

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // g2d.fillRect(30, 20, 50, 50);
        // g2d.fillRect(120, 20, 90, 60);
        // g2d.fillRoundRect(250,20,70,60,25,25);

        // g2d.fill(new Ellipse2D.Double(10,100,80,100));
        // g2d.fillArc(120,130,100,100,0,180);
//        g2d.setPaint(Color.BLACK);
//        g2d.drawLine(120,130,121,131);

        g2d.draw(new QuadCurve2D.Double(30,50,0,200,100,0));
        g2d.draw(new CubicCurve2D.Double(130, 150, 350,0,100,0,300,150));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
class FuncStroke extends JPanel {

    int[][] coords = {{50, 500},{300, 50}, {550, 500}};
    int[][] quadCoord = {{0,0}, {0,0}, {0,0}};

    private Dimension getCoord(int x) {
        Dimension n = new Dimension(coords[x][0], coords[x][1]);
        return n;
    }
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        float[] dash1 = {2f, 0f, 2f};
        //float[] dash2 = {1f, 1f, 1f};
        //float[] dash3 = {4f, 0f, 2f};
        //float[] dash4 = {4f, 4f, 1f};

        // g2d.drawLine(20, 40, 250, 40);

        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        g2d.setStroke(bs1);



        Path2D.Double triangles = new Path2D.Double();
       // triangles.moveTo(50, 250);
        triangles.moveTo(getCoord(0).width, getCoord(0).height);
        triangles.lineTo(getCoord(1).width, getCoord(1).height);
        triangles.lineTo(getCoord(2).width, getCoord(2).height);
        triangles.lineTo(getCoord(0).width, getCoord(0).height);



       // triangles.quadTo(270,50, 260, 30);
       // triangles.lineTo(400, 400);
       // triangles.quadTo(400,420, 380, 420);
       // triangles.lineTo(100, 420);
       // triangles.quadTo(60, 420, 80, 400);

        //  triangles.lineTo(150, 50);
     //   triangles.lineTo(250, 250);
    //    triangles.lineTo(50, 250);
       // triangles.quadTo(50,300, 200, 300);
        triangles.closePath();

        g2d.draw(triangles);

       // BasicStroke bs2 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);

       // BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);

       // BasicStroke bs4 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);

        //g2d.drawLine(20, 80, 250, 80);

       // g2d.setStroke(bs2);
       // g2d.drawLine(20, 120, 250, 120);

       // g2d.setStroke(bs3);
       // g2d.drawLine(20, 160, 250, 160);

       // g2d.setStroke(bs4);
       // g2d.drawLine(20, 200, 250, 200);

        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
public class GraphicFuncs extends JFrame {
    public GraphicFuncs() {
        initUI();
    }

    private void initUI() {
        add(new FuncStroke());

        setTitle("Basic shapes");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GraphicFuncs ex = new GraphicFuncs();
                ex.setVisible(true);
            }
        });
    }
}

