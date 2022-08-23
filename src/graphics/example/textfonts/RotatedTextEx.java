package graphics.example.textfonts;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

class RotatedText extends JPanel {

    Font font1 = new Font("Courier", Font.PLAIN, 13);
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        String s = "ZetCode, tutorials for programmers";

        Font font = new Font("Courier", Font.PLAIN, 13);

        g2d.translate(20, 20);

        FontRenderContext frc = g2d.getFontRenderContext();

        GlyphVector gv = font.createGlyphVector(frc, s);
        int length = gv.getNumGlyphs();

        for (int i = 0; i < length; i++) {

            Point2D p = gv.getGlyphPosition(i);
            double theta = (double) i / (double) (length - 1) * Math.PI / 2;
            AffineTransform at = AffineTransform.getTranslateInstance(p.getX(), p.getY());
            at.rotate(theta);

            Shape glyph = gv.getGlyphOutline(i);
            Shape transformedGlyph = at.createTransformedShape(glyph);
            g2d.fill(transformedGlyph);
        }

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }


}


class CustomText extends JPanel {
    Font font1 = new Font("Courier", Font.PLAIN, 20);

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        String s = "ZetCode, tutorials for programmers";

        Font font = new Font("Courier", Font.PLAIN, 13);

        g2d.translate(20, 20);

        FontRenderContext frc = g2d.getFontRenderContext();

        GlyphVector gv = font.createGlyphVector(frc, s);
        int length = gv.getNumGlyphs();


        for (int i = 0; i < length; i++) {

            Point2D p = gv.getGlyphPosition(i);
           // double theta = (double) i / (double) (length - 1) * Math.PI / 2;
            //AffineTransform at = AffineTransform.getTranslateInstance(p.getX(), p.getY());
            //at.rotate(theta);

            Shape glyph = gv.getGlyphOutline(i);
            //Shape transformedGlyph = at.createTransformedShape(glyph);
            g2d.fill(glyph);
        }


        g2d.dispose();
    }


    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        g.setColor(new Color(0xff5b3a20));
        // Draw the String
        g.drawString(text, x, y);

        g.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        FontMetrics fm = g.getFontMetrics(font1);
        String text = "ASDASDSA";
        System.out.println(fm.getAscent());
        System.out.println(fm.stringWidth(text));
        Rectangle2D rect=fm.getStringBounds("Some Text",g);

        g.drawString(text, 100, 100);

       //drawCenteredString(g,"privetsadsadsadsadsadasdassssssss",rect,font1);
       // doDrawing(g);
    }

}

public class RotatedTextEx extends JFrame {
    public RotatedTextEx() {

        initUI();
    }

    private void initUI() {

        add(new CustomText());

        setTitle("Rotated text");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                RotatedTextEx ex = new RotatedTextEx();
                ex.setVisible(true);
            }
        });
    }
}

