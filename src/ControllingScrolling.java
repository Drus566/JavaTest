import javax.swing.*;
import java.awt.*;

public class ControllingScrolling extends JFrame {
    public ControllingScrolling() {
        super("ControllingScrolling");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // добавим в центр панель прокрутки с нашим компонентом
        getContentPane().add(new JScrollPane(new GridComponent()));

        // выводим окно на экран
        setSize(400, 300);
        setVisible(true);
    }

    // компонент сетка с особым редимом прокрутки
    class GridComponent extends JPanel implements Scrollable {
        // размер ячейки сетки
        private int CELL_SIZE = 20;
        // количество ячеек сетки
        private int CELL_COUNT = 50;
        // предпочтительный размер компонента
        public Dimension getPreferredSize() {
            return new Dimension(CELL_SIZE * CELL_COUNT, CELL_SIZE * CELL_COUNT);
        }

        // прорисовка компонента
        public void paintComponent(Graphics g) {
            // нужно вызвать метод базового класса
            super.paintComponent(g);
            for (int x = 0; x < CELL_COUNT; x++) {
                for (int y = 0; y < CELL_COUNT; y++) {
                    // рисуем ячейку
                    g.setColor(Color.black);
                    g.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }

        // предпочтительный размер области прокрутки
        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        // приращение при прокрутке на один элемент
        public int getScrollableUnitIncrement(Rectangle visible, int or, int dir) {
            return CELL_SIZE;
        }

        // приращение при прокрутке "блоком"
        public int getScrollableBlockIncrement(Rectangle visible, int or, int dir) {
            return CELL_SIZE * 10;
        }

        // нужно ли следить за размером области прокрутки
        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        public boolean getScrollableTracksViewportHeight() {
            return false;
        }
    }

    public static void main(String[] args) {
        new ControllingScrolling();
    }
}