import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEvents extends JFrame {
    public ButtonEvents() {
        super("ButtonEvents");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // получаем панель содержимого
        Container c = getContentPane();
        // создаем кнопку и помещаем ее на север окна
        JButton button = new JButton("Нажмите меня!");
        c.add(button, "North");

        // поле вывода сообщений о событиях
        info = new JTextArea("Пока событий не было\n");
        c.add(new JScrollPane(info));

        // привязываем к нашей кнопке слушателей событий
        // слушатели описаны как внутренние классы
        button.addActionListener(new ActionL());
        button.addChangeListener(new ChangeL());

        // присоединение слушателя прямо на месте
        button.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                info.append("Это вы все равно не увидите");
            }
        });

        setSize(400, 300);
        setVisible(true);
    }
    JTextArea info;

    class ActionL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            info.append("Получено сообщение о нажатии кнопки! От - "+ e.getActionCommand() + "\n");
        }
    }

    class ChangeL implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            info.append("Получено сообщение о смене состояния кнопки!\n");
            // это источник события
            Object src = e.getSource();
        }
    }

    public static void main(String[] args) {
        new ButtonEvents();
    }
}