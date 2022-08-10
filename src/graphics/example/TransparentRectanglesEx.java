package graphics.example;

import javax.swing.*;
import java.awt.*;

class TransparentRectangles extends JPanel {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setPaint(Color.blue);

        for (int i = 1; i <= 10; i++) {
            float alpha = i * 0.1f;
            AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);
            g2d.fillRect(50 * i, 20, 40, 40);
        }
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class TransparentRectanglesEx extends JFrame {
    public TransparentRectanglesEx() {
        initUI();
    }

    private void initUI() {
        add(new TransparentRectangles());
        setTitle("Transparent rectangles");
        setSize(590, 120);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TransparentRectanglesEx ex = new TransparentRectanglesEx();
                ex.setVisible(true);
            }
        });
    }
}
