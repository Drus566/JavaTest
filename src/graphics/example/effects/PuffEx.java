package graphics.example.effects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Puff extends JPanel implements ActionListener {

    private Timer timer;
    private int x = 1;
    private float alpha = 1;
    private final int DELAY = 15;
    private final int INITIAL_DELAY = 200;

    public Puff() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh =
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Font font = new Font("Dialog", Font.PLAIN, x);
        g2d.setFont(font);

        FontMetrics fm = g2d.getFontMetrics();
        String s = "ZetCode";
        Dimension size = getSize();

        int w = (int) size.getWidth();
        int h = (int) size.getHeight();

        int stringWidth = fm.stringWidth(s);
        AlphaComposite ac = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha);
        g2d.setComposite(ac);

        g2d.drawString(s, (w - stringWidth) / 2, h / 2);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void step() {

        x += 1;

        if (x > 40)
            alpha -= 0.01;

        if (alpha <= 0.01)
            timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
        repaint();
    }
}

public class PuffEx extends JFrame {
    public PuffEx() {

        initUI();
    }

    private void initUI() {

        setTitle("Puff");

        add(new Puff());

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                PuffEx ex = new PuffEx();
                ex.setVisible(true);
            }
        });
    }
}
