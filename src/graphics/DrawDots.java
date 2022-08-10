package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class DrawDots extends JPanel {
    private void doDrawing(Graphics g) {
        var g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);

        for (int i = 0; i <= 1000; i++) {
            var size = getSize();
            var insets = getInsets();

            int w = size.width - insets.left - insets.right;
            int h = size.height - insets.top - insets.bottom;

            System.out.println(w);
            System.out.println(h);

            var  r = new Random();
            int x = (Math.abs(r.nextInt()) % w) + insets.left;
            int y = (Math.abs(r.nextInt()) % h) + insets.top;
            g2d.drawLine(x, y, x, y);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
