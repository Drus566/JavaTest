package graphics.example.images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class GrayScale extends JPanel {
    private Image mshi;
    private BufferedImage bufimg;
    private Dimension d;

    public GrayScale() {

        loadImage();
        determineAndSetSize();
        createGrayImage();
    }

    private void determineAndSetSize() {

        d = new Dimension();
        d.width = mshi.getWidth(null);
        d.height = mshi.getHeight(null);
        setPreferredSize(d);
    }

    private void createGrayImage() {

        bufimg = new BufferedImage(d.width, d.height,
                BufferedImage.TYPE_BYTE_GRAY);

        Graphics2D g2d = bufimg.createGraphics();
        g2d.drawImage(mshi, 0, 0, null);
        g2d.dispose();
    }

    private void loadImage() {

        mshi = new ImageIcon("resources/images/mushrooms.jpg").getImage();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bufimg, null, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

}

public class GrayScaleImage extends JFrame {
    public GrayScaleImage() {

        initUI();
    }

    private void initUI() {

        GrayScale dpnl = new GrayScale();
        add(dpnl);

        pack();

        setTitle("GrayScale image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GrayScaleImage ex = new GrayScaleImage();
                ex.setVisible(true);
            }
        });
    }
}
