package graphics.example.images;

import javax.swing.*;
import java.awt.*;

class DisplayImage extends JPanel {
    private Image mshi;

    public DisplayImage() {

        loadImage();
        setSurfaceSize();
    }

    private void loadImage() {

        mshi = new ImageIcon("resources/images/mushrooms.jpg").getImage();
    }

    private void setSurfaceSize() {
        Dimension d = new Dimension();
        d.width = mshi.getWidth(null);
        d.height = mshi.getHeight(null);
        setPreferredSize(d);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        /*
        The last parameter is the ImageObserver class.
        It is sometimes used for asynchronous loading.
        When we do not need asynchronous loading of our images, we can just put null there.
         */
        g2d.drawImage(mshi, 0, 0, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

}
public class DisplayImageEx extends JFrame {
    public DisplayImageEx() {

        initUI();
    }

    private void initUI() {

        add(new DisplayImage());

        pack();

        setTitle("Mushrooms");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayImageEx ex = new DisplayImageEx();
                ex.setVisible(true);
            }
        });
    }
}
