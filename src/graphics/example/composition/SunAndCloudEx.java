package graphics.example.composition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

class SunAndCloud extends JPanel implements ActionListener {
    private Image sun;
    private Image cloud;
    private Timer timer;
    private float alpha = 1f;

    private final int DELAY = 600;

    public SunAndCloud() {
        loadImages();
        initTimer();
    }

    private void loadImages() {
        sun = new ImageIcon("resources/images/sun.png").getImage();
        cloud = new ImageIcon("resources/images/cloud.png").getImage();
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        BufferedImage buffImg = new BufferedImage(220, 140, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gbi = buffImg.createGraphics();

        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

        gbi.drawImage(sun, 40, 30, null);
        gbi.setComposite(ac);
        gbi.drawImage(cloud, 0, 0, null);

        g2d.drawImage(buffImg, 20, 20, null);

        gbi.dispose();
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void step() {
        alpha -= 0.1;

        if (alpha <= 0) {
            alpha = 0;
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        repaint();
    }
}

public class SunAndCloudEx extends JFrame {
    public SunAndCloudEx() {
        initUI();
    }

    private void initUI() {
        add(new SunAndCloud());
        setTitle("Sun and Cloud");
        setSize(300, 210);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SunAndCloudEx ex = new SunAndCloudEx();
                ex.setVisible(true);
            }
        });
    }
}
