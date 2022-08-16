package graphics.example;

import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedString;

public class LineBreakMeasurerExample {
    public static void main(String[] args) {
        Frame frame = new Frame("LineBreakMeasurerExample");
        frame.setSize(400, 400);
        frame.add(new CanvasToDisplay());
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class CanvasToDisplay extends Component {
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        FontRenderContext fontRenderContext = g2d.getFontRenderContext();
        Font plainFont = new Font("Times New Roman", Font.PLAIN, 24);
        AttributedString attributedString = new AttributedString("JavaTips.net");
        attributedString.addAttribute(TextAttribute.FONT, plainFont);
        LineBreakMeasurer measurer = new LineBreakMeasurer(attributedString.getIterator(), fontRenderContext);
        g2d.setColor(java.awt.Color.blue);
        g2d.setFont(plainFont);
        TextLayout layout = measurer.nextLayout(50);
        layout.draw(g2d, 10, 60);
    }
}