package src.com.test;

import src.com.text.TextAlignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTest extends JPanel {
    public PanelTest() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;

        Test test = new Test();
        Test test1 = new Test();

        test.align = TextAlignment.TOP_LEFT;
        test.setFont(new Font("Dialog", Font.PLAIN, 18));

        test1.align = TextAlignment.TOP_LEFT;
        test1.setFont(new Font("Dialog", Font.PLAIN, 18));

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


        test1.addMouseListener(new MouseAdapter()
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



        add(test, c);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;

        add(test1, c);
    }

    public static void main(String ...args) {
        JFrame frame;
        PanelTest panel = new PanelTest();

        frame = new JFrame("Test TextRenderer");
        frame.setSize(400, 400);
        frame.setPreferredSize(frame.getSize());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }
}
