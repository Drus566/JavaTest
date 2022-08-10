package graphics;

import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawTexture extends JPanel {
    private BufferedImage slate;
    private BufferedImage java;
    private BufferedImage pane;

    public DrawTexture() {
        loadImages();
    }

    private void loadImages() {
        try {
            slate = ImageIO.read(new File("resources/textures/texture1.png"));
            java = ImageIO.read(new File("resources/textures/texture2.png"));
            pane = ImageIO.read(new File("resources/textures/texture3.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not load images", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void doDrawing(Graphics g) {
        var g2d = (Graphics2D) g.create();

        var slateTp = new TexturePaint(slate, new Rectangle(0,0,90,60));
        var javaTp = new TexturePaint(java, new Rectangle(0,0,90,60));
        var paneTp = new TexturePaint(pane, new Rectangle(0,0,90, 60));

        g2d.setPaint(slateTp);
        g2d.fillRect(10, 15, 90, 60);

        g2d.setPaint(javaTp);
        g2d.fillRect(130, 15, 90, 60);

        g2d.setPaint(paneTp);
        g2d.fillRect(250, 15, 90, 60);

        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
