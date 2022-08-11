package graphics.example.images;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

class FlippedImage extends JPanel {
    private Image mshi;
    private BufferedImage bufimg;
    private final int SPACE = 10;

    public FlippedImage() {

        loadImage();
        createFlippedImage();
        setSurfaceSize();
    }
    private void loadImage() {

        mshi = new ImageIcon("resources/images/mushrooms.jpg").getImage();
    }

    private void createFlippedImage() {

        bufimg = new BufferedImage(mshi.getWidth(null), mshi.getHeight(null), BufferedImage.TYPE_INT_RGB);

        Graphics gb = bufimg.getGraphics();
        gb.drawImage(mshi, 0, 0, null);
        gb.dispose();

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-mshi.getWidth(null), 0);
        /*
        In our case, the AffineTransformOp class performs scaling and translation on the image pixels.
         */
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufimg = op.filter(bufimg, null);
    }

    private void setSurfaceSize() {

        int w = bufimg.getWidth();
        int h = bufimg.getHeight();

        Dimension d = new Dimension(3*SPACE+2*w, h+2*SPACE);
        setPreferredSize(d);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        /*
         We set the preferred size for the panel.
         We calculate the size so that we can place two images on the panel and put some space between them,
         and the images and the window borders.
         */
        g2d.drawImage(mshi, SPACE, SPACE, null);
        g2d.drawImage(bufimg, null, 2*SPACE + bufimg.getWidth(), SPACE);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

}

public class FlippedImageEx extends JFrame {
    public FlippedImageEx() {

        initUI();
    }

    private void initUI() {

        add(new FlippedImage());
        pack();

        setTitle("Flipped image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlippedImageEx ex = new FlippedImageEx();
                ex.setVisible(true);
            }
        });
    }
}
