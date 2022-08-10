package graphics;

import javax.swing.*;
import java.awt.*;

public class DrawImage extends JPanel {
    private Image myImage;

    public DrawImage() {
        initPanel();
    }

    private void initPanel() {
        loadImage();
        var dm = new Dimension(myImage.getWidth(null), myImage.getHeight(null));
        setPreferredSize(dm);
    }

    private void loadImage() {
        myImage = new ImageIcon("resources/textures/texture1.png").getImage();
    }

    private void doDrawing(Graphics g) {
        var g2d = (Graphics2D) g;
        g2d.drawImage(myImage, 0, 0, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
