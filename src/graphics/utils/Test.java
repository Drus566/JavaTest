
package graphics.utils;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Test extends JPanel
{
    private static final long serialVersionUID = 1L;
    private String text;
    private TextAlignment align;

    public static void main(String... arguments)
    {
        final Test test;
        final JFrame frame;

        test = new Test();
        test.align = TextAlignment.MIDDLE;
        test.setFont(new Font("Dialog", Font.PLAIN, 18));
        test.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();
                int tx = test.getWidth() / 3;
                int ty = test.getHeight() / 3;

                if (y < ty)
                {
                    if (x < tx)
                        test.align = TextAlignment.TOP_LEFT;
                    else if (x > tx * 2)
                        test.align = TextAlignment.TOP_RIGHT;
                    else
                        test.align = TextAlignment.TOP;
                }
                else if (y > ty * 2)
                {
                    if (x < tx)
                        test.align = TextAlignment.BOTTOM_LEFT;
                    else if (x > tx * 2)
                        test.align = TextAlignment.BOTTOM_RIGHT;
                    else
                        test.align = TextAlignment.BOTTOM;
                }
                else
                {
                    if (x < tx)
                        test.align = TextAlignment.MIDDLE_LEFT;
                    else if (x > tx * 2)
                        test.align = TextAlignment.MIDDLE_RIGHT;
                    else
                        test.align = TextAlignment.MIDDLE;
                }

                test.repaint();
            }
        });

        frame = new JFrame("Test TextRenderer");
        frame.setSize(400, 400);
        frame.setPreferredSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(test);
        frame.setVisible(true);
    }

    public Test() {
        this.text =
                "Hello world, I am some long text which should wrap to accommodate the visible region of the panel.\n\n" +
                        "As such, each line should be appropriately located on a new line, and rendered to fit the visible region.";
        this.text = "Hello world bro. Whats up ? Hello world bro. Whats up ? Hello world bro. Whats up ? Hello world bro. Whats up ? Hello world bro. Whats up ? Hello world bro. Whats up ? Hello world bro. Whats up ?";
    }

    @Override
    public void paint(Graphics g)
    {
        Rectangle bounds;

        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        bounds = new Rectangle(10, 10, getWidth() - 20, getHeight() - 20);
        bounds = TextRenderer.drawString(g, this.text, getFont(), getForeground(), bounds, align, TextFormat.FIRST_LINE_VISIBLE);

        g.setColor(Color.red);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

        System.out.println("WIDTH: " + bounds.width + ", HEIGHT: " + bounds.height);

        int tx = getWidth() / 3;
        int ty = getHeight() / 3;

//        g.setColor(Color.gray);
//        g.drawLine(tx - 5, ty, tx + 5, ty);
//        g.drawLine(tx, ty - 5, tx, ty + 5);
//        g.drawLine(tx * 2 - 5, ty, tx * 2 + 5, ty);
//        g.drawLine(tx * 2, ty - 5, tx * 2, ty + 5);
//        g.drawLine(tx - 5, ty * 2, tx + 5, ty * 2);
//        g.drawLine(tx, ty * 2 - 5, tx, ty * 2 + 5);
//        g.drawLine(tx * 2 - 5, ty * 2, tx * 2 + 5, ty * 2);
//        g.drawLine(tx * 2, ty * 2 - 5, tx * 2, ty * 2 + 5);
    }

}
