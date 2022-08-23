package mycustom;

import src.com.mytext.TextRenderer;

import javax.swing.*;
import java.awt.*;

public class SampleText extends JFrame {
        private SampleText() {

        }

        private void draw(Graphics2D g2d) {
            Rectangle bounds;

            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());



            bounds = new Rectangle(10, 10, getWidth() - 20, getHeight() - 20);

            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);
            g2d.setFont(new Font("Purisa", Font.PLAIN, 13));



            /**
             g.setColor(Color.red);
             g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

             int tx = getWidth() / 3;
             int ty = getHeight() / 3;

             g.setColor(Color.gray);
             g.drawLine(tx - 5, ty, tx + 5, ty);
             g.drawLine(tx, ty - 5, tx, ty + 5);
             g.drawLine(tx * 2 - 5, ty, tx * 2 + 5, ty);
             g.drawLine(tx * 2, ty - 5, tx * 2, ty + 5);
             g.drawLine(tx - 5, ty * 2, tx + 5, ty * 2);
             g.drawLine(tx, ty * 2 - 5, tx, ty * 2 + 5);
             g.drawLine(tx * 2 - 5, ty * 2, tx * 2 + 5, ty * 2);
             g.drawLine(tx * 2, ty * 2 - 5, tx * 2, ty * 2 + 5);
             */

        }

        @Override
        public void paint(Graphics g)
        {

            Graphics2D g2d = (Graphics2D) g;
            // draw(g2d);

        }


        public static void main(String ...args) {
            JFrame frame;
            SampleText panel = new SampleText();

            frame = new JFrame("Test TextRenderer");
            frame.setSize(400, 400);
            frame.setPreferredSize(frame.getSize());
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setVisible(true);

        }


}
