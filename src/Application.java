import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.security.DigestException;

public class Application extends JFrame {
    Application () {
        buildVer2();
    }

    public void buildVer1() {
        JFrame frame = this;
        JButton button;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Border Layout
        JPanel borderLayout = new JPanel(new BorderLayout());

        // Card Layout
        JPanel cardLayout = new JPanel(new CardLayout());

        JPanel firstLayout = new JPanel();
        firstLayout.add(new TextField("TThis is first layout"));

        JPanel secondLayout = new JPanel();
        secondLayout.add(new TextField("This is a second layout"));

        JPanel thirdLayout = new JPanel();
        thirdLayout.add(new TextField("This is a third layout"));

        JPanel settingsLayout = new JPanel();
        settingsLayout.add(new TextField("This is a settings layout"));
        settingsLayout.add(new JButton("Size"));
        settingsLayout.add(new JButton("Dimension"));
        settingsLayout.add(new JButton("Speed"));

        // Панель для кнопочек
        JPanel cardButtons = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.weightx = 0.0;

        JButton firstButton = new JButton("First Card");
        firstButton.setSize(new Dimension(50, 50));
        cardButtons.add(firstButton, constraints);

        constraints.gridy = 1;
        JButton secondButton = new JButton("Second Card");
        secondButton.setSize(new Dimension(50, 50));
        cardButtons.add(secondButton, constraints);

        constraints.gridy = 2;
        JButton thirdButton = new JButton("Third Card");
        thirdButton.setSize(new Dimension(50, 50));
        cardButtons.add(thirdButton, constraints);

        constraints.gridy = 100;
        constraints.anchor    = GridBagConstraints.PAGE_END;
        constraints.weighty   = 1.0;  // установить отступ
        constraints.ipady = 50;

        JButton settingsButton = new JButton("Settings");
        settingsButton.setSize(new Dimension(100, 100));
        cardButtons.add(settingsButton, constraints);

        cardButtons.setMinimumSize(new Dimension(300, 300));

        cardLayout.add(firstLayout,firstButton.toString());
        cardLayout.add(secondLayout,secondButton.toString());
        cardLayout.add(thirdLayout,thirdButton.toString());
        cardLayout.add(settingsLayout,settingsButton.toString());

        // Кладем кнопочки в бордер лайаут
        JScrollPane scroll = new JScrollPane(cardButtons);
        borderLayout.add(scroll, BorderLayout.WEST);
        borderLayout.add(cardLayout, BorderLayout.CENTER);

        frame.setContentPane(borderLayout);

        frame.pack();
        frame.setVisible(true);
    }

    public void buildVer2() {
        JFrame frame = this;
        JButton button;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Border Layout
        JPanel borderLayout = new JPanel(new BorderLayout());

        // Card Layout
        JPanel cardLayout = new JPanel(new CardLayout());

        JPanel firstLayout = new JPanel();
        firstLayout.add(new TextField("TThis is first layout"));

        JPanel secondLayout = new JPanel();
        secondLayout.add(new TextField("This is a second layout"));

        JPanel thirdLayout = new JPanel();
        thirdLayout.add(new TextField("This is a third layout"));

        JPanel settingsLayout = new JPanel();
        settingsLayout.add(new TextField("This is a settings layout"));
        settingsLayout.add(new JButton("Size"));
        settingsLayout.add(new JButton("Dimension"));
        settingsLayout.add(new JButton("Speed"));

        // Панель для кнопочек
        JPanel cardButtons = new JPanel();
        cardButtons.setLayout(new BoxLayout(cardButtons, BoxLayout.Y_AXIS));

        JButton mainButton = new JButton(".");
        mainButton.setMinimumSize(new Dimension(120,120));
        mainButton.setPreferredSize(new Dimension(120,120));
        mainButton.setMaximumSize(new Dimension(120,120));

        JButton topScrollButton = new JButton("Top Scroll");
        topScrollButton.setMinimumSize(new Dimension(96,46));
        topScrollButton.setPreferredSize(new Dimension(96,46));
        topScrollButton.setMaximumSize(new Dimension(96,46));

        JButton firstButton = new JButton("First Card");
        firstButton.setMinimumSize(new Dimension(96,96));
        firstButton.setPreferredSize(new Dimension(96,96));
        firstButton.setMaximumSize(new Dimension(96,96));

        JButton secondButton = new JButton("Second Card");
        secondButton.setMinimumSize(new Dimension(96,96));
        secondButton.setPreferredSize(new Dimension(96,96));
        secondButton.setMaximumSize(new Dimension(96,96));

        JButton thirdButton = new JButton("Third Card");
        thirdButton.setMinimumSize(new Dimension(96,96));
        thirdButton.setPreferredSize(new Dimension(96,96));
        thirdButton.setMaximumSize(new Dimension(96,96));

        JButton fourthButton = new JButton("Fourth Card");
        fourthButton.setMinimumSize(new Dimension(96,96));
        fourthButton.setPreferredSize(new Dimension(96,96));
        fourthButton.setMaximumSize(new Dimension(96,96));

        JButton fifthButton = new JButton("Fifth Card");
        fifthButton.setMinimumSize(new Dimension(96,96));
        fifthButton.setPreferredSize(new Dimension(96,96));
        fifthButton.setMaximumSize(new Dimension(96,96));

        JButton sixButton = new JButton("Six Card");
        sixButton.setMinimumSize(new Dimension(96,96));
        sixButton.setPreferredSize(new Dimension(96,96));
        sixButton.setMaximumSize(new Dimension(96,96));

        JButton seventhButton = new JButton("Seventh Card");
        seventhButton.setMinimumSize(new Dimension(96,96));
        seventhButton.setPreferredSize(new Dimension(96,96));
        seventhButton.setMaximumSize(new Dimension(96,96));

        JButton bottomScrollButton = new JButton("Bottom Scroll");
        bottomScrollButton.setMinimumSize(new Dimension(96,46));
        bottomScrollButton.setPreferredSize(new Dimension(96,46));
        bottomScrollButton.setMaximumSize(new Dimension(96,46));

        JButton settingsButton = new JButton("Settings");
        settingsButton.setMinimumSize(new Dimension(96,96));
        settingsButton.setPreferredSize(new Dimension(96,96));
        settingsButton.setMaximumSize(new Dimension(96,96));

        JPanel optButtonsPanel = new JPanel();
        optButtonsPanel.setLayout(new BoxLayout(optButtonsPanel, BoxLayout.Y_AXIS));
        optButtonsPanel.add(firstButton);
        optButtonsPanel.add(secondButton);
        optButtonsPanel.add(thirdButton);
        optButtonsPanel.add(fourthButton);
        //optButtonsPanel.add(fifthButton);
        //optButtonsPanel.add(sixButton);
        //optButtonsPanel.add(seventhButton);

        // ScrollBar
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            @Override
            public boolean isVisible() {
                return true;
            }
        };

        JScrollPane optButtonPanelScroll = new JScrollPane(optButtonsPanel);
        optButtonPanelScroll.setWheelScrollingEnabled(true);
        optButtonPanelScroll.setVerticalScrollBar(scrollBar);
        optButtonPanelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        //optButtonPanelScroll.getViewport().

        //optButtonPanelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cardButtons.add(mainButton);
        cardButtons.add(topScrollButton);
        cardButtons.add(optButtonPanelScroll);
        cardButtons.add(bottomScrollButton);
        cardButtons.add(Box.createVerticalGlue());
        cardButtons.add(settingsButton);

        //bottomScrollButton.setVisible(false);
        //topScrollButton.setVisible(false);

        //cardButtons.setPreferredSize(new Dimension(300, 300));
        cardButtons.setBackground(Color.RED);

        cardLayout.add(firstLayout,firstButton.toString());
        cardLayout.add(secondLayout,secondButton.toString());
        cardLayout.add(thirdLayout,thirdButton.toString());
        cardLayout.add(settingsLayout,settingsButton.toString());

        // Кладем кнопочки в бордер лайаут
        borderLayout.add(cardButtons, BorderLayout.WEST);
        borderLayout.add(cardLayout, BorderLayout.CENTER);

        frame.setContentPane(borderLayout);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Application app = new Application();
    }
}

