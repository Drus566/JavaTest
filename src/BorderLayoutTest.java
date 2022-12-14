

// Пример полярного расположения компонентов - BorderLayout

import java.awt.*;
import javax.swing.*;

public class BorderLayoutTest extends JFrame
{
    public BorderLayoutTest()
    {
        super("BorderLayoutTest");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(250, 250);
        // Панель содержимого
        Container container = getContentPane();
        /*
         *  Размещаем в панели компоненты
         *  В качестве параметров можно использовать
         *  строки и константы класса BorderLayout
         */
        container.add(new JButton("Север" ), "North");
        container.add(new JButton("Юг"    ), "South");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel ("Запад" ), BorderLayout.WEST);
        panel.add(new JLabel ("Запад1" ), BorderLayout.WEST);
        panel.add(new JLabel ("Запад2" ), BorderLayout.WEST);
        container.add(panel,BorderLayout.WEST);

        container.add(new JLabel ("Восток"), BorderLayout.EAST);
        // При отсутствии 2-го параметра компонент размещается в центре
        container.add(new JButton("Центр"));
        // Открываем окно
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new BorderLayoutTest();
    }
}

